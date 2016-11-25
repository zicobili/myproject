package com.example.administrator.jianzhimao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
                Dialog dialog = new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_dialog)
                        .setTitle("提示：注销用户")
                        .setMessage("注销后缓存的资料可能丢失！\n是否进行注销操作？")
                        .setPositiveButton("注销", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GoUtils.logout(me_more.this);
                            }
                        })
                        .setNeutralButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                dialog.show();
                break;

        }
    }
}
