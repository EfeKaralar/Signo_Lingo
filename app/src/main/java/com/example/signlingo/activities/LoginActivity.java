package com.example.signlingo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.signlingo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    private FirebaseAuth auth;
    Context context = this;

    EditText etEmail;
    EditText etPass;
    Button btnLogin;
    Button btnRegister;
    Button btnAnonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmailLogin);
        etPass = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnAnonLogin = findViewById(R.id.btnAnonLogin);

        if(auth.getCurrentUser() != null) {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText() != null && etPass != null){
                    String email = etEmail.getText().toString();
                    String pass = etPass.getText().toString();
                    auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(context, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "Successfully logged in");
                                Intent i = new Intent(context, MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else{
                                Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "Failed logging in");
                            }
                        }
                    });
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, RegistrationActivity.class);
                startActivity(i);
            }
        });

        btnAnonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInAnonymously();
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

    }
}