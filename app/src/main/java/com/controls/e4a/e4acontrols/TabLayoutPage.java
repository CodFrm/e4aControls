package com.controls.e4a.e4acontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.controls.e4a.e4acontrols.controls.TabControls;
import com.flyco.tablayout.listener.OnTabSelectListener;

public class TabLayoutPage extends AppCompatActivity {

    private TabControls tabControls;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        tabControls = new TabControls(this);
        tabControls.监听事件(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        tabControls.create();
//        tabControls.添加一项("测试", R.drawable.collection, R.drawable.collection_y);
//        tabControls.添加一项("测试1", R.drawable.down, R.drawable.download);
        tabControls.添加一项2(new String[]{"我","爱","你"});
//        tabControls.设置背景色("#ffffff");
//        tabControls.设置字体未选中颜色("#000000");
////        tabControls.设置分割线颜色("#ffee00");
////        tabControls.设置分割线宽度(1);
//        tabControls.设置字体选中颜色("#ff0000");
//        tabControls.设置下划线方向(false);
////        tabControls.设置下划线弧度(30);
////        tabControls.设置下划线高度(4);
//        tabControls.图标可见(false);
////        tabControls.设置项目背景颜色("#7861f2");
////        tabControls.设置项目消息(3,3);
////        tabControls.设置下划线背景颜色("#55ee88");
////        tabControls.设置下划线颜色("#665181");
////        tabControls.设置下划线宽度(50);
//        tabControls.设置下划线弧度(20);
//        tabControls.设置下划线高度(40);
//        tabControls.设置下划线样式(2);
//        tabControls.设置下划线外边距(5,5,0,0);
        tabControls.初始化();
//        tabControls.设置项目消息(1,23);
//        tabControls.设置消息间隔(1,-5,5);
//        tabControls.小红点(0);
//        tabControls.设置消息间隔(0,-5,5);
//        tabControls.加粗(1);
    }
}
