package com.example.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
implements FirstFragment.FirstFragmentReceiver,
SecondFragment.SecondFragmentReceiver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Интерфейс первого фрагмента
    // Выполняется при получении данных от первого фрагмента
    public void firstReceive(String data){
        SecondFragment secondFragment=(SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_second);
        secondFragment.dataReceived(data);
    }

    // Интерфейс второго фрагмента
    // Выполняется при получении данных от второго фрагмента
    public void secondReceive(String data){
        FirstFragment firstFragment=(FirstFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_first);
        firstFragment.dataReceived(data);
    }

}