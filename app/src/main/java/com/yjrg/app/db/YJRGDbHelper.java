package com.yjrg.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.yjrg.app.MainApp;

/**
 * Created by Administrator on 2014/6/11.
 */
public class YJRGDbHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "yjrg.db";

    private final static int DATABASE_VERSION = 1;
    private static YJRGDbHelper sYJRGDbHelper;

    public YJRGDbHelper(Context mContent){
        super(mContent, DB_NAME, null, DATABASE_VERSION);
    }

    private YJRGDbHelper() {
        super(MainApp.getInstance(), DB_NAME, null, DATABASE_VERSION);
    }

    public static YJRGDbHelper getInstance() {

        if (sYJRGDbHelper == null) {
            sYJRGDbHelper = new YJRGDbHelper();
        }

        return sYJRGDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
