package com.example.administrator.netease;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import MyFragment.BlankFragment;
import Myadapter.Fragment_adapter;

public class MainActivity extends AppCompatActivity{
    String[] urls=new String[]{};
    private String[] titles;
    private List<Fragment>fragments;
    private  ViewPager vp;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vp=(ViewPager) findViewById(R.id.vp);
        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        fragments=new ArrayList<>();
        initView();
    }

    private void initView(){
      titles=new String[]{"头条","娱乐","热点","体育","财经","科技","汽车",
              "时尚","图片","轻松一刻","段子","军事","历史","家居","独家","游戏","健康",
              "政务","漫画","哒哒趣闻","彩票","美女"};
        for(int i = 0; i <titles.length; i++){
            BlankFragment blankfragment=BlankFragment.newInstance((i+1),"");
            fragments.add(blankfragment);
        }
        Fragment_adapter ad=new Fragment_adapter(getSupportFragmentManager(),titles,fragments);
        vp.setAdapter(ad);
        tabLayout.setupWithViewPager(vp);
    }
}
