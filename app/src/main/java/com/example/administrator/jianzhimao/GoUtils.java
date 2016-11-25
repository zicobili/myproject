package com.example.administrator.jianzhimao;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by Administrator on 2016/11/25.
 */

public class  GoUtils {
    public static void goandcheck (final Context mcontext, Class mclass){
        if(SPUtils.getBoolean(mcontext,"welcomeGuide","isLogin")){
            gotoac(mcontext,mclass);

        }else {
            Dialog dialog = new AlertDialog.Builder(mcontext)
                    .setIcon(android.R.drawable.btn_star)
                    .setTitle("请先登录")
                    .setMessage("登陆后更多特权!")
                    .setPositiveButton("稍后再说", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("登录/注册", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gotoac(mcontext,LoginActivity.class);
                        }
                    }).create();
            dialog.show();
        }


    }



    public static void gotoac (Context gcontext,Class mclass){
        Intent intent = new Intent(gcontext,mclass);
        gcontext.startActivity(intent);
    }

}
