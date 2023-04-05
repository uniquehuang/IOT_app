package com.zjxu.hwl.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BaseFragment <V extends com.zjxu.hwl.base.BaseView,P extends BasePresenter>extends Fragment implements com.zjxu.hwl.base.BaseView {
    private P mvpPresenter;
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        injectDependencies();
        mvpPresenter=createPresenter();
        if(mvpPresenter!=null){
            mvpPresenter.setView((V)this);
        }
        super.onViewCreated(view,savedInstanceState);
    }
    protected void injectDependencies(){}
    protected abstract P createPresenter();
    public abstract View initView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState);

    public void onDestoryView(){
        super.onDestroyView();
        if(mvpPresenter!=null){
            mvpPresenter.detachView();
        }
    }
    public <R> void toSubscribe(Observable<R> observable, rx.Subscriber<R> s){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
