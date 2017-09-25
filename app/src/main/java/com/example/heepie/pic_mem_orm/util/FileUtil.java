package com.example.heepie.pic_mem_orm.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Heepie on 2017. 9. 20..
 */


public class FileUtil {
    private final String className = getClass().getSimpleName();

    public static Bitmap read(Context context, String filename) throws IOException {
        Bitmap bitmap = null;
        FileInputStream fis = null;
        try {
            // 디스크를 읽는다.
            fis = context.openFileInput(filename);

            // 스트림을 Bitmap으로 변환
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (IOException e) {
            throw e;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        return bitmap;
    }


    /**
     * 파일 쓰기 메소드
     * @param context
     * @param filename
     * @param bitmap
     * @throws IOException
     */
    public static void write (Context context, String filename, Bitmap bitmap) throws  IOException {
        // 내용을 파일에 쓴다.
        // 내부저장소 경로 : /data/data/패키지명
        // 내부저장소 일반적인 파일 경로 : /data/data/패키지명/files
        // 내부저장소 일반적인 데이타베이스 경로 : /data/data/패키지명/database

        FileOutputStream fos = null;
        try {

            // 내부저장소에 파일 스트림을 열어준다.
            fos = context.openFileOutput(filename, MODE_PRIVATE);

            // 2. 내용을 쓴다.
            fos.write(bitmapToByteArray(bitmap));

//            Log.d("WriteActivity", content);
        } catch (Exception e) {
            throw e;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // 비트맵을 압축한다. jpeg 파일로 압축율을 100으로
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}
