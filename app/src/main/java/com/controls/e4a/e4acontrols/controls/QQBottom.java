package com.controls.e4a.e4acontrols.controls;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.controls.e4a.e4acontrols.R;

import java.util.ArrayList;

public class QQBottom {

    private int color = Color.parseColor("#cccccc");

    private int activeColor = Color.parseColor("#000000");

    private Context mContext;
    private View contView;

    private ArrayList<QQBottomItem> items = new ArrayList<>();

    private QQBottomItem activeQQBottomItem = null;
    private AdapterView.OnItemClickListener itemClickListener;


    public QQBottom(Context context) {
        mContext = context;
    }

    public View create() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        contView = inflater.inflate(R.layout.qq_bottom_controls, null);
        LinearLayout.LayoutParams rllp = new LinearLayout.LayoutParams(-1, -1);
        rllp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rllp.height = 140;
        ((Activity) mContext).addContentView(contView, rllp);
        return contView;
    }

    public void setColor(String color) {
        this.color = Color.parseColor(color);
    }

    public void setActiveColor(String color) {
        this.activeColor = Color.parseColor(color);
    }

    public int addItem(String text, Bitmap bitmap, Bitmap active) {
        final QQBottomItem qqBottomItem = new QQBottomItem(contView.getContext(), text, (color),
                (activeColor), bitmap, active);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 10;
        qqBottomItem.setLayoutParams(layoutParams);
        ((LinearLayout) contView).addView(qqBottomItem, layoutParams);
        items.add(qqBottomItem);
        qqBottomItem.setId(items.size() - 1);
        qqBottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    activeQQBottomItem.setActive(false);
                } catch (Exception e) {

                }
                qqBottomItem.setActive(true);
                activeQQBottomItem = qqBottomItem;
                itemClickListener.onItemClick(null, view, qqBottomItem.getId(), 0);
            }
        });
        contView.requestLayout();
        return items.size() - 1;
    }


    public void remove(int index) {
        try {
            QQBottomItem v = (QQBottomItem) contView.findViewById(index);
            ViewGroup p = (ViewGroup) v.getParent();
            p.removeView(v);
            for (int i = index + 1; i < items.size(); i++) {
                v = items.get(i);
                v.setId(i - 1);
            }
        } catch (Exception e) {

        }
        contView.requestLayout();
    }

    public void removeAll() {
        for (int i = 0; i < items.size(); i++) {
            try {
                QQBottomItem v = (QQBottomItem) contView.findViewById(i);
                if (v == null) {
                    continue;
                }
                ViewGroup p = (ViewGroup) v.getParent();
                p.removeView(v);
            } catch (Exception e) {

            }
        }
        items.clear();
        contView.requestLayout();
    }

    public void selectItem(int id) {
        try {
            activeQQBottomItem.setActive(false);
        } catch (Exception e) {

        }

        try {
            QQBottomItem qqBottomItem = (QQBottomItem) contView.findViewById(id);
            qqBottomItem.setActive(true);
            activeQQBottomItem = qqBottomItem;
        } catch (Exception e) {

        }
        contView.requestLayout();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        itemClickListener = listener;
    }
}
