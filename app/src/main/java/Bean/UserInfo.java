package Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 16-7-5.
 */
public class UserInfo extends BmobObject{
    private String name;
    private String pwd;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}
