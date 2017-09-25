package com.example.heepie.pic_mem_orm;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.heepie.pic_mem_orm.DAO.PicNoteDAO;
import com.example.heepie.pic_mem_orm.model.PicNote;
import com.example.heepie.pic_mem_orm.util.PermissionUtil;

import java.util.List;

/**
 *
 */
public class ListActivity extends AppCompatActivity {
    private final String className = getClass().getSimpleName() + " ";
    private static final int DRAWACTIVITY = 60;

    private Button btnPost;
    private RecyclerView recycleView;
    private PicNoteDAO dao;
    private CustomAdapter adapter;


    // 0. 권한 요청코드
    private static final int REQ_CODE = 999;
    // 1. 권한 정의
    private String permissions[] = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    PermissionUtil pUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        pUtil = new PermissionUtil(REQ_CODE, permissions);
        if(pUtil.checkPermission(this)){
            initView();
            initListener();
            initAdapter();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(pUtil.afterPermissionResult(requestCode, grantResults)){
            initView();
            initListener();
            initAdapter();
        }else{
            Toast.makeText(this, "승인 하셔야지만 앱을 실행할 수 있습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void initAdapter() {
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
                Log.i("heepie", className + "ResultCode: " + resultCode);
                if (resultCode == RESULT_OK) {

                    refresh();
                }
                break;
        }
    }

    private void refresh() {
        List<PicNote> data = dao.readAll();

        for (PicNote item: data) {
            Log.i("heepie", className + item.getTitle());
        }
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
