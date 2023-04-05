package com.zjxu.hwl.ui.main.login;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import com.zjxu.hwl.base.BasePresenter;
import com.zjxu.hwl.entity.LoginEntity;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;
import com.zjxu.hwl.http.UserPreferencesHelper;

import javax.inject.Inject;

import rx.Observable;

public class LoginPresenter extends BasePresenter<LoginView> {
    @Inject
    HttpService httpService;
    @Inject
    Activity activity;
    @Inject
    UserPreferencesHelper preferencesHelper;
    @Inject
    public LoginPresenter(){

    }
    public void login(final String usename,final String password){
        if(TextUtils.isEmpty(usename)){
            getView().showToast("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(password)){
            getView().showToast("请输入密码");
            return;
        }
        Observable<HttpResult<LoginEntity>> observable = httpService.login(usename,password,"app");
        toSubscribe(observable, new ProgressDialogSubscriber<HttpResult<LoginEntity>>(activity) {
            @Override
            public void onNext(HttpResult<LoginEntity> loginEntityHttpResult) {
                if (loginEntityHttpResult!=null){
                    if (loginEntityHttpResult.getStatus()==1 && loginEntityHttpResult.getData()!=null){
                        getView().loginSucceed();                       // 这里使用的的 loginSucceed方法
                        getView().showToast("登陆成功");
                        //登陆成功，保存Token和Uuid
                        preferencesHelper.putTokenValue(loginEntityHttpResult.getData().getTokenValue());
                        preferencesHelper.putUuid(loginEntityHttpResult.getData().getUuid());
                        //保存登陆的用户名和密码
                        preferencesHelper.putUserName(usename);
                        preferencesHelper.putPassword(password);
                        Log.d("LoginPresenter","login succuss"+loginEntityHttpResult.toString());
                    }else {
                        getView().showToast(loginEntityHttpResult.getMsg());
                    }
                }else {
                    getView().showToast(("登录失败loginEntityHttpResult==null"));
                }
            }
        });
    }
    public void autoLogin(){
        String userName = preferencesHelper.getUserName();
        String password = preferencesHelper.getPassword();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
            login(userName,password);
        }
    }
}
