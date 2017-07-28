package com.vtrump.skindemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import skin.support.app.SkinLayoutInflater;

public class MySkinViewInflater implements SkinLayoutInflater {
    @Override
    public View createView(@NonNull Context context, String name, @NonNull AttributeSet attrs) {
        View view = null;
        switch (name) {
            case "android.support.v4.widget.SwipeRefreshLayout":
                break;
        }
        return view;
    }
}