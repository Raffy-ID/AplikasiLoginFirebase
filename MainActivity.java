package com.example.aplikasiloginfirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button btSignIn;
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle
    savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSignIn = findViewById(R.id.bt_signin);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        //Melakukan inisialisasi pada Autentikasi Firebase Google
        mAuth = FirebaseAuth.getInstance();
        //Melakukan pengecekan, apakah user telah sign in
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        // FirebaseMessaging.getInstance().subscribeToTopic("all");
    }


    // Melakukan Autentikasi pada email
    private void signIn() {

    mAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login dibatalkan", Toast.LENGTH_SHORT).show();

                }
            }
        }
    });
    }
}
