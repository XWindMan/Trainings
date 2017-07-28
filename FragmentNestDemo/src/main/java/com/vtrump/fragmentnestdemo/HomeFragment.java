package com.vtrump.fragmentnestdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Fragment mPlusOneFragment;
    private Fragment mPlueTwoFragment;
    private Fragment mPlusThreeFragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mPlusOneFragment = new PlusOneFragment();
        mPlueTwoFragment = new PlusTwoFragment();
        mPlusThreeFragment = new PlueThreeFragment();
        replace(mPlusOneFragment);

        view.findViewById(R.id.plus_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(mPlusOneFragment);
            }
        });
        view.findViewById(R.id.plus_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(mPlueTwoFragment);
            }
        });
        view.findViewById(R.id.plus_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(mPlusThreeFragment);
            }
        });


        return view;

    }

    private void replace(Fragment fragment) {
        final FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_content, fragment);
        transaction.commitAllowingStateLoss();
    }
}
