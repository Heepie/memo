package com.example.heepie.pic_mem_orm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.heepie.pic_mem_orm.util.PermissionUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    // 0. 권한 요청코드
//    private static final int REQ_CODE = 999;
//    // 1. 권한 정의
//    private String permissions[] = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
//    PermissionUtil pUtil;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        pUtil = new PermissionUtil(REQ_CODE, permissions);
//        if(pUtil.checkPermission(this)){
//            init();
//        }
//
//    }
//
//
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(pUtil.afterPermissionResult(requestCode, grantResults)){
//            init();
//        }else{
//            Toast.makeText(this, "승인 하셔야지만 앱을 실행할 수 있습니다.", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//    }
}
