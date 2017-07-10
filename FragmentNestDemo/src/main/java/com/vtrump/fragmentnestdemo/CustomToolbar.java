package com.vtrump.fragmentnestdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 2017/7/4.
 */

public class CustomToolbar extends LinearLayout {

    private TextView title;

    public CustomToolbar(Context context) {
        this(context, null);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view= LayoutInflater.from(context).inflate(R.layout.custom_toolbar,null,false);

        initView(view);
    }

    private void initView(View view) {
        title= (TextView) view.findViewById(R.id.toolbar_title);

    }

    public void setTitle(String t) {
        /*if (title == null) {
            title = (TextView) findViewById(R.id.toolbar_title);
        }*/
        title.setText(t);
    }
}
