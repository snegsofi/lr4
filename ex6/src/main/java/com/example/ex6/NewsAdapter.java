package com.example.ex6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class NewsAdapter extends
        RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView titleTextView;
        public RatingBar ratingBar;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            titleTextView=(TextView) itemView.findViewById(R.id.titleNews_TextView);
            ratingBar=(RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }

    private List<News> mNews;

    // Pass in the contact array into the constructor
    public NewsAdapter(List<News> newsList,ItemClickListener clickListener) {
        mNews = newsList;
        this.clickListener=clickListener;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_view_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // Get the data model based on position
        News news = mNews.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.titleTextView;
        textView.setText(news.getTitle());
        RatingBar ratingBar=holder.ratingBar;
        ratingBar.setRating(news.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(news,position);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                clickListener.onRatingChange(rating,position);

            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mNews.size();
    }

    private ItemClickListener clickListener;

    public interface ItemClickListener{
        void onItemClick(News news, int position);
        void onRatingChange(Float rating, int position);
    }

}
