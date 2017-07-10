package com.windman.trainings.UI.Activity;

import android.util.Log;

/**
 * 2017/7/7.
 */

public class Child extends Parent {
    private static final String TAG = "Child";
    public void setL(OnAbcChanged l) {
        this.l = l;
    }

    private OnAbcChanged l;

    interface OnAbcChanged {
        void abcChangd(String abc);
    }

    @Override
    public void abc(String abc) {
        super.abc(abc);
        Log.d(TAG, "abc: "+abc);
        l.abcChangd(abc);
    }
}
