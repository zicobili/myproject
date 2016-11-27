package com.example.administrator.jianzhimao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class enrolljob_sucess extends AppCompatActivity implements View.OnClickListener {
    private View backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolljob_sucess);

        backToHome = findViewById(R.id.erl_back_to_home);
        backToHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.erl_back_to_home:
                finish();
                break;
        }
    }
}
