package com.example.matthew.gametorealese.Controller;

import android.content.Context;

import com.example.matthew.gametorealese.Gestor.DBLocal;
import com.example.matthew.gametorealese.Model.Game;

/**
 * Created by matthew on 02/11/16.
 */

public class Persistency {
    private DBLocal dao;
    private Context con;
    public Persistency(Context con) {
        if(dao == null){
            this.dao = new DBLocal(con);
        }
    }
    public void createGame(String name , String date , int gonnaBuy){
        Game game = new Game(name,date,gonnaBuy);
        dao.save(game,Game.class);
    }
}
