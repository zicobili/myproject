package com.example.administrator.jianzhimao;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.jianzhimao.adapter.Job;
import com.example.administrator.jianzhimao.adapter.Joblistadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public class FragmentIndex extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener,Joblistadapter.Callback {
    private View jinggang;

    private Joblistadapter adapter;
    private List<Job> list = new ArrayList<Job>();
    private Context mContext;
    private ListView listView;
    private ScrollView sv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i = 0;i<30;i++){
            list.add(new Job("","","测试标题"+i,"","","",""));
        }
        adapter = new Joblistadapter(getActivity(),list,this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_index,null);
        ListView listView = (ListView) v.findViewById(R.id.joblist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        sv = (ScrollView) v.findViewById(R.id.scrollview);
        sv.smoothScrollTo(0, 0);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setlinnearclick();

    }

    private void setlinnearclick() {
        jinggang.setOnClickListener(this);

    }

    private void initView() {
        jinggang = getActivity().findViewById(R.id.jinggang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jinggang:
                Intent i = new Intent(getActivity(),ActivityJinggang.class);
                startActivity(i);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent jbintent = new Intent(getActivity(),ActivityJobDetail.class);
        startActivity(jbintent);
    }

    @Override
    public void click(View v) {

    }
}