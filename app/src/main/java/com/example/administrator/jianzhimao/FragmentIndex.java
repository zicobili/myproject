package com.example.administrator.jianzhimao;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.blankj.utilcode.utils.BarUtils;
import com.example.administrator.jianzhimao.adapter.Job;
import com.example.administrator.jianzhimao.adapter.Joblistadapter;
import com.example.administrator.jianzhimao.banner.banerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentIndex extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener,Joblistadapter.Callback {
    private View jinggang;
    private View miaomission;
    private View nearjob;
    private View parttimetrip;

    private Joblistadapter adapter;
    private List<Job> list = new ArrayList<Job>();
    private Context mContext;
    private ListView listView;
    private ScrollView sv;



    //滑动透明
    private View topbar;
    private myScrollView scrollView;  //整体ScrollView
    private static final int START_ALPHA = 0;
    private static final int END_ALPHA = 255;
    private int fadingHeight = 600;   //当ScrollView滑动到什么位置时渐变消失（根据需要进行调整）
    private Drawable drawable;        //顶部渐变布局需设置的Drawable


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i = 0;i<30;i++){
            list.add(new Job("","","测试标题"+i,"","","",""));
        }
        adapter = new Joblistadapter(getActivity(),list,this);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_index,null);
        ////////////////////listview/////////////////////////////
        ListView listView = (ListView) v.findViewById(R.id.joblist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setFocusable(false);
        sv = (ScrollView) v.findViewById(R.id.scrollview);
        sv.smoothScrollTo(0, 0);


        ///////////////////banner//////////////////////////////////
        Banner banner = (Banner) v.findViewById(R.id.index_banner);
        //设置图片加载器
        banner.setImageLoader(new banerImageLoader());
        //设置图片集合
        String images[] = {"http://img1.tuniucdn.com/img/20150521/hdch/biyeji/byjbanner.jpg"
                ,"http://resources.51camel.com/resources/uploadfiles/wechatarticle/news/635869438316236865.jpeg"
        ,"http://img.zcool.cn/community/01c58b57c00ee90000018c1bb86b73.jpg@900w_1l_2o_100sh.jpg"
        ,"http://pic.qiantucdn.com/58pic/21/68/94/72f58PICkGJ_1024.jpg"};
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



        //滑动透明
        //滑动透明
        topbar =v.findViewById(R.id.topbar);
        int statusBarHeight = BarUtils.getStatusBarHeight(v.getContext());
        topbar.setPadding(getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,statusBarHeight,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) );
        scrollView = (myScrollView) v.findViewById(R.id.scrollview);
        drawable = getResources().getDrawable(R.drawable.color_exam_grey);
        drawable.setAlpha(START_ALPHA);
        topbar.setBackgroundDrawable(drawable);

        scrollView.setOnScrollChangedListener(scrollChangedListener);



        return v;
    }
    private myScrollView.OnScrollChangedListener scrollChangedListener = new myScrollView.OnScrollChangedListener() {
        @Override
        public void onScrollChanged(ScrollView who, int x, int y, int oldx, int oldy) {
            if (y > fadingHeight) {
                y = fadingHeight;   //当滑动到指定位置之后设置颜色为纯色，之前的话要渐变---实现下面的公式即可
            }
            drawable.setAlpha(y * (END_ALPHA - START_ALPHA) / fadingHeight + START_ALPHA);
        }
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setlinnearclick();

    }

    private void setlinnearclick() {
        jinggang.setOnClickListener(this);
        parttimetrip.setOnClickListener(this);
        nearjob.setOnClickListener(this);
        miaomission.setOnClickListener(this);

    }

    private void initView() {
        jinggang = getActivity().findViewById(R.id.jinggang);
        parttimetrip = getActivity().findViewById(R.id.parttime_trip);
        nearjob = getActivity().findViewById(R.id.nearjob);
        miaomission = getActivity().findViewById(R.id.miao_mission);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jinggang:
                GoUtils.gotoac(getActivity(),ActivityJinggang.class);
                break;
            case R.id.miao_mission:
                GoUtils.gotoac(getActivity(),miaomission.class);
                break;
            case R.id.nearjob:
                GoUtils.gotoac(getActivity(),nearjob.class);
                break;
            case R.id.parttime_trip:
                GoUtils.gotoac(getActivity(),parttimetrip.class);
                break;
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