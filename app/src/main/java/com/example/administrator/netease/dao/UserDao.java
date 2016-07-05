package com.example.administrator.netease.dao;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.List;

import Bean.UserInfo;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 16-7-5.
 */
public class UserDao{

    /**
     *
     * @param name : 用户登录时输入的用户名
     * @param pwd ：用户登录时输入的密码
     * @param context :进行的登录界面的上下文对象
     * @param success :请求数据成功后回调的接口
     */
    public void Login (final String name, final String pwd, final Context context, final Success success){
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
            Toast.makeText(context, "账号或密码不能为空！！", Toast.LENGTH_SHORT).show();
        }else {
            //账号和密码都已填写，上传数据到服务器中验证输入的账号是否正确
            final BmobQuery<UserInfo> query = new BmobQuery<>();
            //向远程数据库中查询用户表中的用户名列，判断是否此用户名已经存在
            query.addWhereEqualTo("name",name);
            query.findObjects(context, new FindListener<UserInfo>(){
                @Override
                public void onSuccess(List<UserInfo> list){
                    //请求账号数据成功
                    if(list.size()==0){
                        //当list的长度等于0时，即账号不存在，
                        Toast.makeText(context, "您输入的用户名有误", Toast.LENGTH_SHORT).show();
                    }else {
                        //list的长度不为0，即账号存在且输入正确，开始验证密码
                        query.addWhereEqualTo("pwd",pwd);
                        query.findObjects(context, new FindListener<UserInfo>(){
                            @Override
                            public void onSuccess(List<UserInfo> list){
                                //请求密码数据成功
                                if(list.size() == 0){
                                    //密码输入有误，匹配不成功
                                    Toast.makeText(context, "密码错误！", Toast.LENGTH_SHORT).show();
                                }else {
                                    //密码输入正确，账号与密码都匹配成功，则登录成功
                                    Toast.makeText(context , "登录成功", Toast.LENGTH_SHORT).show();
                                    //成功后调用成功接口,把用户名传回去，方便后面需要的操作
                                    success.success(name);
                                }
                            }

                            @Override
                            public void onError(int i, String s){
                            }
                        });
                    }
                }

                @Override
                public void onError(int i, String s){
                }
            });
        }
    }

    public interface Success{
        void success(String s);
    }
    public interface Failed{
        void failed(String s);
    }

    /**
     *
     * @param name : 用户注册时输入的用户名
     * @param pwd ：用户注册时输入的密码
     * @param context :进行的注册界面的上下文对象
     * @param success :请求数据成功后回调的接口
     */
    public void Register(String name , String pwd , final Context context, final Success success){
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
            Toast.makeText(context, "账号或密码不能为空！！", Toast.LENGTH_SHORT).show();
        }else {
            //密码和账号不为空，实现注册功能，把数据上传到远程数据端
            final UserInfo u1 = new UserInfo();
            u1.setName(name);
            u1.setPwd(pwd);
            BmobQuery<UserInfo> query = new BmobQuery<>();
            //向远程数据库中查询用户表中的用户名列，判断是否此用户名已经存在
            query.addWhereEqualTo("name",u1.getName());
            query.findObjects(context, new FindListener<UserInfo>(){
                //找到数据回调此方法，
                @Override
                public void onSuccess(List<UserInfo> list){
                    if(list.size()==0){
                        //向服务端保存数据
                        u1.save(context, new SaveListener(){
                            //上传数据成功时回调此方法
                            @Override
                            public void onSuccess(){
                                Toast.makeText(context, "注册成功！", Toast.LENGTH_LONG).show();
                                success.success("success");
                            }
                            //上传数据失败后回调此方法
                            @Override
                            public void onFailure(int i, String s){
                                Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        Toast.makeText(context, "用户名已存在，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onError(int i, String s){
                }
            });
        }
    }

}
