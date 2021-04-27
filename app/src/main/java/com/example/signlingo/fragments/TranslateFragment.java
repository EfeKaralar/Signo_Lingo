package com.example.signlingo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.signlingo.R;

import java.sql.Time;

public class TranslateFragment extends Fragment {

    public static final String TAG = "TranslateFragment";

    EditText etTranslator;
    Button btnTranslate;
    ImageView ivTranslation;

    public TranslateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translate, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTranslator = view.findViewById(R.id.etTranslator);
        btnTranslate = view.findViewById(R.id.btnTranslate);
        ivTranslation = view.findViewById(R.id.ivTranslation);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    translate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void translate() throws InterruptedException {
        if (etTranslator.getText() == null){
            Toast.makeText(getContext(), "Please enter something to the translator", Toast.LENGTH_SHORT).show();
            return;
        }
        String text = etTranslator.getText().toString().toLowerCase();
        int i = 0;
        while (i<text.length()){
            int j = i;
            textToImage(text, j);
            i++;

        }
    }
    public void textToImage(String text, int i){

        if (text.substring(i).equals(" ")){
            ivTranslation.setImageResource(R.drawable.ic_baseline_space_bar_24);
        }
        else {
            String letter = text.substring(i).toLowerCase();
            Log.d(TAG, "textToImage letter: "+ letter);
            switch (letter) {
                case "a":
                    ivTranslation.setImageResource(R.drawable.a);
                    break;
                case "b":
                    ivTranslation.setImageResource(R.drawable.b);
                    break;
                case "c":
                    ivTranslation.setImageResource(R.drawable.c);
                    break;

                case "d":
                    ivTranslation.setImageResource(R.drawable.d);
                    break;

                case "e":
                    ivTranslation.setImageResource(R.drawable.e);
                    break;

                case "f":
                    ivTranslation.setImageResource(R.drawable.f);
                    break;

                case "g":
                    ivTranslation.setImageResource(R.drawable.g);
                    break;

                case "h":
                    ivTranslation.setImageResource(R.drawable.h);
                    break;

                case "i":
                    ivTranslation.setImageResource(R.drawable.i);
                    break;

                case "j":
                    ivTranslation.setImageResource(R.drawable.j);
                    break;

                case "k":
                    ivTranslation.setImageResource(R.drawable.k);
                    break;

                case "l":
                    ivTranslation.setImageResource(R.drawable.l);
                    break;

                case "m":
                    ivTranslation.setImageResource(R.drawable.m);
                    break;

                case "n":
                    ivTranslation.setImageResource(R.drawable.n);
                    break;

                case "o":
                    ivTranslation.setImageResource(R.drawable.o);
                    break;

                case "p":
                    ivTranslation.setImageResource(R.drawable.p);
                    break;

                case "q":
                    ivTranslation.setImageResource(R.drawable.q);
                    break;

                case "r":
                    ivTranslation.setImageResource(R.drawable.r);
                    break;

                case "s":
                    ivTranslation.setImageResource(R.drawable.s);
                    break;

                case "t":
                    ivTranslation.setImageResource(R.drawable.t);
                    break;

                case "u":
                    ivTranslation.setImageResource(R.drawable.u);
                    break;

                case "v":
                    ivTranslation.setImageResource(R.drawable.v);
                    break;

                case "w":
                    ivTranslation.setImageResource(R.drawable.w);
                    break;

                case "x":
                    ivTranslation.setImageResource(R.drawable.x);
                    break;

                case "y":
                    ivTranslation.setImageResource(R.drawable.y);
                    break;

                case "z":
                    ivTranslation.setImageResource(R.drawable.z);
                    break;

            }
        }
    }
}