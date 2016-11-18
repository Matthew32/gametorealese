package com.example.matthew.gametorealese.View;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.matthew.gametorealese.Controller.GamesShowController;
import com.example.matthew.gametorealese.R;
import com.example.matthew.gametorealese.View.utils.IntentsProvider;
import com.example.matthew.gametorealese.utils.interfaces.Activity;

/**
 * Created by matthew on 17/11/2016.
 */

public class GameShowActivity extends Activity {
    private GamesShowController controller;
    private IntentsProvider provider;
    private GameShowActivity ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_show);
        setResources();
    }


    @Override
    protected void setResources() {
        // set list view of items
        controller = new GamesShowController(this);
        ins = this;
        provider = new IntentsProvider(this);
        lv = (ListView) findViewById(R.id.gs_lv_games);
        loading = (ProgressBar) findViewById(R.id.loading);
    }

    @Override
    protected void setResourcesFormat() {
        lv.setVisibility(View.INVISIBLE);
        new Thread() {
            @Override
            public void run() {
                super.run();
                controller.setList(lv, loading);
            }
        }.run();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_games_show, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mg_im_add:
                provider.goToAddGame(new Bundle());
                return true;
            case R.id.mg_im_help:
                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void setEvents() {

    }

    private ProgressBar loading;
    private ListView lv;
}
