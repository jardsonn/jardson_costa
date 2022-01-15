package com.jcsapps.jardson_costa.ui.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import com.jcsapps.jardson_costa.R;

public class ViewCanvas extends View {

    public ViewCanvas(Context context) {
        super(context);
    }

    public ViewCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Bitmap drawTextInCircle(String textToDraw) {
        Bitmap bitmap = Bitmap.createBitmap(1700, 3250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(400f);
        textPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.philosopher_bold));

        final float radius = 350f;
        float textHeight = textPaint.descent() - textPaint.ascent();
        float textOffset = (textHeight / 2) - textPaint.descent();

        float cx = canvas.getWidth() / 2f;
        float cy = canvas.getHeight() / 2f;

        canvas.drawCircle(cx, cy, radius, paint);

        float margin = 100f;

        String text = textToDraw;
        int numOfChars = textPaint.breakText(text, true, radius * 2 - margin, null);

        if (text.length() > numOfChars) {
            text = text.substring(0, numOfChars);
        }

        canvas.drawText(text, cx, cy + textOffset, textPaint);
        return bitmap;
    }

    public void setTextResult(String textResult) {
        Bitmap bitmap = drawTextInCircle(textResult);
        setBackground(new BitmapDrawable(getContext().getResources(), bitmap));
    }
}
