package Myadapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by Administrator on 16-7-4.
 */
public class Pager_adapter extends PagerAdapter{
    @Override
    public int getCount(){
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return false;
    }
}
