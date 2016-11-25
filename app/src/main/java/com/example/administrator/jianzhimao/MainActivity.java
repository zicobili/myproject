package com.example.administrator.jianzhimao;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup navbar;
    private RadioButton rb1;

    private FragmentIndex fg1;
    private FragmentAlljob fg2;
    private FragmentMiao fg3;
    private FragmentMe fg4;
    private FragmentManager main_fManager;
    private FragmentTransaction main_fTrasaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navnar start
        main_fManager = getFragmentManager();
        navbar= (RadioGroup) findViewById(R.id.main_navbar);
        navbar.setOnCheckedChangeListener(this);
        rb1= (RadioButton) findViewById(R.id.main_rb1);
        rb1.setChecked(true);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        main_fTrasaction = main_fManager.beginTransaction();
        hideAllFragment(main_fTrasaction);
        switch (checkedId){
            case R.id.main_rb1:
                if(fg1 == null){
                    fg1 = new FragmentIndex();
                    main_fTrasaction.add(R.id.main_lycontent,fg1);
                }else {
                    main_fTrasaction.show(fg1);
                }
                break;
            case R.id.main_rb2:
                if(fg2 == null){
                    fg2 = new FragmentAlljob();
                    main_fTrasaction.add(R.id.main_lycontent,fg2);
                }else {
                    main_fTrasaction.show(fg2);
                }
                break;
            case R.id.main_rb3:
                if(fg3 == null){
                    fg3 = new FragmentMiao();
                    main_fTrasaction.add(R.id.main_lycontent,fg3);
                }else {
                    main_fTrasaction.show(fg3);
                }
                break;
            case R.id.main_rb4:
                if(fg4 == null){
                    fg4 = new FragmentMe();
                    main_fTrasaction.add(R.id.main_lycontent,fg4);
                }else {
                    main_fTrasaction.show(fg4);
                }
                break;
        }
        main_fTrasaction.commit();

    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }
}