package com.vtrump.fragmentnestdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new MyAdapter());

        return view;
    }

    private List<List<Float>> getData() {
        List<List<Float>> list = new ArrayList<>();
        List<Float> data1 = new ArrayList<>();
        for (int i = 0; i < 30; i += 2) {
            data1.add((float) (Math.random()));
        }
        List<Float> data2 = new ArrayList<>();
        for (int i = 0; i < 14; i += 2) {
            data2.add((float) (Math.random()));
        }
        List<Float> data3 = new ArrayList<>();
        for (int i = 0; i < 24; i += 2) {
            data3.add((float) (Math.random()));
        }
        list.add(data1);
        list.add(data2);
        list.add(data3);
        return list;
    }

    private List<List<String>> getTextData() {
        List<List<String>> list = new ArrayList<>();
        List<String> data1 = new ArrayList<>();
        for (int i = 0; i < 30; i += 2) {
            data1.add(i + "");
        }
        List<String> data2 = new ArrayList<>();
        data2.add("M");
        data2.add("T");
        data2.add("W");
        data2.add("T");
        data2.add("F");
        data2.add("S");
        data2.add("S");
        List<String> data3 = new ArrayList<>();
        for (int i = 0; i < 24; i += 2) {
            data3.add(i + "");
        }
        list.add(data1);
        list.add(data2);
        list.add(data3);
        return list;
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
            viewHolder.mMonthDataView.setData(getData().get(position));
            viewHolder.mMonthDataView.setTextList(getTextData().get(position));
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
