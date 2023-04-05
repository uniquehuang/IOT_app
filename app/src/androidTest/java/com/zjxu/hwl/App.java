package com.zjxu.hwl;

import android.app.Application;

import com.zjxu.hwl.injection.component.ApplicationComponent;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();

    }

    private void initInjector() {
        /*component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);*/
    }

    public ApplicationComponent component() {
        return component;
    }

}
