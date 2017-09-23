package com.example.heepie.pic_mem_orm.DAO;

import android.content.Context;
import android.util.Log;

import com.example.heepie.pic_mem_orm.DBHelper;
import com.example.heepie.pic_mem_orm.model.PicNote;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Heepie on 2017. 9. 22..
 * c, r, u, d
 */

public class PicNoteDAO {
    private DBHelper dbHelper;
    Dao<PicNote, Long> ormDao;

    public PicNoteDAO(Context context) {
        dbHelper = new DBHelper(context);
        try {
            ormDao = dbHelper.getDao(PicNote.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(PicNote picNote) {
        Log.i("heepie", "dao create " + picNote.getTitle());
        Log.i("heepie", "dao create " + picNote.getContent());
        Log.i("heepie", "dao create " + picNote.getN_date());
        Log.i("heepie", "dao create " + picNote.getBitmap_path());
        try {
            ormDao.create(picNote);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }

    public List<PicNote> readAll() {
        List<PicNote> data=null;

        try {
            data = ormDao.queryForAll();
            for (PicNote picNote : data) {
                Log.i("heepie", "dao readAll " + picNote.getTitle());
                Log.i("heepie", "dao readAll " + picNote.getContent());
                Log.i("heepie", "dao readAll " + picNote.getN_date());
                Log.i("heepie", "dao readAll " + picNote.getBitmap_path());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

}
