package com.example.administrator.jianzhimao;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/10/31.
 */

public class FragmentMe extends Fragment implements View.OnClickListener {
    private View item_more;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_me,null);
        item_more = v.findViewById(R.id.me_item_more);
        item_more.setOnClickListener(this);

        return  v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_item_more:
                GoUtils.gotoac(getActivity(),me_more.class);
                break;
        }
    }
}
