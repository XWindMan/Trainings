package com.vtrump.fragmentnestdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlueThreeFragment extends Fragment {

    private static final String TAG = "PlueThreeFragment";

    private RecyclerView mRecyclerView;


    public PlueThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plue_three, container, false);
        MonthDataView m = (MonthDataView) view.findViewById(R.id.monthDataView);
        m.setData(getData());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new MyAdapter());

        return view;
    }

    private List<Float> getData() {
        List<Float> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add((float) (Math.random()));
            Log.d(TAG, "getData: " + data.get(i));
        }
        return data;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        public MyAdapter() {
        }

        //创建新View，被LayoutManager所调用
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_month, viewGroup, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        //将数据与界面进行绑定的操作
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.mMonthDataView.setData(getData());
        }

        //获取数据的数量
        @Override
        public int getItemCount() {
            return 3;
        }

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        public class ViewHolder extends RecyclerView.ViewHolder {
            public MonthDataView mMonthDataView;

            public ViewHolder(View view) {
                super(view);
                mMonthDataView = (MonthDataView) view.findViewById(R.id.monthDataView);
            }
        }
    }

}
