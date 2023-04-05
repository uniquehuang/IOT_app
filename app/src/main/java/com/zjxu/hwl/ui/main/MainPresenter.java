package com.zjxu.hwl.ui.main;

import android.app.Activity;
import rx.Observable;
import com.zjxu.hwl.base.BasePresenter;
import com.zjxu.hwl.entity.LoginEntity;
import com.zjxu.hwl.http.HttpResultFunc;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;
import com.zjxu.hwl.http.UserPreferencesHelper;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView> {
    @Inject
    HttpService httpService;
    @Inject
    Activity activity;
    @Inject
    UserPreferencesHelper preferencesHelper;
    @Inject
    public MainPresenter(){
    }
}
