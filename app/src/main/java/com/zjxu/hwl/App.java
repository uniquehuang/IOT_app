package com.zjxu.hwl;

import android.app.Application;

import com.zjxu.hwl.injection.component.ApplicationComponent;
import com.zjxu.hwl.injection.component.DaggerApplicationComponent;
import com.zjxu.hwl.injection.module.ApplicationModule;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();

    }

    private void initInjector() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}
