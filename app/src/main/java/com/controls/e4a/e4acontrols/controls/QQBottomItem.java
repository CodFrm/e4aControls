package com.controls.e4a.e4acontrols.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.controls.e4a.e4acontrols.R;

public class QQBottomItem extends RelativeLayout {

    private ImageView imgCtrl;
    private TextView textCtrl;
    private String showText;

    private Bitmap bitmap;
    private Bitmap activeImg;

    private int color;
    private int activeColor;

    public QQBottomItem(Context context, String text, int color, int activeColor, Bitmap bitmap, Bitmap activeImg) {
        super(context);
        this.bitmap = bitmap;
        this.activeImg = activeImg;
        this.color = color;
        this.activeColor = activeColor;
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.qq_bottom_item, this);
        showText = text;
        textCtrl = (TextView) findViewById(R.id.text);
        imgCtrl = (ImageView) findViewById(R.id.img);

        textCtrl.setText(text);
        textCtrl.setTextColor(color);
        imgCtrl.setImageBitmap(bitmap);

    }

    public void setActive(boolean active) {
        if (active) {
            textCtrl.setTextColor(activeColor);
            imgCtrl.setImageBitmap(activeImg);
        } else {
            textCtrl.setTextColor(color);
            imgCtrl.setImageBitmap(bitmap);
        }
    }

    public String getText() {
        return showText;
    }
}
