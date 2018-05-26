package com.controls.e4a.e4acontrols.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.controls.e4a.e4acontrols.R;

public class QQBottomItem extends LinearLayout {

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

    public void setFontSize(int size) {
        textCtrl.setTextSize(size);
    }

    public void setHeight(int a) {
        LinearLayout.LayoutParams l = (LinearLayout.LayoutParams) textCtrl.getLayoutParams();
        l.height = a;
        textCtrl.setLayoutParams(l);
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
