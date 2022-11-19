package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void b1Click(View view){
        FirstActivity firstActivity=new FirstActivity();

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.host,firstActivity);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void b2Click(View view){

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.host,GenericFragment.newInstance(0x99FF0000, "Second"));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void b3Click(View view){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.host,
                GenericFragment.newInstance(0x9900FF00,"Третий"));
        transaction.addToBackStack(null);
        transaction.commit();
    }

}