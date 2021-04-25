package com.example.signlingo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.signlingo.R;
import com.example.signlingo.fragments.LearnFragment;
import com.example.signlingo.fragments.ProfileFragment;
import com.example.signlingo.fragments.TranslateFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        // define your fragments here
        final Fragment fragment_learn = new LearnFragment();
        final Fragment fragment_translate = new TranslateFragment();
        final Fragment fragment_profile = new ProfileFragment();
        //default fragment
        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment_learn).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_learn:
                        fragment = fragment_learn;
                        break;
                    case R.id.action_translate:
                        fragment = fragment_translate;
                        break;
                    case R.id.action_profile:
                        fragment = fragment_profile;
                        break;
                    default:
                        fragment = fragment_learn;
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
    }
}