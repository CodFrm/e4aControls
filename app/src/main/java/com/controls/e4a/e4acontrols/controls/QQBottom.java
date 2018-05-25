package com.controls.e4a.e4acontrols.controls;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.controls.e4a.e4acontrols.R;

public class QQBottom {

    private Context mContext;
    private View contView;

    public QQBottom(Context context) {
        mContext = context;
    }

    public View create() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        contView = inflater.inflate(R.layout.qq_bottom_controls, null);

        LinearLayout.LayoutParams rllp = new LinearLayout.LayoutParams(-1, -1);
        rllp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rllp.height = 160;
        ((Activity) mContext).addContentView(contView, rllp);

        return contView;
    }

    public void setColor() {

    }

    public void setActiveColor() {

    }

    public void addItem() {

    }

}
