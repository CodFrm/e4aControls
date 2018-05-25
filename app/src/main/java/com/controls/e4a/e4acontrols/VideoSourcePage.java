package com.controls.e4a.e4acontrols;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.controls.e4a.e4acontrols.controls.VideoSource;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VideoSourcePage extends AppCompatActivity {

    private VideoSource videoSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_source_page);
        videoSource = new VideoSource(this);
        videoSource.create();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.collection);
        videoSource.addItem("ceshi", "12", bitmap);
        videoSource.addItem("down", "12415", BitmapFactory.decodeResource(getResources(), R.drawable.download));
        videoSource.addItem("测试", "412", BitmapFactory.decodeResource(getResources(), R.drawable.share));
        videoSource.addItem("测试", "12323", BitmapFactory.decodeResource(getResources(), R.drawable.share));
        videoSource.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        videoSource.setOnActionListener(new VideoSource.OnActionListener() {
            @Override
            public void onAction(int var1) {
//                Log.e("VideoSourcePage", videoSource.getUrl(var1));
            }
        });
        videoSource.setSelection(2);
    }

    public void btnOnClick(View view) {
        switch (view.getId()) {
            case R.id.removeall:
                videoSource.removeAll();
                break;
            case R.id.add:
                Random random=new Random();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.collection);
                String t=Integer.toString(random.nextInt());
                videoSource.addItem(t, t, bitmap);

        }
    }

}
