package Myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 16-7-5.
 */
public class Title_adapter extends FragmentPagerAdapter{
    private String[]title;
    private List<Fragment>fragments;
    public Title_adapter(FragmentManager fm,String[]title,List<Fragment>fragments){
        super(fm);
        this.title=title;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return title[position];
    }
}
