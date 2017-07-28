package com.vtrump.fragmentnestdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A fragment with a Google +1 button.
 */
public class PlusTwoFragment extends Fragment {
    private static final String TAG = "PlusTwoFragment";

    public PlusTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_two, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getGender(Gender.FEMALE);
    }

    private void getGender(Gender gender) {
        Log.d(TAG, "onCreateView: " + gender.nativeStr);
    }
}
