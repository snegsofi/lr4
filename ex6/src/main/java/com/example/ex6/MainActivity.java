package com.example.ex6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListFragment signInFragment=new ListFragment();
        FragmentManager fragmentManager =getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mycontainer,signInFragment)
                .commit();
    }
}