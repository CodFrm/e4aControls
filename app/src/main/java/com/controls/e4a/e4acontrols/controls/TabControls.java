package com.controls.e4a.e4acontrols.controls;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.controls.e4a.e4acontrols.R;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class TabControls {

    private Context mContext;
    private View contView;
    private CommonTabLayout commonTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    public TabControls(Context context) {
        mContext = context;
    }

    public View create() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        contView = inflater.inflate(R.layout.tab_controls, null);
        LinearLayout.LayoutParams rllp = new LinearLayout.LayoutParams(-1, -1);
        rllp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rllp.height = 140;
        ((Activity) mContext).addContentView(contView, rllp);
        commonTabLayout = contView.findViewById(R.id.tab_controls);

        设置背景色("#ffffff");
        设置字体未选中颜色("#000000");
        设置字体选中颜色("#ff0000");
        设置下划线方向(false);
        设置下划线颜色("#b3daf3");
        return contView;
    }

    public void 监听事件(OnTabSelectListener event){
        commonTabLayout.setOnTabSelectListener(event);
    }

    public void 初始化() {
        commonTabLayout.setTabData(mTabEntities);
    }

    public void 设置字体选中颜色(String color) {
        commonTabLayout.setTextSelectColor(Color.parseColor(color));
    }

    public void 设置字体未选中颜色(String color) {
        commonTabLayout.setTextUnselectColor(Color.parseColor(color));
    }

    public void 设置图标高度(int h) {
        commonTabLayout.setIconHeight(h);
    }

    public void 设置分割线颜色(String color) {
        commonTabLayout.setDividerColor(Color.parseColor(color));
    }

    public void 设置分割线宽度(int w) {
        commonTabLayout.setDividerWidth(w);
    }

    public void 设置字体大小(float size) {
        commonTabLayout.setTextsize(size);
    }

    public void 设置下划线方向(Boolean top) {
        if (top) {
            commonTabLayout.setUnderlineGravity(Gravity.TOP);
        } else {
            commonTabLayout.setUnderlineGravity(Gravity.BOTTOM);
        }

    }

    public void 设置项目背景颜色(String color) {
        commonTabLayout.setIndicatorColor(Color.parseColor(color));
    }

    public void 设置下划线样式(int style) {
        commonTabLayout.setIndicatorStyle(style);
    }

    public void 设置下划线弧度(float h) {
        commonTabLayout.setIndicatorCornerRadius(h);
    }

    public void 设置下划线背景颜色(String color) {
        commonTabLayout.setUnderlineColor(Color.parseColor(color));
    }

    public void 设置下划线颜色(String color) {
        commonTabLayout.setIndicatorColor(Color.parseColor(color));
    }

    public void 设置下划线外边距(float l, float t, float r, float b) {
        commonTabLayout.setIndicatorMargin(l, t, r, b);
    }

    public void 设置项目消息(int index, int num) {
        commonTabLayout.showMsg(index, num);
    }

    public void 设置消息间隔(int index, int l, int r) {
        commonTabLayout.setMsgMargin(index, l, r);
    }

    public void 小红点(int index) {
        commonTabLayout.showDot(index);
    }

    public void 设置下划线高度(float h) {
        commonTabLayout.setUnderlineHeight(h);
        commonTabLayout.setIndicatorHeight(h);
    }

    public void 设置下划线宽度(float w) {
        commonTabLayout.setIndicatorWidth(w);
    }

    public void 加粗(int b) {
        commonTabLayout.setTextBold(b);
    }

    public void 图标可见(boolean show) {
        commonTabLayout.setIconVisible(show);
    }

    public void 设置背景色(String color) {
        commonTabLayout.setBackgroundColor(Color.parseColor(color));
    }

    public void 添加一项(String 标题, int 选中图片, int 未选中图片) {
        mTabEntities.add(new TabEntity(标题, 选中图片, 未选中图片));
    }

    public void 添加一项2(String[] 标题s) {
        for (int i = 0; i < 标题s.length; i++) {
            mTabEntities.add(new TabEntity(标题s[i], 0, 0));
        }
    }


}

class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}

