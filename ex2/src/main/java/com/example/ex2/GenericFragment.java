package com.example.ex2;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GenericFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        // Иницализируем данными из бандла, если он не нулевой
        if(bundle!=null){
            // Проверяем, есть ли нужные ключи
            if(bundle.containsKey(FRAGMENT_TITLE)){
                title=bundle.getString(FRAGMENT_TITLE);
            }
            if(bundle.containsKey(FRAGMENT_COLOR)){
                backgroundColor=bundle.getInt(FRAGMENT_COLOR);
            }
            // Получим данные
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Создаем иерархию вью
        View view=inflater.inflate(R.layout.fragment_generic, container,false);

        // Найдем нужные вью
        RelativeLayout relative=view.findViewById(R.id.relative);
        TextView text=view.findViewById(R.id.text);

        // Поменяем их атрибуты
        relative.setBackgroundColor(backgroundColor);
        text.setText(title);

        return view;
    }

    // Параметры view, которые будем менять -
    // инициализируются в констурукторе
    private int backgroundColor;
    private String title;

    // Ключи для сохранения настроек
    private static final String FRAGMENT_COLOR="FRAGMENT_COLOR";
    private static final String FRAGMENT_TITLE="FRAGMENT_TITLE";

    // Статический инициализатор
    // 1. Создает фрагмент
    // 2. Создает бандл
    // 3. Создает в бандл аргументы
    // 4. Присоединяет бандл к возвращаемому фрагменту
    // Инициализация параметрами из бандла происходит в OnCreate
    // Используется для создания фрагментов которым нужно передать
    // входные параметры (возможно различные)

    public static GenericFragment newInstance(int color, String data){
        GenericFragment fragment=new GenericFragment();
        //Bundle необходим для временного хранения данных в процессе выполнения.
        // Это обличный выбор при передаче данных между активностями. Это способ для сохранения данных при смене ориентации экрана.
        // Вообщем это сохраненные данные, которые система использует для восстановления предыдущего состояния.
        // Представляет собой набор пар ключ-значение.
        Bundle bundle=new Bundle();

        bundle.putInt(FRAGMENT_COLOR, color);
        bundle.putString(FRAGMENT_TITLE, data);

        fragment.setArguments(bundle);

        return fragment;

    }
}