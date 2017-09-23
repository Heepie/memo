package com.example.heepie.pic_mem_orm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Heepie on 2017. 9. 22..
 */

public class DrawView extends View{
    private Paint paint;
    private Path currentPath;
    private PathTool pathTool;
    private ArrayList<Path> paths;

    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        currentPath = new Path();

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);

        paths = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(currentPath, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();

        return true;
    }

    public void makeTool() {
        pathTool = new PathTool();
    }
    public void addTool() {
        paths.add(pathTool);
    }
    public void setWidth(int progress) {
        float width = (float)progress/10;
        pathTool.setStrokeWidth(width);
    }
    public void setColor(int color) {
        pathTool.setColor(color);
    }
    public void sendToolToCP() {
        currentPath = pathTool;
    }

    public PathTool getPathTool() {
        return pathTool;
    }
}

class PathTool extends Path {
    int color;
    float width;

    public void setColor(int color) {
        this.color = color;
    }

    public void setStrokeWidth(float width) {
        this.width = width;
    }

    public int getColor() {
        return color;
    }
}
