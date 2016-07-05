package com.example.administrator.netease;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.netease.dao.UserDao;

public class RegisterActivity extends AppCompatActivity{

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView(){
        username = (EditText) findViewById(R.id.edit_reguser);
        password = (EditText) findViewById(R.id.edit_regpwd);
    }

    public void click_register(View view){
        String user = username.getText().toString();
        String pwd = password.getText().toString();
        UserDao userDao = new UserDao();
        userDao.Register(user, pwd, this, new UserDao.Success(){
            @Override
            public void success(String s){
                RegisterActivity.this.finish();
            }
        });
    }
}
