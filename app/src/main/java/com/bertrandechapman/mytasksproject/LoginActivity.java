package com.bertrandechapman.mytasksproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView mPasswordView;
    private TextView mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPasswordView = (TextView) findViewById(R.id.txtPassword);
        mEmailView = (TextView) findViewById(R.id.txtUsername);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onSignInClick(View v) {

        Log.i("Event", "Sign in clicked");

        mAuth.signInWithEmailAndPassword(mEmailView.getText().toString(), mPasswordView.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Log.i("Event", "Success");
                } else {
                    Log.i("Event", "Unsuccessful");
                }
            }
        });
    }
}
