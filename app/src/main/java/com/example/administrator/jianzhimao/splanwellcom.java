package com.example.administrator.jianzhimao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class splanwellcom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splanwellcom);

        new Handler(new Handler.Callback() {

            public boolean handleMessage(Message msg) {

                if (SPUtils.getBoolean(getBaseContext(), "welcomeGuide", "isFirst")) {
                    if(SPUtils.getBoolean(getBaseContext(),"welcomeGuide","isLogin")){
                        goActivity(MainActivity.class);

                    }else {
                        goActivity(LoginActivity.class);
                    }
                } else {
                    goActivity(SplashActivity.class);//引导页
                    SPUtils.putBoolean(getBaseContext(), "welcomeGuide", "isFirst", true);
                }
                finish();
                return false;
            }
        }).sendEmptyMessageDelayed(0, 2000);//延迟2秒
    }
    private void goActivity(Class cls){

        Intent intent = new Intent(splanwellcom.this,cls);
        splanwellcom.this.startActivity(intent);
        splanwellcom.this.finish();
    }
}
