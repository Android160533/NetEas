package Myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 16-7-4.
 */
public class Fragment_adapter extends FragmentPagerAdapter{
    public Fragment_adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        return null;
    }

    @Override
    public int getCount(){
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return super.getPageTitle(position);
    }
}
