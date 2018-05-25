package com.controls.e4a.e4acontrols;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.controls.e4a.e4acontrols.controls.QQBottom;

public class QQBottomPage extends AppCompatActivity {

    private QQBottom qqBottom;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_bottom_page);
        qqBottom = new QQBottom(this);
        qqBottom.create();
        qqBottom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        qqBottom.addItem("rrr",
                BitmapFactory.decodeResource(getResources(), R.drawable.share),
                BitmapFactory.decodeResource(getResources(), R.drawable.download)
        );

        qqBottom.addItem("haas",
                BitmapFactory.decodeResource(getResources(), R.drawable.down),
                BitmapFactory.decodeResource(getResources(), R.drawable.download)
        );


        qqBottom.addItem("haha",
                BitmapFactory.decodeResource(getResources(), R.drawable.txsp),
                BitmapFactory.decodeResource(getResources(), R.drawable.download)
        );


    }
}
