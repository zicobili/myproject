package com.example.administrator.jianzhimao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class me_more extends AppCompatActivity implements View.OnClickListener{
    private View mlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_more);

        mlogout = findViewById(R.id.mlogout);
        if(SPUtils.getBoolean(getBaseContext(),"welcomeGuide","isLogin")){
            mlogout.setVisibility(View.VISIBLE);
        }else {
            mlogout.setVisibility(View.GONE);
        }
        mlogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mlogout:
                GoUtils.logout(this);
                break;

        }
    }
}
