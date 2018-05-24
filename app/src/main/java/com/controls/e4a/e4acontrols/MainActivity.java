package com.controls.e4a.e4acontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkVideoSourcePage(View view) {
        Intent intent = new Intent(this, VideoSourcePage.class);
        startActivity(intent);
    }

    public void btnOnClick(View view) {
        switch (view.getId()) {
            case R.id.qq_bottom:
                Intent intent = new Intent(this, QQBottomPage.class);
                startActivity(intent);
        }
    }
}
