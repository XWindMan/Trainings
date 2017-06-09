package com.windman.trainings.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.windman.cameraandvideo.CameraActivity;
import com.windman.scrollerdemo.ScrollerActivity;
import com.windman.trainings.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTo(View view) {
        startActivity(new Intent(this, ActionbarActivity.class));
    }

    public void startToCamera(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    public void startToScroll(View view) {
        startActivity(new Intent(this, ScrollerActivity.class));
    }
}
