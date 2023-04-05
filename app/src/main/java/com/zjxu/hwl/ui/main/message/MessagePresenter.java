package com.zjxu.hwl.ui.main.message;

import android.app.Activity;

import com.zjxu.hwl.base.BasePresenter;
import com.zjxu.hwl.entity.HolderDeviceEntity;
import com.zjxu.hwl.entity.LoginEntity;
import com.zjxu.hwl.entity.MessageEntity;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MessagePresenter extends BasePresenter<MessageView> {
    @Inject
    public MessagePresenter(){

    }
    @Inject
    HttpService httpService;
    @Inject
    Activity activity;
    public void getMessageList() {
        Observable<HttpResult<List<MessageEntity>>> observable = httpService.getAllMessage();
        toSubscribe(observable,
                new ProgressDialogSubscriber<HttpResult<List<MessageEntity>>>(activity) {
                    @Override
                    public void onNext(HttpResult<List<MessageEntity>> result) {

                            if (result.getStatus() == 200) {
                                getView().getData(result.getData());

                            } else {
                                getView().showToast(result.getMsg());
                            }
                    }

                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

}
