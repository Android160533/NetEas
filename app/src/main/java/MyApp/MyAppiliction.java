package MyApp;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 16-7-4.
 */
public class MyAppiliction extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        //初始化Bmob
        Bmob.initialize(this,"02f59025177eae56f5ceaa9907fbef32");
    }
}
