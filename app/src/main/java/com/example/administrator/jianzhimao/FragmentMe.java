package com.example.administrator.jianzhimao;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.utils.BarUtils;


public class FragmentMe extends Fragment implements View.OnClickListener {
    private View topbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_me,null);
        View ll_myenroll = v.findViewById(R.id.ll_myenroll);
        ll_myenroll.setOnClickListener(this);
        View me_favorite = v.findViewById(R.id.me_favorite);
        me_favorite.setOnClickListener(this);
        View me_suggest = v.findViewById(R.id.me_suggest);
        me_suggest.setOnClickListener(this);
        View me_more = v.findViewById(R.id.me_more);
        me_more.setOnClickListener(this);
        View me_personal = v.findViewById(R.id.me_personal);
        me_personal.setOnClickListener(this);
        View me_jobcard = v.findViewById(R.id.me_jobcard);
        me_jobcard.setOnClickListener(this);
        View me_renzheng = v.findViewById(R.id.me_renzheng);
        me_renzheng.setOnClickListener(this);
        View me_interest = v.findViewById(R.id.me_interest);
        me_interest.setOnClickListener(this);
        View me_surance =v.findViewById(R.id.me_surance);
        me_surance.setOnClickListener(this);
        View me_collect = v.findViewById(R.id.me_collect);
        me_collect.setOnClickListener(this);

        topbar =v.findViewById(R.id.topbar);
        int statusBarHeight = BarUtils.getStatusBarHeight(v.getContext());
        topbar.setPadding(0,statusBarHeight,0,0);

        return  v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_myenroll:
                Intent intent1 = new Intent(getActivity(),me_myenroll_main.class);
                startActivity(intent1);
                break;
            case R.id.me_favorite:
                Intent intent2 = new Intent(getActivity(),me_favorite.class);
                startActivity(intent2);
                break;
            case R.id.me_suggest:
                Intent intent3 = new Intent(getActivity(),me_suggest.class);
                startActivity(intent3);
                break;
            case R.id.me_more:
                Intent intent4 = new Intent(getActivity(),me_more.class);
                startActivity(intent4);
                break;
            case R.id.me_interest:
                Intent intent5 = new Intent(getActivity(),me_interest.class);
                startActivity(intent5);
                break;
            case R.id.me_personal:
                Intent intent6 = new Intent(getActivity(),me_personal.class);
                startActivity(intent6);
                break;
            case R.id.me_renzheng:
                Intent intent7 = new Intent(getActivity(),me_renzheng.class);
                startActivity(intent7);
                break;
            case R.id.me_jobcard:
                Intent intent8 = new Intent(getActivity(),me_jobcard.class);
                startActivity(intent8);
                break;
            case R.id.me_collect:
                Intent intent9 = new Intent(getActivity(),me_collect.class);
                startActivity(intent9);
                break;
            case R.id.me_surance:
                Intent intent10 = new Intent(getActivity(),me_surance.class);
                startActivity(intent10);
                break;

        }
    }
}
