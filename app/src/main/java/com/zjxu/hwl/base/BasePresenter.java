package com.zjxu.hwl.base;

import android.widget.Toast;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BasePresenter <T extends BaseView>{
    public BasePresenter(){

    }
    private T mView;
    public void setView(T mvpView){this.mView=mvpView;}
    public T getView(){return mView;}
    public boolean isViewAttached(){return mView!=null;}
    public void detachView(){
        if(mView!=null){
            this.mView=null;
        }
    }
    //放在BasePresenter中公用

    public <R> void toSubscribe(Observable<R> observable, rx.Subscriber<R> s){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
