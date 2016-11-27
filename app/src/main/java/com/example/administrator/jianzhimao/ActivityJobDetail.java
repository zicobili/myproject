package com.example.administrator.jianzhimao;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/11/7.
 */

public class ActivityJobDetail extends AppCompatActivity implements View.OnClickListener {
    private View jbd_contact;
    private View jbd_enroll;
    private Context mcontext;

    private TextView jbd_phone;
    private TextView jbd_phoneNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdetail);
        mcontext = this;

        //buttombar
        jbd_contact = findViewById(R.id.jbd_contact);
        jbd_enroll = findViewById(R.id.jbd_enroll);
        jbd_contact.setOnClickListener(this);
        jbd_enroll.setOnClickListener(this);

        jbd_phone = (TextView) findViewById(R.id.jbd_phone);
        jbd_phoneNum = (TextView) findViewById(R.id.jbd_phoneNum);

        jbd_phone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jbd_contact:
                GoUtils.goandcheck(mcontext,Activity_chat.class);
                break;
            case R.id.jbd_enroll:
                GoUtils.goandcheck(mcontext,enrolljob.class);
                break;
            case R.id.jbd_phone:
                Intent phoneintent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + jbd_phoneNum.getText().toString());
                phoneintent.setData(data);
                startActivity(phoneintent);
                break;
        }

    }
}
