package com.example.administrator.jianzhimao;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText ed_account = (EditText) findViewById(R.id.login_account);
        EditText ed_password = (EditText) findViewById(R.id.login_password);

        Button btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        TextView login2 = (TextView) findViewById(R.id.login2);
        login2.setOnClickListener(this);

        TextView tv_rest = (TextView) findViewById(R.id.login_password);
        tv_rest.setOnClickListener(this);
        TextView tv_reg = (TextView) findViewById(R.id.login_reg);
        tv_reg.setOnClickListener(this);
        TextView skip = (TextView) findViewById(R.id.login_skip);
        skip.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_restpassword:
                goActivity(RestpasswordActivity.class);
                break;
            case  R.id.login_reg:
                goActivity(RegActivity.class);
                break;
            case R.id.login_skip:
                goActivity(MainActivity.class);
                break;
            case R.id.login2:
                Toast.makeText(this,"login2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_submit:
                Toast.makeText(this,"you click btn",Toast.LENGTH_SHORT).show();
                break;


        }

    }
    private void goActivity(Class cls){

        Intent intent = new Intent(LoginActivity.this,cls);
        LoginActivity.this.startActivity(intent);
        LoginActivity.this.finish();
    }
}
