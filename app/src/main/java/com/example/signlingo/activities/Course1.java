package com.example.signlingo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.signlingo.R;
import com.example.signlingo.fragments.LearnFragment;
import com.example.signlingo.fragments.course1.C1LearnFragment;
import com.example.signlingo.fragments.course1.C1Q1Fragment;
import com.example.signlingo.fragments.course1.C1Q2Fragment;
import com.example.signlingo.fragments.course1.C1Q3Fragment;
import com.example.signlingo.fragments.course1.C1Q4Fragment;
import com.example.signlingo.fragments.course1.C1Q5Fragment;

import java.util.List;

public class Course1 extends AppCompatActivity {

    Button btnNext;
    Button btnPrev;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course1);

        FragmentManager fragmentManager = getSupportFragmentManager();

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        Fragment fragment0 = new C1LearnFragment();
        Fragment fragment1 = new C1Q1Fragment();
        Fragment fragment2 = new C1Q2Fragment();
        Fragment fragment3 = new C1Q3Fragment();
        Fragment fragment4 = new C1Q4Fragment();
        Fragment fragment5 = new C1Q5Fragment();

        Fragment[] fragments = new Fragment[]{fragment0, fragment1, fragment2, fragment3, fragment4, fragment5 };

        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[0]).commit();
        final String[] currentFragment = new String[1];
        currentFragment[0] = "0";

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Integer.parseInt(currentFragment[0])){
                    case 0:
                        currentFragment[0] = "1";
                        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[1]).commit();
                        break;
                    case 1:
                        currentFragment[0] = "2";
                        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[2]).commit();
                        break;
                    case 2:
                        currentFragment[0] = "3";
                        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[3]).commit();
                        break;
                    case 3:
                        currentFragment[0] = "4";
                        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[4]).commit();
                        break;
                    case 4:
                        currentFragment[0] = "5";
                        fragmentManager.beginTransaction().replace(R.id.course1Container, fragments[5]).commit();
                        btnNext.setText("FINISH");
                        btnNext.setBackgroundColor(Color.RED);
                        break;
                    case 5:
                        currentFragment[0]="0";
                        Intent intent = new Intent(context, MainActivity.class);
                        // LearnFragment
                        startActivity(intent);
                        finish();


                }
            }
        });
    }
}