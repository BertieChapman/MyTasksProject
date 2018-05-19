package com.bertrandechapman.mytasksproject;

public abstract class AuthenticatorBase {

    public static AuthenticatorBase instance;

    public AuthenticatorBase() {
    }

    public abstract Boolean Authenticate(String email, String password);

    public abstract AuthenticatorBase getInstance();
}
