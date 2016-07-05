package Myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 16-7-4.
 */
public class Fragment_adapter extends FragmentPagerAdapter{
    private List<Fragment>fragments;
    public Fragment_adapter(FragmentManager fm,List<Fragment>fragments){
        super(fm);
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


}
