package com.windman.trainings.UI.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * fragment 控制器
 */
public class MyFragmentController {

    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;

    private static MyFragmentController controller;
    private static boolean isReload;

    public static MyFragmentController getInstance(FragmentActivity activity, int containerId, boolean isReload) {
        MyFragmentController.isReload = isReload;
        if (controller == null) {
            controller = new MyFragmentController(activity, containerId);
        }
        return controller;
    }

    public static void release() {
        controller = null;
    }

    private MyFragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    /**
     * 初始化四个fragment，并加入list
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        if (isReload) {
            fragments.add(new OneFragment());
            fragments.add(new TwoFragment());
            fragments.add(new ThreeFragment());

            FragmentTransaction ft = fm.beginTransaction();
            for (int i = 0; i < fragments.size(); i++) {
                ft.add(containerId, fragments.get(i), "" + i);
            }
            ft.commit();

        } else {
            for (int i = 0; i <= 4; i++) {
                fragments.add(fm.findFragmentByTag(i + ""));
            }
        }
    }

    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}