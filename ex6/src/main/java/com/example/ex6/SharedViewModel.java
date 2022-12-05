package com.example.ex6;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<HashMap<Integer,Float>> rating=new MutableLiveData<>();
    private MutableLiveData<HashMap<Integer,Float>> mainRating=new MutableLiveData<>();

    public void setRating(HashMap<Integer,Float> input){
        rating.setValue(input);
    }

    public LiveData<HashMap<Integer,Float>> getRating(){
        return rating;
    }

    public void setMainRating(HashMap<Integer,Float> input){
        mainRating.setValue(input);
    }

    public LiveData<HashMap<Integer,Float>> getMainRating(){
        return mainRating;
    }
}
