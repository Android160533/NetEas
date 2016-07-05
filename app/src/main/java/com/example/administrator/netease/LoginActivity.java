package com.example.administrator.netease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.netease.dao.UserDao;

public class LoginActivity extends AppCompatActivity{

    private EditText editText_username;
    private EditText editText_password;
    private TextView text_register;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    //寻找到账号输入，密码输入，和注册点击
    private void initView(){
        editText_username = (EditText) findViewById(R.id.edit_username);
        editText_password = (EditText) findViewById(R.id.edit_password);
        text_register = (TextView) findViewById(R.id.text_register);
        //用户点击了“注册账号”，则跳转至注册页面
        text_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private UserDao userDao = new UserDao();
    public void click_login(View view){
        //点击登录按钮，进行登录操作
        userDao.Login(editText_username.getText().toString(), editText_password.getText().toString(), this, new UserDao.Success(){
            @Override
            public void success(String s){
                //登录成功，返回的数据时登录时输入的账号
            }
        });
    }
}
