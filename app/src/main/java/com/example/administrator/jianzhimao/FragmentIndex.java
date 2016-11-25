package com.example.administrator.jianzhimao;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.example.administrator.jianzhimao.banner.banerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public class FragmentIndex extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{
    private View jinggang;

    private Joblistadapter adapter;
    private List<Job> list = new ArrayList<Job>();
    private Context mContext;
    private ListView listView;
    private ScrollView sv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i = 0;i<10;i++){
            list.add(new Job("","","测试标题"+i,"","","",""));
        }
        adapter = new Joblistadapter(getActivity(),list);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_index,null);
        ListView listView = (ListView) v.findViewById(R.id.joblist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setFocusable(false);
        sv = (ScrollView) v.findViewById(R.id.scrollview);
        sv.smoothScrollTo(0, 0);



        //banner设置
        ///////////////////banner//////////////////////////////////
        Banner banner = (Banner) v.findViewById(R.id.index_banner);
        //设置图片加载器
        banner.setImageLoader(new banerImageLoader());
        //设置图片集合
        String images[] = {"http://img.tuniucdn.com/site/file/zt/tuniuyingshi/zt/zhibo/20160811summer/banner.jpg","http://img3.imgtn.bdimg.com/it/u=807633881,2861352892&fm=15&gp=0.jpg"};
//        imagesUrl.add("http://c.hiphotos.baidu.com/image/pic/item/eac4b74543a98226e523cd238882b9014b90ebd0.jpg");
//        imagesUrl.add("http://g.hiphotos.baidu.com/image/h%3D200/sign=550078df4f36acaf46e091fc4cdb8d03/bd3eb13533fa828b38f1a605f91f4134960a5a01.jpg");
//        imagesUrl.add("http://e.hiphotos.baidu.com/image/h%3D200/sign=ad33f815868ba61ec0eecf2f713597cc/43a7d933c895d143b14d1afc77f082025aaf0731.jpg");
//        imagesUrl.add("http://e.hiphotos.baidu.com/image/h%3D200/sign=1083dd2aa7cc7cd9e52d33d909002104/838ba61ea8d3fd1ffd1864fd344e251f94ca5fe0.jpg");
//        imagesUrl.add("http://b.hiphotos.baidu.com/image/pic/item/6609c93d70cf3bc756100b2bd500baa1cc112ae1.jpg");
        banner.setImages(Arrays.asList(images));
        Log.v("aaaaaa",images.toString());
        //banner config
        banner.setIndicatorGravity(BannerConfig.LEFT);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


        return v;
    }




    //Linearlayout的点击时间应该在onActivityCreated里实现
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

}