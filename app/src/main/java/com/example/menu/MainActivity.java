package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        setFragment(new FirstFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.first_item) {
                setFragment(new FirstFragment());
                return true;
            } else if (item.getItemId() == R.id.second_item) {
                setFragment(new SecondFragment());
                return true;
            } else if (item.getItemId() == R.id.third_item) {
                setFragment(new ThirdFragment());
                return true;
            }
            return false;
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_encyclopedia) {
                Toast.makeText(MainActivity.this, "Квадроберская энциклопедия", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_tricks) {
                Toast.makeText(MainActivity.this, "Трюки и навыки", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_costumes) {
                Toast.makeText(MainActivity.this, "Костюмы и аксессуары", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_community_forum) {
                Toast.makeText(MainActivity.this, "Форум сообщества", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_gallery) {
                Toast.makeText(MainActivity.this, "Галерея", Toast.LENGTH_SHORT).show();
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.frag_first) {
            fragment = new FirstFragment();
        } else if (id == R.id.frag_two) {
            fragment = new SecondFragment();
        }

        if (fragment != null) {
            setFragment(fragment);
        }
        return true;
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .addToBackStack(null)
                .commit();
    }
}
