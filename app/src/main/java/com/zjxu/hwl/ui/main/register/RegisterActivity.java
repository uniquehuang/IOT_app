package com.zjxu.hwl.ui.main.register;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.Toast;

import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.ui.main.login.LoginAcivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class RegisterActivity  extends BaseActivity<RegisterView,RegisterPresenter> implements  RegisterView{
    @Inject
    RegisterPresenter registerPresenter;//标记在引用类中声明的被依赖类的变量上，让Dagger2为其提供依赖
    private Unbinder unbinder;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_email)
    EditText etUserEmail;
    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;

    @OnClick(R.id.bt_register)
    void register(){
        String username = etUserName.getText().toString();
        String email = etUserEmail.getText().toString();
        String password = etUserPwd.getText().toString();
        //调用RegisterPresenter处理注册逻辑
        registerPresenter.register(username,email,password);
    }
    @OnClick(R.id.link_login)
    void toLogin(){
        //跳转登录页面
        Intent intent = new Intent(this, LoginAcivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void injectDependencies(){
        //注册Dagger2  在ActivityComponent中添加对应的方法
        getmActivityComponent().inject(this);
    }

    @Override
    protected RegisterPresenter createPresenter(){
        return registerPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //使用完解绑ButterKnife，避免内存泄露
        unbinder.unbind();
    }

    @Override
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSucceed(){
        //注册成功，跳转到登录
        toLogin();
    }
}
