package com.controls.e4a.e4acontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.controls.e4a.e4acontrols.controls.QQBottom;

public class QQBottomPage extends AppCompatActivity {

    private QQBottom qqBottom;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_bottom_page);
        qqBottom=new QQBottom(this);
        qqBottom.create();


    }
}
