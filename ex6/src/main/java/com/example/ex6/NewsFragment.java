package com.example.ex6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsFragment extends Fragment {

    private SharedViewModel viewModel;

    RatingBar ratingBar;
    WebView webView;

    private static final String ARG_PARAM1="param1";
    private static final String ARG_PARAM2="param2";
    private static final String ARG_PARAM4="param4";
    private static final String ARG_PARAM3="position";

    private String mParam1;
    private float mParam2;
    private int mParam3;
    private String mParam4;

    HashMap<Integer,Float> newRating;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news,container,false);

        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ratingBar=view.findViewById(R.id.ratingBarNews);
        webView=view.findViewById(R.id.browser);
        newRating=new HashMap<>();

        webView.loadUrl(mParam1);
        ratingBar.setRating(mParam2);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                HashMap<Integer,Float> ratingMap=new HashMap<>();
                ratingMap.put(mParam3,rating);
                viewModel.setRating(ratingMap);
            }
        });


        //viewModel.getMainRating().observe(requireActivity(), item->{
        //    for (Map.Entry<Integer, Float> pair : item.entrySet()) {
        //        Log.d("------po",pair.getKey().toString());
        //        newRating.put(pair.getKey(),pair.getValue());
        //        mParam2=pair.getValue();
        //        ratingBar.setRating(mParam2);
        //    }
        //});
//
        //for (Map.Entry<Integer, Float> pair : newRating.entrySet()) {
        //    Log.d("------po",pair.getKey().toString());
        //    if(pair.getKey().equals(mParam3)){
        //        ratingBar.setRating(pair.getValue());
        //    }
        //}


        return view;
    }

    public static NewsFragment newInstance(String param1, float param2, Integer param3, String param4) {

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putFloat(ARG_PARAM2,param2);
        args.putInt(ARG_PARAM3,param3);
        args.putString(ARG_PARAM4,param4);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null){
            mParam1=getArguments().getString(ARG_PARAM1);
            mParam2=getArguments().getFloat(ARG_PARAM2);
            mParam3=getArguments().getInt(ARG_PARAM3);
            mParam4=getArguments().getString(ARG_PARAM4);
        }
    }
}
