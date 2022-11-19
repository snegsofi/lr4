package com.example.ex3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    // Виджеты
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    // Нужный фрагменты интерфейс
    // Интерфейс получателя сообщений от этого фрагмента
    public interface SecondFragmentReceiver{
        public void secondReceive(String data);
    }

    // Метод жизниннего цикла фрагмента
    // Вызывается андроидом, когда фрагмент должен создать свой внешний вид


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_second, container,false);

        receiveData=view.findViewById(R.id.second_data);
        dataToSend=view.findViewById(R.id.second_text);
        sendData=view.findViewById(R.id.second_post);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Если есть ссылка на кого-то, кто
                // реализует нужный интерфейс
                if(secondReceiver!=null){
                    String data=dataToSend.getText().toString();
                    // вызовем его функцию
                    secondReceiver.secondReceive(data);
                }
            }
        });

        return view;
    }

    // Чтобы передать данные во фрагмент
    void dataReceived(String data){
        receiveData.setText(data);
    }

    // Ссылка на кого-то, кто реализует интерфейс
    private SecondFragment.SecondFragmentReceiver secondReceiver;

    // Метод жизненного цикла фрагмента
    // Выполняется когда фрагмент подсоединяется к активности
    // Передается активити
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Проверяем, реализует ли активити нужный интерфейс
        if(context instanceof SecondFragment.SecondFragmentReceiver){
            // если да, сохраняем ссылку
            secondReceiver =(SecondFragment.SecondFragmentReceiver) context;
        }
    }

    // Метод жизненного цикла фрагмента
    // Выполняется когда фрагмент отсоединяется от активности
    // Чтобы не произошло утечки ресурсов
    // (через хранение во фрагмента ссылки на активити)
    // занулим ссылку на интерфейс
    @Override
    public void onDetach() {
        super.onDetach();
    }
}