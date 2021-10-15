package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.driveit.fragment.AvailableCars1;
import com.example.driveit.fragment.AvailableCars2;
import com.example.driveit.fragment.AvailableCars3;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class AvailableCars extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cars);

        chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_best,
                true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,
                        new AvailableCars1()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener
                (i -> {
                    Fragment fragment = null;
                    switch (i) {
                        case R.id.bottom_nav_best:
                            fragment = new AvailableCars1();
                            break;
                        case R.id.bottom_nav_highest:
                            fragment = new AvailableCars2();
                            break;
                        case R.id.bottom_nav_lowest:r:
                            fragment = new AvailableCars3();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,
                                    fragment).commit();
                });
    }

}