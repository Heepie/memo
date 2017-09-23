package com.example.heepie.pic_mem_orm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.heepie.pic_mem_orm.DAO.PicNoteDAO;
import com.example.heepie.pic_mem_orm.model.PicNote;

import java.util.List;

/**
 *
 */
public class ListActivity extends AppCompatActivity {
    private static final int DRAWACTIVITY = 60;

    private Button btnPost;
    private RecyclerView recycleView;
    private PicNoteDAO dao;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        initListener();

        adapter = new CustomAdapter();

        refresh();

        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initView() {
        btnPost = (Button) findViewById(R.id.btnPost);
        recycleView = (RecyclerView) findViewById(R.id.RecycleView);

        dao = new PicNoteDAO(this);
    }

    private void initListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DrawActivity.class);
                startActivityForResult(intent, DRAWACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {

            case DRAWACTIVITY:
//                Log.i("heepie", ""+resultCode);
//                if (resultCode == RESULT_OK) {

                    refresh();
//                }
                break;
        }
    }

    private void refresh() {
        List<PicNote> data = dao.readAll();

        for (PicNote item: data) {
            Log.i("heepie", "ListActivity " + item.getTitle());
        }
        adapter.setData(data);
    }
}
