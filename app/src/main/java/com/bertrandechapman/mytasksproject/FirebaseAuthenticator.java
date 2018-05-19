package com.bertrandechapman.mytasksproject;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthenticator extends AuthenticatorBase {

    private FirebaseAuth mAuth;

    @Override
    public Boolean Authenticate(String email, String password) {
        return null;
    }

    @Override
    public AuthenticatorBase getInstance() {
        if (instance == null) {
            instance = new FirebaseAuthenticator();
        }

        return instance;
    }
}
