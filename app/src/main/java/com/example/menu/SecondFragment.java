package com.example.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button button = view.findViewById(R.id.button_show_menu);
        TextView counterTextView = view.findViewById(R.id.counter_text_view);

        counterTextView.setText("Счетчик: " + counter);

        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), button);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.increment) {
                    counter++;
                } else if (item.getItemId() == R.id.decrement) {
                    counter--;
                }
                counterTextView.setText("Счетчик: " + counter);
                return true;
            });
            popupMenu.show();
        });

        return view;
    }
}