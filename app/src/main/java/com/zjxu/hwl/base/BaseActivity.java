package com.zjxu.hwl.base;     //黄万霖

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zjxu.hwl.App;
import com.zjxu.hwl.injection.component.ActivityComponent;
import com.zjxu.hwl.injection.component.ApplicationComponent;
import com.zjxu.hwl.injection.component.DaggerActivityComponent;
import com.zjxu.hwl.injection.module.ActivityModule;

public abstract class BaseActivity<V extends BaseView,P extends com.zjxu.hwl.base.BasePresenter>extends AppCompatActivity implements BaseView {
    private P mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        injectDependencies();
        mvpPresenter=createPresenter();
        if(mvpPresenter!=null){
            mvpPresenter.setView((V)this);
        }
    }
    protected abstract void injectDependencies();
    protected abstract P createPresenter();

    //获取接口实现类
    private ActivityComponent mActivityComponent;
    public ActivityComponent getmActivityComponent() {
        if(mActivityComponent==null){
            mActivityComponent= DaggerActivityComponent.builder()
                    .activityModule(getActivityModule())
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }
  protected ApplicationComponent getApplicationComponent(){
      return ((App)getApplication()).component();
  }
  private ActivityModule getActivityModule(){
      return new ActivityModule(this);
  }
  @Override
    protected void onDestroy(){
      super.onDestroy();
      if(mvpPresenter!=null){
          mvpPresenter.detachView();
      }
  }
}
