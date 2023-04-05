package com.zjxu.hwl.base;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BasePresenter <T extends com.zjxu.hwl.base.BaseView>{
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

    public <R> void toSubscribe(Observable<R> o, rx.Subscriber<R> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
