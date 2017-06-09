package com.windman.trainings.UI.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.windman.trainings.R;

/**
 * Created by Vtrump on 2016/9/4.
 */
public class ActionbarActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.actionbar_a);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
