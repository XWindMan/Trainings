package com.vtrump.fragmentnestdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MonthDataView extends View {

    private static final String TAG = "MonthDataView";

    private Paint mDataPaint;
    private Paint mTextPaint;

    private float interval = 50;
    private float lineHeight = 100;
    private float mPadding = 30;
    private int days = 30;

    private List<Float> data;

    public MonthDataView(Context context) {
        this(context, null);
    }

    public MonthDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        data = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) (interval * days + 2 * mPadding), 200);
    }

    private void initPaint() {
        mDataPaint = new Paint();
        mDataPaint.setAntiAlias(true);
        mDataPaint.setStrokeWidth(8);
        mDataPaint.setStrokeCap(Paint.Cap.ROUND);
        mDataPaint.setColor(Color.parseColor("#FF8C00"));

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(30);
        mTextPaint.setStrokeCap(Paint.Cap.ROUND);
        mTextPaint.setColor(Color.parseColor("#FF8C00"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0, getHeight() * 2 / 3);
        if (data.size() == 0) {
            return;
        }
        drawlines(canvas);
        drawTexts(canvas);
    }

    private void drawlines(Canvas canvas) {
        float startX = 0, startY = 0, endX, endY;
        for (int i = 0; i < data.size(); i++) {
            startX = mPadding + i * interval;
            endX = startX;
            startY = 0;
            endY = -data.get(i) * (getHeight() * 2 / 3 - mPadding);
            Log.d(TAG, "drawlines: endY=" + endY + ",height=" + getHeight() * 2 / 3);
            canvas.drawLine(startX, startY, endX, endY, mDataPaint);
        }
    }

    private void drawTexts(Canvas canvas) {
        float x = 0, y = 0;
        for (int i = 0; i < days; i++) {
            x = mPadding + i * interval;
            y = getHeight() / 6 + mPadding;
            float tw = mTextPaint.measureText(i + "");
            canvas.drawText(i + "", x - tw / 2, y, mTextPaint);
        }
    }

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }
}
