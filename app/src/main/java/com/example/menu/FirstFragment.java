package com.example.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textView = view.findViewById(R.id.text_view);
        registerForContextMenu(textView);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Выберите животное");
        menu.add(0, 1, 0, "Кошечка");
        menu.add(0, 2, 0, "Собачка");
        menu.add(0, 3, 0, "Волчонок");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                textView.setText("Выбрана маска кошечки");
                return true;
            case 2:
                textView.setText("Выбрана маска собачки");
                return true;
            case 3:
                textView.setText("Выбрана маска волчонка");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}