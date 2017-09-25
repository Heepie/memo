package com.example.heepie.pic_mem_orm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heepie on 2017. 9. 22..
 */

public class DrawView extends View{
    private final String className = getClass().getSimpleName();
    private Paint paint;
    private PathInfo pathInfo;
    private List<PathInfo> data;

    public DrawView(Context context) {
        super(context);
        data = new ArrayList<>();
    }

    public void setPaintInfo(int color, float r) {
        paint = new Paint();
        paint.setColor(color);
//        this.r = r;
        paint.setStrokeWidth(r);
// 선 두께 설정
        // 라인 설정을 위해
        paint.setStyle(Paint.Style.STROKE);
//        pathInfo = new PathInfo();
//        pathInfo.getPaint().setColor(color);
//        pathInfo.getPaint().setStrokeWidth(r);

        pathInfo = new PathInfo();
        pathInfo.setPaint(paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (PathInfo p : data) {
            canvas.drawPath(p, p.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            // View가 눌렸다면
            case MotionEvent.ACTION_DOWN:
                pathInfo.moveTo(event.getX(), event.getY());
                break;
            // View를 누르고 이동했다면
            case MotionEvent.ACTION_MOVE:
                pathInfo.lineTo(event.getX(), event.getY());
                break;
            // View에서 터치를 떼었다면
            case MotionEvent.ACTION_UP:

                break;
        }

        data.add(pathInfo);

        invalidate();

        return true;
    }

}

/**
 * Path마다 Paint 객체를 사용하기 위해 Path 클래스 상속
 */
class PathInfo extends Path {
    private final String className = getClass().getSimpleName();
    private Paint paint;

    PathInfo() {
        paint = new Paint();
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}