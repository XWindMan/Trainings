package com.windman.cameraandvideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends Activity {

    private static final String TAG = "CameraActivity";

    private static final int REQUEST_CAMERA = 0x1;

    private ImageView imageView;

    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView = (ImageView) findViewById(R.id.image);
    }

    public void fromCamera(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            File file = createImageFile();
            if (file != null) {
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cameraIntent, REQUEST_CAMERA);
            }
        }
    }

    private File createImageFile() {
        String imageName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File fileDir = Environment.getExternalStorageDirectory();
        File file = null;
        try {
            file = File.createTempFile(imageName, ".jpg", fileDir);
            imagePath = "file:" + file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bundle b = data.getExtras();
            Bitmap bitmap = (Bitmap) b.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
