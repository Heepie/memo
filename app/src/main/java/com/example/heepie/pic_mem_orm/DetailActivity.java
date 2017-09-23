package com.example.heepie.pic_mem_orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        initVeiw();


    }

    private void initVeiw() {
        detailtextTitle = (TextView) findViewById(R.id.detailtextTitle);
        detailtextContent = (TextView) findViewById(R.id.detailtextContent);
        detailImage = (ImageView) findViewById(R.id.detailImage);
        detailtextDate = (TextView) findViewById(R.id.detailtextDate);
        detailBtnSave = (Button) findViewById(R.id.detailBtnSave);
    }

}