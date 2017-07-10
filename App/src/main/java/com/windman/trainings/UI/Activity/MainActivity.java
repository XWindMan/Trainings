package com.windman.trainings.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.windman.cameraandvideo.CameraActivity;
import com.windman.scrollerdemo.ScrollerActivity;
import com.windman.trainings.R;

public class MainActivity extends Activity implements Child.OnAbcChanged {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parent p=new Parent();
        p.abc("abc");
        Child child = new Child();
        child.setL(this);
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

    @Override
    public void abcChangd(String abc) {
        Toast.makeText(MainActivity.this, abc, Toast.LENGTH_SHORT).show();
    }
}
