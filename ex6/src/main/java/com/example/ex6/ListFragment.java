package com.example.ex6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListFragment extends Fragment implements  NewsAdapter.ItemClickListener{

    RecyclerView recyclerView;
    List<News> newsList;
    NewsAdapter adapter;
    public static final String APP_PREFERENCES = "settings";
    public static final String APP_PREFERENCES_RATING = "Rating";
    SharedPreferences mSettings;
    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list,container,false);

        mSettings = view.getContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        recyclerView=view.findViewById(R.id.rvNews);
        newsList=new ArrayList<>();
        News news=new News();
        newsList=news.loadNews();

        if (mSettings.contains(APP_PREFERENCES_RATING)) {
            String[] parts = mSettings.getString(APP_PREFERENCES_RATING,"").split(" ");
            float[] rating=new float[parts.length];
            for(int i=0;i< parts.length;i++){
                rating[i]=Float.valueOf(parts[i]);
            }
            for(int i=0;i< newsList.size();i++){
                newsList.get(i).setRating(rating[i]);
            }
        }


        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getRating().observe(requireActivity(), item->{
            for (Map.Entry<Integer, Float> pair : item.entrySet()) {
                newsList.get(pair.getKey()).setRating(pair.getValue());
                adapter.notifyDataSetChanged();
            }
        });

        // Create adapter passing in the sample user data
        adapter = new NewsAdapter(newsList,this);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onItemClick(News news, int position) {

        Fragment fragment=NewsFragment.newInstance(news.getUrl(),news.getRating(),position, news.getTitle());

        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
        if (diagonalInches>=6.5){
            fragmentTransaction.add(R.id.news_fragment, fragment);
        }else{
            fragmentTransaction.replace(R.id.mycontainer, fragment);
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onRatingChange(Float rating, int position) {
        HashMap<Integer,Float> newValue=new HashMap<>();
        newValue.put(position,rating);
        viewModel.setMainRating(newValue);
    }


    public void saveRating(){
        SharedPreferences.Editor editor = mSettings.edit();
        String rating="";
        for(int i=0;i< newsList.size();i++){
            rating+=Float.toString(newsList.get(i).getRating());
            rating+=" ";
            Log.d("--Rating "+i,Float.toString(newsList.get(i).getRating()));
        }
        editor.putString(APP_PREFERENCES_RATING,rating);
        editor.apply();
    }


    @Override
    public void onStop() {
        super.onStop();
        saveRating();
    }

}
