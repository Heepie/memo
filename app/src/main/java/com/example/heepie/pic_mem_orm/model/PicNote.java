package com.example.heepie.pic_mem_orm.model;

import android.graphics.Bitmap;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Heepie on 2017. 9. 22..
 */

@DatabaseTable(tableName = "picnote")
public class PicNote implements Serializable{
    private final String className = getClass().getSimpleName();

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String title;

    @DatabaseField
    private long n_date;

    @DatabaseField
    private String bitmap_path;

    @DatabaseField
    private String content;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getN_date() {
        return n_date;
    }

    public void setN_date(long n_date) {
        this.n_date = n_date;
    }

    public String getBitmap_path() {
        return bitmap_path;
    }

    public void setBitmap_path(String bitmap_path) {
        this.bitmap_path = bitmap_path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
