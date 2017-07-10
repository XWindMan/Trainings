package com.vtrump.fragmentnestdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MonthDataView extends View {

    private static final String TAG = "MonthDataView";

    private Paint mDataPaint;
    private Paint mTextPaint;

    private float interval = 50;
    private float mPadding = 30;

    private String startColor = "#ffffff";
    private String endColor = "#FF8C00";
    private List<Float> data;
    private List<String> textList;

    public MonthDataView(Context context) {
        this(context, null);
    }

    public MonthDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        data = new ArrayList<>();
        textList = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) (interval * data.size() + 2 * mPadding), 200);
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
        if (data.size() == 0 || textList.size() == 0) {
            return;
        }
        drawlines(canvas);
        drawTexts(canvas);
    }

    private void drawlines(Canvas canvas) {
        float startX = 0, startY = 0, endX, endY = 0;
        for (int i = 0; i < data.size(); i++) {
            startX = mPadding + i * interval;
            endX = startX;
            startY = 0;
            endY = -data.get(i) * (getHeight() * 2 / 3 - mPadding);
            LinearGradient gradient = new LinearGradient(startX, startY, endX, endY,
                    Color.parseColor(startColor), Color.parseColor(endColor), Shader.TileMode.CLAMP);
            mDataPaint.setShader(gradient);
            canvas.drawLine(startX, startY, endX, endY, mDataPaint);
        }
    }

    private void drawTexts(Canvas canvas) {
        float x = 0, y = 0;
        for (int i = 0; i < textList.size(); i++) {
            x = mPadding + i * interval;
            y = getHeight() / 6 + mPadding;
            float tw = mTextPaint.measureText(textList.get(i));
            canvas.drawText(textList.get(i), x - tw / 2, y, mTextPaint);
        }
    }

    public List<Float> getData() {
        return data;
    }

    public MonthDataView setData(List<Float> data) {
        this.data = data;
        return this;
    }

    public List<String> getTextList() {
        return textList;
    }

    public MonthDataView setTextList(List<String> textList) {
        this.textList = textList;
        return this;
    }

    public MonthDataView setStartColor(String startColor) {
        this.startColor = startColor;
        return this;
    }


    public MonthDataView setEndColor(String endColor) {
        this.endColor = endColor;
        return this;
    }

}
