package com.pregnancy.utils;

/**
 * Created by Saad on 7/12/17.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.pregnency.R;


public class TextProgressBar44 extends ProgressBar {
    private String text;
    private Paint textPaint;

    public TextProgressBar44(Context context) {
        super(context);
        text = getResources().getString(R.string.Selectedweek);
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);


    }

    public TextProgressBar44(Context context, AttributeSet attrs) {
        super(context, attrs);
        text = getResources().getString(R.string.Selectedweek);
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
       /* int spSize = 17;
        float scaledSizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spSize, getResources().getDisplayMetrics());
        textPaint.setTextSize(scaledSizeInPixels);*/
    }

    public TextProgressBar44(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        text = getResources().getString(R.string.Selectedweek);
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int x = getWidth() / 2 - bounds.centerX();
        int y = getHeight() / 2 - bounds.centerY();
        canvas.drawText(text, x, y, textPaint);
    }

    public synchronized void setText(String text) {
        this.text = text;
        drawableStateChanged();
    }

    public void setTextColor(int color) {
        textPaint.setColor(color);
        drawableStateChanged();
    }
}