package com.yjrg.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.yjrg.app.MainApp;

/**
 * Created by Administrator on 2014/6/11.
 */
public class CollegeDbHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "yjrg.db";

    private final static int DATABASE_VERSION = 1;
    private static CollegeDbHelper sCollegeDbHelper;

//    private Dao<University, Integer> mUniversityDao;

    public CollegeDbHelper(Context mContent){
        super(mContent, DB_NAME, null, DATABASE_VERSION);
    }

    private CollegeDbHelper() {
        super(MainApp.getInstance(), DB_NAME, null, DATABASE_VERSION);
    }

    public static CollegeDbHelper getInstance() {

        if (sCollegeDbHelper == null) {
            sCollegeDbHelper = new CollegeDbHelper();
        }

        return sCollegeDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }


//    public synchronized Dao<University, Integer> getUniversityDao() throws SQLException {
//
//        if (mUniversityDao == null) {
//            mUniversityDao = getDao(University.class);
//        }
//
//        return mUniversityDao;
//    }

}
