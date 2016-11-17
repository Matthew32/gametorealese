package com.example.matthew.gametorealese.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matthew.gametorealese.Model.Game;
import com.example.matthew.gametorealese.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by matthew on 02/11/16.
 */

public class AdapterListView extends ArrayAdapter<Game> {
    private Context context;

    public AdapterListView(Context context, int resource, List<Game> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public int getPosition(Game item) {
        return super.getPosition(item);
    }

    @Nullable
    @Override
    public Game getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
/*
        android:id="@+id/ig_iv_photo"


        android:id="@+id/ig_tv_name"


        android:id="@+id/ig_tv_description"

        android:id="@+id/ig_tv_realese"


*
*
* */
        Game game = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_game, parent, false);

            viewHolder.name = (TextView) convertView.findViewById(R.id.ig_tv_name);

            viewHolder.description = (TextView) convertView.findViewById(R.id.ig_tv_description);
            viewHolder.realese = (TextView) convertView.findViewById(R.id.ig_tv_realese);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.ig_iv_photo);

            // Cache the viewHolder object inside the fresh view

            convertView.setTag(viewHolder);

        } else {

            // View is being recycled, retrieve the viewHolder object from tag

            viewHolder = (ViewHolder) convertView.getTag();

        }

        // Populate the data from the data object via the viewHolder object

        // into the template view.

        viewHolder.name.setText(game.getName());

        viewHolder.description.setText(game.getDescription());

        viewHolder.realese.setText(game.getRealeseDate());

        Picasso.with(context)
                .load(game.getPhoto())
                .into(viewHolder.photo);
        // Return the completed view to render on screen

        return convertView;
        //return super.getView(position, convertView, parent);
    }
    // View lookup cache

    private static class ViewHolder {

        TextView name;

        TextView description;

        TextView realese;

        ImageView photo;
    }
}
