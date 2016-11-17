package com.example.matthew.gametorealese.Model;

import io.realm.RealmObject;

/**
 * Created by matthew on 02/11/16.
 */

public class Game extends RealmObject {
    private String name;
    private String realeseDate;
    private String photo;
    private String description;
    private long gonnaBuy;

    public Game() {
    }

    public Game(String name, String realeseDate, long gonnaBuy) {
        this.name = name;
        this.realeseDate = realeseDate;
        this.gonnaBuy = gonnaBuy;
    }

    public Game(String name, String realeseDate) {
        this.name = name;
        this.realeseDate = realeseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(String realeseDate) {
        this.realeseDate = realeseDate;
    }

    public long getGonnaBuy() {
        return gonnaBuy;
    }

    public void setGonnaBuy(long gonnaBuy) {
        this.gonnaBuy = gonnaBuy;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", realeseDate='" + realeseDate + '\'' +
                ", gonnaBuy=" + gonnaBuy +
                '}';
    }
}
