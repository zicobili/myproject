package com.example.administrator.jianzhimao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class me_myenroll_main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg;
    private RadioButton rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_myenroll_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        rb1= (RadioButton) findViewById(R.id.rb1);
        rb1.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Toast.makeText(this, "Toast text, normal"+checkedId, Toast.LENGTH_SHORT).show();
    }
}
