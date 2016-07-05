package com.example.administrator.netease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import MyFragment.BlankFragment;
import Myadapter.Fragment_adapter;

public class MainActivity extends AppCompatActivity{
 
    private List<Fragment>fragments;
    private  ViewPager vp;
    private RadioGroup rg; //sfdsfsd
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,LoginActivity.class));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vp=(ViewPager) findViewById(R.id.mainvp);
        vp.requestDisallowInterceptTouchEvent(false);
        rg=(RadioGroup)findViewById(R.id.rg);
        fragments=new ArrayList<>();
        initView();
        initdata();
    }

    private void initdata(){
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
            }

            @Override
            public void onPageSelected(int position){
                RadioButton rb= (RadioButton) rg.getChildAt(position);
                rb.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state){
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                int position=-1;
                switch(checkedId){
                    case R.id.one:
                        position=0;
                        break;
                    case R.id.two:
                        position=1;
                        break;
                    case R.id.three:
                        position=2;
                        break;
                    case R.id.four:
                        position=3;
                        break;
                    case R.id.five:
                        position=4;
                        break;
                }
                if(position!=-1){
                    vp.setCurrentItem(position);
                }
            }
        });
    }

    private void initView(){

        for(int i = 0; i <rg.getChildCount(); i++){
            BlankFragment blankfragment=BlankFragment.newInstance((i+1),"");
            fragments.add(blankfragment);
        }
        Fragment_adapter ad=new Fragment_adapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(ad);
    }
}
