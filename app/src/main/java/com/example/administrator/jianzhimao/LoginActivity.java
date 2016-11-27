package com.example.administrator.jianzhimao;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
    private  String username ;
    private  String password ;
    private EditText ed_account;
    private EditText ed_password;
    private Context lcontext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lcontext = this;
        username = "admin";
        password = "admin";
        ed_account = (EditText) findViewById(R.id.login_account);
        ed_password = (EditText) findViewById(R.id.login_password);

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

                if(username.equals(ed_account.getText().toString()) && password.equals(ed_password.getText().toString()) ){
                    SPUtils.putBoolean(lcontext,"welcomeGuide","isLogin",true);
                    Dialog dialog = new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star).setTitle("登陆成功")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    goActivity(MainActivity.class);
                                }
                            }).create();
                    dialog.show();
                }else {
                    Dialog dialog = new AlertDialog.Builder(this).setIcon(android.R.drawable.btn_star).setTitle("提示")
                            .setMessage("用户名或密码错误，请重新输入！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ed_account.setText("");
                                    ed_password.setText("");
                                }
                            }).create();
                    dialog.show();
                }


                break;


        }

    }
    private void goActivity(Class cls){

        Intent intent = new Intent(lcontext,cls).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        LoginActivity.this.startActivity(intent);
    }
}
