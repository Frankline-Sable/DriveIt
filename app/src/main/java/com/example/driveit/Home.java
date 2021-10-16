package com.example.driveit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.driveit.fragment.HomeDefaultFragment;
import com.example.driveit.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.driveit.databinding.ActivityHomeBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;


    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chipNavigationBar = findViewById(R.id.nav_view);
        chipNavigationBar.setItemSelected(R.id.navigation_home,
                true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_activity_home,
                        new HomeFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.showBadge(R.id.navigation_user, 4);
        chipNavigationBar.setOnItemSelectedListener
                (new ChipNavigationBar.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(int i) {
                        Fragment fragment = null;
                        switch (i) {
                            case R.id.navigation_home:
                                fragment = new HomeFragment();
                                break;
                            default:
                                fragment = new HomeDefaultFragment();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment_activity_home,
                                        fragment).commit();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_home_menu, menu);
        return true;
    }
}