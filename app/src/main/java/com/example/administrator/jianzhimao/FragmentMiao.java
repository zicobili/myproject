package com.example.administrator.jianzhimao;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.utils.BarUtils;

/**
 * Created by Administrator on 2016/10/31.
 */

public class FragmentMiao extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;

    private FragmentMiaoMessage fg1;
    private FragmentMiaoContact fg2;
    private FragmentManager fManager;

    private View topbar;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_miao,null);
        fManager = getFragmentManager();
        rg = (RadioGroup) v.findViewById(R.id.miao_rg);
        rg.setOnCheckedChangeListener(this);
        rb1 = (RadioButton) v.findViewById(R.id.miao_rb1);
        rb2 = (RadioButton) v.findViewById(R.id.miao_rb2);
        rb1.setChecked(true);

        topbar =v.findViewById(R.id.topbar);
        int statusBarHeight = BarUtils.getStatusBarHeight(v.getContext());
        topbar.setPadding(getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,statusBarHeight,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) );


        return v;
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.miao_rb1:
                if(fg1 == null){
                    fg1 = new FragmentMiaoMessage();
                    fTransaction.add(R.id.miao_ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.miao_rb2:
                if(fg2 == null){
                    fg2 = new FragmentMiaoContact();
                    fTransaction.add(R.id.miao_ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
        }
        fTransaction.commit();
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);

    }
}