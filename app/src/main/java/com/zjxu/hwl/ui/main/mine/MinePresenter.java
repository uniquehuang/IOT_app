package com.zjxu.hwl.ui.main.mine;

import android.app.Activity;

import com.zjxu.hwl.base.BasePresenter;
import com.zjxu.hwl.entity.UserEntity;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;
import com.zjxu.hwl.http.UserPreferencesHelper;

import javax.inject.Inject;

import rx.Observable;

public class MinePresenter extends BasePresenter<MineView> {
    @Inject
    HttpService service;
    @Inject
    UserPreferencesHelper preferencesHelper;
    @Inject
    Activity activity;
    @Inject
    public MinePresenter(){
    }
    public void getUserInfo(){
        Observable<HttpResult<UserEntity>> observable =
                service.getUserInfo(preferencesHelper.getTokenValue());
        toSubscribe(observable,new ProgressDialogSubscriber<HttpResult<UserEntity>>(activity){
            @Override
            public void onNext(HttpResult<UserEntity> result){
                if (result!= null){
                    if (result.getStatus() == 1 && result.getData()!=null){
                        //ui界面展示数据
                        getView().showUserHead("http://120.26.90.186:8083/resource/tx.jpg");
                        getView().showUserName(result.getData().getUsername());
                        getView().showUserEmail(result.getData().getEmail());
                    }else {
                        getView().showToast(result.getMsg());
                    }
                }else {
                    getView().showToast("获取用户信息失败");
                }
            }
        });
    }
    public  void logout(){
        Observable<HttpResult> observable = service.logout(preferencesHelper.getTokenValue());
        toSubscribe(observable,new ProgressDialogSubscriber<HttpResult>(activity){
            @Override
            public void onNext(HttpResult result){
                if (result != null){
                    if (result.getStatus()==1){
                        getView().showToast(result.getMsg());
                        //退出登录成功
                        getView().logoutSucceed();
                        //清空保存的用户信息
                        preferencesHelper.clear();
                    }else {
                        getView().showToast(result.getMsg());
                    }
                }else {
                    getView().showToast("退出登录失败result == null");
                }
            }
        });
    }

    public void changeHead() {
    }
}
