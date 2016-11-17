package com.example.matthew.gametorealese.Controller;

import android.app.Activity;

import com.example.matthew.gametorealese.Gestor.DBFirebase;
import com.example.matthew.gametorealese.Gestor.DBLocal;
import com.example.matthew.gametorealese.MainActivity;
import com.example.matthew.gametorealese.utils.interfaces.Controller;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * Created by matthew on 17/11/2016.
 */

public class MainController extends Controller {
    private DBFirebase fire;

    public MainController(Activity ins) {
        super(ins);
    }

    public void logIn(String apiKey) {
        fire.signIn(apiKey);
    }

    public GoogleSignInOptions getSession() {
        return fire.getLogin();
    }

}
