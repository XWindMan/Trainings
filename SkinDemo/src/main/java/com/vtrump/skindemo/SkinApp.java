package com.vtrump.skindemo;

import android.app.Application;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * 2017/7/14.
 */

public class SkinApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSkinLoader();
    }

    private void initSkinLoader() {
        SkinCompatManager.init(this)
                .addInflater(new SkinMaterialViewInflater())    // material design
                .addInflater(new SkinConstraintViewInflater())  // ConstraintLayout
                .addInflater(new SkinCardViewInflater())        // CardView v7
                .addInflater(new MySkinViewInflater())
                .loadSkin();
    }
}
