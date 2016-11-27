package com.example.administrator.jianzhimao;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.utils.BarUtils;

/**
 * Created by Administrator on 2016/10/31.
 */

public class FragmentAlljob extends Fragment implements View.OnClickListener {
    private View flt_type;
    private View flt_area;
    private View flt_oder;
    private View flt_flt;

    private TextView tv_type;
    private TextView tv_area;
    private TextView tv_oder;
    private TextView tv_flt;

    private View grayview;

    private PopupWindow mpopwin;
    private LinearLayout mlayout;

    private Context mcontext;

    private View topbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_alljob,null);
        mcontext = v.getContext();
        flt_area = v.findViewById(R.id.filter_area);
        flt_flt = v.findViewById(R.id.filter_flt);
        flt_oder = v.findViewById(R.id.filter_oder);
        flt_type = v.findViewById(R.id.filter_type);
        flt_flt.setOnClickListener(this);
        flt_type.setOnClickListener(this);
        flt_area.setOnClickListener(this);
        flt_oder.setOnClickListener(this);

        tv_area = (TextView) v.findViewById(R.id.tv_area);
        tv_flt = (TextView) v.findViewById(R.id.tv_flt);
        tv_oder = (TextView) v.findViewById(R.id.tv_oder);
        tv_type = (TextView) v.findViewById(R.id.tv_type);

        grayview = v.findViewById(R.id.grayview);


        topbar =v.findViewById(R.id.topbar);
        int statusBarHeight = 20+BarUtils.getStatusBarHeight(v.getContext());
        topbar.setPadding(getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,statusBarHeight,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) ,getResources().getDimensionPixelOffset(R.dimen.dimen_20_dip) );


        return v;
    }

    @Override
    public void onClick(View v) {
        showPopupWindow(v);

    }

    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mcontext).inflate(
                R.layout.popwin_filter, null);
        // 设置按钮的点击事件
        Button button = (Button) contentView.findViewById(R.id.ppw_enter);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "button is pressed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.selectmenu_bg_downward));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

    }
}
