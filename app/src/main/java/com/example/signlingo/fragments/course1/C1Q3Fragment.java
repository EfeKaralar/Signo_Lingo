package com.example.signlingo.fragments.course1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.signlingo.R;
import com.example.signlingo.activities.Course1;

public class C1Q3Fragment extends Fragment {

    public C1Q3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c1_q3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnNext = getActivity().findViewById(R.id.btnNext);
        btnNext.setEnabled(false);

        ImageButton btnA = view.findViewById(R.id.ibQ3A);
        ImageButton btnB = view.findViewById(R.id.ibQ3B);
        ImageButton btnC = view.findViewById(R.id.ibQ3C);
        ImageButton btnD = view.findViewById(R.id.ibQ3D);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA.setBackgroundColor(Color.GREEN);
                btnNext.setEnabled(true);
                Toast.makeText(getContext(), "Right Answer", Toast.LENGTH_SHORT).show();
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnB.setBackgroundColor(Color.RED);
                Toast.makeText(getContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnC.setBackgroundColor(Color.RED);
                Toast.makeText(getContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnD.setBackgroundColor(Color.RED);
                Toast.makeText(getContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
            }
        });
    }
}