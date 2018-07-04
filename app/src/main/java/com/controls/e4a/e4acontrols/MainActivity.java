package com.controls.e4a.e4acontrols;

import android.content.Intent;
import android.os.Build;
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                }
                break;
            case R.id.tabLayout:
                Intent intent = new Intent(this, TabLayoutPage.class);
                startActivity(intent);
                break;
        }
    }

}
