package com.example.matthew.gametorealese.Gestor;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;

import com.example.matthew.gametorealese.Model.Game;
import com.example.matthew.gametorealese.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthew on 17/11/2016.
 */

public class DBFirebase {
    // Configure Google Sign In
    private GoogleSignInOptions gso;
    private Firebase ref;
    private Context con;

    public DBFirebase(Context con) {
        if (this.con == null) {
            this.con = con;
            Firebase.setAndroidContext(con);
            ref = new Firebase(Config.FIREBASE_URL_GAMEDATA);
        }

    }


    public void signIn(String api) {
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(api)
                .requestEmail()
                .build();
    }

    public GoogleSignInOptions getLogin() {
        return gso;
    }

    public List<Game> getGameData() {
        final List<Game> gamesToExport = new ArrayList<>();
        ref.limitToFirst(10);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              //  for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    Game game = new Game();
                    game.setName((String) dataSnapshot.child("name").getValue());
                    game.setPhoto((String) dataSnapshot.child("photo").getValue());
                    game.setRealeseDate((String) dataSnapshot.child("realese_day").getValue());
                    game.setDescription((String) dataSnapshot.child("description").getValue());
                    gamesToExport.add(game);
                //}
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        return gamesToExport;
    }
}
