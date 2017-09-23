 package com.example.heepie.pic_mem_orm;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heepie.pic_mem_orm.DAO.PicNoteDAO;
import com.example.heepie.pic_mem_orm.model.PicNote;
import com.example.heepie.pic_mem_orm.util.FileUtil;

import java.io.IOException;

 public class DrawActivity extends AppCompatActivity {
     private static final String DELIMITER = ":::";
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private RadioButton radioCyan;
    private RadioButton radioMegenta;
    private RadioButton radioBlack;
    private RadioButton radioYellow;
    private Button btnPost;
    private TextView textSeekResult;
    private FrameLayout stage;
    private DrawView drawView;
     private EditText editTitle;
     private EditText editContent;

     private int progress;
     private PicNoteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        initView();
        initListener();
    }

    private void initView() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioCyan = (RadioButton) findViewById(R.id.radioCyan);
        radioMegenta = (RadioButton) findViewById(R.id.radioMegenta);
        radioBlack = (RadioButton) findViewById(R.id.radioBlack);
        radioYellow = (RadioButton) findViewById(R.id.radioYellow);
        btnPost = (Button) findViewById(R.id.btnPost);
        textSeekResult = (TextView) findViewById(R.id.textSeekResult);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editContent = (EditText) findViewById(R.id.editContent);
        stage = (FrameLayout)findViewById(R.id.stage);

        drawView = new DrawView(this);
        stage.addView(drawView);

        dao = new PicNoteDAO(this);
    }

    private PicNote getPicNoteFromScreen() {
        long time = System.currentTimeMillis();
        String fileName = editTitle.getText().toString() + DELIMITER + time;
        PicNote picNote = new PicNote();
        picNote.setTitle(editTitle.getText().toString());
        Log.i("heepie", "Draw " + editTitle.getText().toString());

        picNote.setN_date(time);

        picNote.setBitmap_path(fileName + ".jpg");
        Log.i("heepie", "Draw " + editTitle.getText().toString() + DELIMITER + time);

        picNote.setContent(editContent.getText().toString());
        Log.i("heepie", "Draw " + editContent.getText().toString());
        return picNote;
    }

    private void initListener() {
        // Post Button 리스너
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked Post", Toast.LENGTH_SHORT).show();
                PicNote picNote = getPicNoteFromScreen();

                // 그림 File로 저장
                captrueCanvas(picNote.getBitmap_path());
                // DB에 저장
                dao.create(picNote);
                setResult(RESULT_OK);

                finish();
            }
        });

        // RadioGroup 리스너
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                switch (id) {
                    case R.id.radioCyan:
//                        drawView.makeTool();
//                        drawView.setWidth(progress);
//                        drawView.setColor(Color.CYAN);
//                        drawView.sendToolToCP();
//                        drawView.addTool();
                        break;

                    case R.id.radioBlack:
//                        drawView.makeTool();
//                        drawView.setWidth(progress);
//                        drawView.setColor(Color.BLACK);
//                        drawView.sendToolToCP();
//                        drawView.addTool();
                        break;

                    case R.id.radioMegenta:
//                        drawView.makeTool();
//                        drawView.setWidth(progress);
//                        drawView.setColor(Color.MAGENTA);
//                        drawView.sendToolToCP();
//                        drawView.addTool();
                        break;

                    case R.id.radioYellow:
//                        drawView.makeTool();
//                        drawView.setWidth(progress);
//                        drawView.setColor(Color.YELLOW);
//                        drawView.sendToolToCP();
//                        drawView.addTool();
                        break;
                }

            }
        });

        // SeekBar 리스너
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textSeekResult.setText(i+"");
//                progress = i;
//                int color = drawView.getPathTool().getColor();
//                drawView.makeTool();
//                drawView.setWidth(progress);
//                drawView.setColor(color);
//                drawView.sendToolToCP();
//                drawView.addTool();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

     /**
      * 그림을 그린 stage를 캡쳐
      */
     public void captrueCanvas(String fileName) {
         // 0. 드로잉 캐쉬를 먼저 초기화
         stage.destroyDrawingCache();

         // 1. 다시 캐쉬 생성
         stage.buildDrawingCache();

         // 2. 레이아웃에서 그려진 내용을 bitmap 형태로 가져온다.
         Bitmap bitmap = stage.getDrawingCache();

         // 이미지 파일 저장
         try {
             FileUtil.write(this, fileName, bitmap);
         } catch (IOException e) {
             e.printStackTrace();
         }

         // 중요한 것
         bitmap.recycle();

         finish();
     }
}
