package com.zjxu.hwl.injection.component;

import android.app.Application;
import android.content.Context;

import com.zjxu.hwl.App;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.UserPreferencesHelper;
import com.zjxu.hwl.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton//单例
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App application);
    Application application();//将Application开放给其他Component使用
    Context context();//将Context开放给其他Component使用
    HttpService httpService();//将HttpService开放给其他Component使用
   UserPreferencesHelper userPreferencesHelper();//将UserPreferencesHelper开放给其他Component使用
}















