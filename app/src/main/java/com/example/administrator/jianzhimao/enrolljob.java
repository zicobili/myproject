package com.example.administrator.jianzhimao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class enrolljob extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolljob);
        Button btn_enrolljob_submit = (Button) findViewById(R.id.btn_erolljob_submit);
        btn_enrolljob_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_erolljob_submit:
                Intent intent1 = new Intent(this,enrolljob_sucess.class);
                startActivity(intent1);
                break;
        }
    }
}
