package com.example.signlingo.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.signlingo.R;
import com.example.signlingo.activities.Course1;

public class LearnFragment extends Fragment {

    ImageButton btnCourse1;
    ImageButton btnCourse2;
    ImageButton btnCourse3;
    ImageButton btnCourse4;
    public boolean[] isCourseDone = {false, false, false, false};

    public LearnFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learn, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCourse1 = view.findViewById(R.id.btnCourse1);
        btnCourse2 = view.findViewById(R.id.btnCourse2);
        btnCourse3 = view.findViewById(R.id.btnCourse3);
        btnCourse4 = view.findViewById(R.id.btnCourse4);

        if (isCourseDone[0]){
            btnCourse1.setImageResource(R.drawable.ic_baseline_check_circle_96);
            btnCourse1.setBackgroundColor(Color.GREEN);
        }

        btnCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Course1.class);
                startActivity(intent);
                btnCourse1.setImageResource(R.drawable.ic_baseline_check_circle_96);
                btnCourse1.setBackgroundColor(Color.GREEN);
                isCourseDone[0] = true;
            }
        });
        btnCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getContext(), Course2.class);
                //startActivity(intent);
            }
        });
        btnCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display message that says you have to beat the previous courses.
            }
        });
        btnCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display message that says you have to beat the previous courses.
            }
        });
    }
}