package com.vtrump.fragmentnestdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Fragment mHomeFramgment;
    private Fragment mDashBoardFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(mHomeFramgment);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(mDashBoardFragment);
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomeFramgment = new HomeFragment();
        mDashBoardFragment = new DashBoardFragment();
        switchFragment(mHomeFramgment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commitAllowingStateLoss();
    }
}
