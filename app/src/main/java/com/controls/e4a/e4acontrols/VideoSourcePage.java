package com.controls.e4a.e4acontrols;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.controls.e4a.e4acontrols.controls.VideoSource;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoSourcePage extends AppCompatActivity {

    private VideoSource videoSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_source_page);
        videoSource = new VideoSource(this);
        videoSource.create();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.collection);
        videoSource.addItem("ceshi", bitmap);
        videoSource.addItem("down", BitmapFactory.decodeResource(getResources(), R.drawable.download));
        videoSource.addItem("测试", BitmapFactory.decodeResource(getResources(), R.drawable.share));
        videoSource.addItem("tx", BitmapFactory.decodeResource(getResources(), R.drawable.txsp));
        videoSource.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        videoSource.setOnActionListener(new VideoSource.OnActionListener() {
            @Override
            public void onAction(int var1) {

            }
        });
        videoSource.setSelection(2);
    }

}
