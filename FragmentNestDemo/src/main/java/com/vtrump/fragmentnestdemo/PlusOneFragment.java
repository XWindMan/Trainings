package com.vtrump.fragmentnestdemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlusOneFragment extends Fragment {

    private int mBorderColor = Color.parseColor("#44FFFFFF");
    private int mBorderWidth = 10;
    private WaveHelper mWaveHelper;

    public PlusOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        WaveView waveView = (WaveView) view.findViewById(R.id.wave);
        waveView.setShapeType(WaveView.ShapeType.CIRCLE);
        mWaveHelper = new WaveHelper(waveView);
        waveView.setWaveColor(
                Color.parseColor("#40b7d28d"),
                Color.parseColor("#80b7d28d"));
        mBorderColor = Color.parseColor("#B0b7d28d");
        waveView.setBorder(mBorderWidth, mBorderColor);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mWaveHelper.cancel();
    }
}
