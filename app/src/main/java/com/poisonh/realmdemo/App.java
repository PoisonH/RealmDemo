package com.poisonh.realmdemo;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by PoisonH on 2016/7/15.
 */
public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("mydb.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                // .migration(new Migration())
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
