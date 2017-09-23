package com.example.heepie.pic_mem_orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.heepie.pic_mem_orm.model.PicNote;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Heepie on 2017. 9. 22..
 */

public class DBHelper extends OrmLiteSqliteOpenHelper{
    private static final String DB_NAME = "ormlite.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null ,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        int i;
        try {
            i = TableUtils.createTable(connectionSource, PicNote.class);
            Log.i("heepie", i+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
