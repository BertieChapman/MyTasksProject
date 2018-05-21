package com.bertrandechapman.mytasksproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView mPasswordView;
    private TextView mEmailView;
    private ProgressBar mProgressBar;
    private Button mSignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPasswordView = findViewById(R.id.txtPassword);
        mEmailView = findViewById(R.id.txtUsername);
        mProgressBar = findViewById(R.id.pbLogin);
        mSignInBtn = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onSignInClick(View v) {

        Log.i("Event", "Sign in clicked");

        CharSequence email = mEmailView.getText();
        CharSequence password = mPasswordView.getText();

        mProgressBar.setVisibility(View.VISIBLE);
        mSignInBtn.setVisibility(View.INVISIBLE);

        mAuth.signInWithEmailAndPassword(email.toString(), password.toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                mSignInBtn.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);

                if (task.isSuccessful()) {
                    Log.i("Event", "Success");
                    Intent intent = new Intent(getBaseContext(), TaskList.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.i("Event", "Unsuccessful");
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Boolean isEmailValid(CharSequence email) {

        return true;
    }
}
