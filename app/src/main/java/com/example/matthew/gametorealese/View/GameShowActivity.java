package com.example.matthew.gametorealese.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.matthew.gametorealese.Controller.Adapter.AdapterListView;
import com.example.matthew.gametorealese.Controller.GamesShowController;
import com.example.matthew.gametorealese.Controller.MainController;
import com.example.matthew.gametorealese.MainActivity;
import com.example.matthew.gametorealese.Model.Game;
import com.example.matthew.gametorealese.R;
import com.example.matthew.gametorealese.utils.interfaces.Activity;

import java.util.List;

/**
 * Created by matthew on 17/11/2016.
 */

public class GameShowActivity extends Activity {
    private GamesShowController controller;
    private GameShowActivity ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_show);
        controller = new GamesShowController(this);
        ins = this;
        setResources();
    }


    @Override
    protected void setResources() {
        // set list view of items
        lv = (ListView) findViewById(R.id.gs_lv_games);
        List<Game> list = controller.getGames();
        AdapterListView adapter = new AdapterListView(this, R.layout.item_game, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void setEvents() {

    }

    private ListView lv;
}
