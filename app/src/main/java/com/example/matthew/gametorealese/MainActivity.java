package com.example.matthew.gametorealese;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.example.matthew.gametorealese.Controller.MainController;
import com.example.matthew.gametorealese.View.GameShowActivity;
import com.example.matthew.gametorealese.utils.interfaces.Activity;
import com.google.android.gms.auth.api.Auth;

public class MainActivity extends Activity {
    private MainController controller;
    private MainActivity ins;
    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);
        ins = this;
        //make session start in google
        //  controller.logIn(getString(R.string.default_web_client_id));
        //   Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(controller.getSession());//  startActivityForResult(signInIntent, RC_SIGN_IN);
    /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(ins, GameShowActivity.class);
                ins.startActivity(mainIntent);
                //ins.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    protected void setResources() {

    }

    @Override
    protected void setEvents() {

    }
}
