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

public class RegistrationActivity extends AppCompatActivity {

    public static final String TAG = "RegistrationActivity";
    Context context = this;

    private FirebaseAuth auth;
    EditText etEmail;
    EditText etPass1;
    EditText etPass2;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        auth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmailReg);
        etPass1 = findViewById(R.id.etPassword1);
        etPass2 = findViewById(R.id.etPassword2);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass;
                if(etPass1.getText().toString().equals(etPass2.getText().toString())){
                    pass = etPass1.getText().toString();
                }
                else{
                    Toast.makeText(RegistrationActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "createUserWithEmailAndPassword successful" + email + pass);
                            Intent i = new Intent(context, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "createUserWithEmailAndPassword failed" );
                        }
                    }
                });
            }
        });
    }
}