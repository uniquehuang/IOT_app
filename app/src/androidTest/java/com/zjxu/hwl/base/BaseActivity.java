package com.zjxu.hwl.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<V extends com.zjxu.hwl.base.BaseView,P extends com.zjxu.hwl.base.BasePresenter>extends AppCompatActivity implements com.zjxu.hwl.base.BaseView {
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

/*    private ActivityComponent mActivityComponent;
    public ActivityComponent getmActivityComponent() {
        if(mActivityComponent==null){
            mActivityComponent=DaggerActivityComponent.builder()
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
  }*/
  @Override
    protected void onDestroy(){
      super.onDestroy();
      if(mvpPresenter!=null){
          mvpPresenter.detachView();
      }
  }
}
