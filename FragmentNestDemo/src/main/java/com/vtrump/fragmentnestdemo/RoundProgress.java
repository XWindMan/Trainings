package com.vtrump.fragmentnestdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 2017/7/10.
 */

public class RoundProgress extends View {

    private Paint mProgressPaint;
    private Paint mTextPaint;
    private float mPaddind = 20;

    public RoundProgress(Context context) {
        this(context, null);
    }

    public RoundProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStrokeWidth(10);
        mProgressPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(135);
        RectF rectF = new RectF(-getWidth() / 2 + mPaddind, -getHeight() / 2 + mPaddind,
                getWidth() / 2 - mPaddind, getHeight() / 2 - mPaddind);
        SweepGradient gradient = new SweepGradient(getWidth() / 2, getHeight() / 2,
                Color.parseColor("#9370DB"), Color.parseColor("#0000FF"));
        mProgressPaint.setShader(gradient);
        canvas.drawArc(rectF, 0, 270, false, mProgressPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
