package com.example.matthew.gametorealese.Controller;

import android.app.Activity;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.matthew.gametorealese.Gestor.DBFirebase;
import com.example.matthew.gametorealese.Model.Game;
import com.example.matthew.gametorealese.utils.interfaces.Controller;

import java.util.List;

/**
 * Created by matthew on 17/11/2016.
 */

public class GamesShowController extends Controller {
    private DBFirebase db;

    public GamesShowController(Activity ins) {
        super(ins);
        db = new DBFirebase(ins);
    }

    public List<Game> getGames() {
        return db.getGameData();
    }

    public void setList(ListView lv, ProgressBar loading) {
        db.getGameData(lv, loading);
    }
}
