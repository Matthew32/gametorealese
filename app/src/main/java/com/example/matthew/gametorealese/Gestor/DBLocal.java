package com.example.matthew.gametorealese.Gestor;

import android.content.Context;

import java.util.List;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by matthew on 02/11/16.
 */

public class DBLocal {

    private RealmConfiguration realmConfig;
    private DynamicRealm realm;
    private Realm connection;
    public DBLocal(Context con) {

        Realm.init(con);
        getInstance();
    }
    protected void getInstance(){

        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        connection = Realm.getDefaultInstance();


    }
    public <T extends RealmObject> boolean save(T object , Class<T> classRepresentingObject){
        boolean result = false;
        try{
            connection.copyToRealmOrUpdate(object);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public <T extends RealmObject> boolean delete(String characterToSearch, int idSearch, T object , Class<T> classRepresentingObject){
        boolean result = false;
        try{
            RealmResults<T> list = (RealmResults<T>) realm.where(classRepresentingObject.toString()).equalTo(characterToSearch,idSearch).findAll();
            list.deleteAllFromRealm();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public <T extends RealmObject> List<T> findAll(T object , Class<T> classRepresentingObject){
        RealmResults<T> result = null;
        try{
            result = (RealmResults<T>) realm.where(classRepresentingObject.toString()).findAll();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public <T extends RealmObject> List<T> find(String characterToSearch, int idSearch, T object , Class<T> classRepresentingObject){
        RealmResults<T> result = null;
        try{
             result = (RealmResults<T>) realm.where(classRepresentingObject.toString()).equalTo(characterToSearch,idSearch).findAll();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
