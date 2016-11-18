package com.example.matthew.gametorealese.View.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.matthew.gametorealese.View.AddGameActivity;

/**
 * Created by matthew on 18/11/2016.
 */

public class IntentsProvider {
    private Intent intent;
    private Context con;

    public IntentsProvider(Context con) {
        this.con = con;
        intent = null;
    }

    private Context getCon() {
        return con;
    }

    public void goToAddGame(Bundle bun) {
        intent = new Intent(getCon(), AddGameActivity.class);
        intent.putExtra("bun", bun);
        getCon().startActivity(intent);
    }
}
