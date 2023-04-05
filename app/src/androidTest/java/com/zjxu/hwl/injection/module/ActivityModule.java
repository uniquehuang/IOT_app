package com.zjxu.hwl.injection.module;

import android.app.Activity;


import com.zjxu.hwl.injection.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity(){
        return this.activity;
    }

}













