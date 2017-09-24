package com.example.heepie.pic_mem_orm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heepie.pic_mem_orm.model.PicNote;
import com.example.heepie.pic_mem_orm.util.FileUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 상세 페이지
 */
public class DetailActivity extends AppCompatActivity {

    private TextView detailtextTitle;
    private TextView detailtextContent;
    private ImageView detailImage;
    private TextView detailtextDate;
    private Button detailBtnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bitmap bitmap=null;

        initVeiw();

        PicNote picNote = (PicNote) getIntent().getSerializableExtra("picNote");
        try {
            bitmap = FileUtil.read(this, picNote.getBitmap_path());
        } catch (IOException e) {
            e.printStackTrace();
        }


        detailtextTitle.setText(picNote.getTitle());
        detailtextContent.setText(picNote.getContent());

        // 시간 가공
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date = df.format(picNote.getN_date());
        detailtextDate.setText(date);
        detailImage.setImageBitmap(bitmap);


    }

    private void initVeiw() {
        detailtextTitle = (TextView) findViewById(R.id.detailtextTitle);
        detailtextContent = (TextView) findViewById(R.id.detailtextContent);
        detailImage = (ImageView) findViewById(R.id.detailImage);
        detailtextDate = (TextView) findViewById(R.id.detailtextDate);
        detailBtnSave = (Button) findViewById(R.id.detailBtnSave);
    }

}
