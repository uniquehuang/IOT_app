package com.zjxu.hwl.ui.main.register;

import android.app.Activity;
import android.text.TextUtils;


import com.zjxu.hwl.base.BasePresenter;
import com.zjxu.hwl.entity.RegisterEntity;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;

import javax.inject.Inject;

import rx.Observable;

public class RegisterPresenter extends BasePresenter<RegisterView> {

    @Inject
    HttpService service;
    @Inject
    Activity activity;
    @Inject     //标记在被依赖类的构造方法上，Dagger2 通过这个Inject 标记，
    public RegisterPresenter(){};//可以在需要这个类实例的时候，找到这个构造函数并把相关实例new出来，从而提供依赖。
    public void register(String username,String email,String password){
        if (TextUtils.isEmpty(username)){
            getView().showToast("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(email)){
            getView().showToast("请输入邮箱");
            return;
        }
//        if (isEmail(email)){
//            getView().showToast("邮箱格式不正确");
//            return;
//        }
        if (TextUtils.isEmpty(password)){
            getView().showToast("请输入密码");
            return;
        }
        Observable<HttpResult<RegisterEntity>> observable = service.register(username,email,password,"1");
        toSubscribe(observable,new ProgressDialogSubscriber<HttpResult<RegisterEntity>>(activity){
            @Override
            public void onNext(HttpResult<RegisterEntity> result){
                if (result != null){
                    if (result.getStatus() == 1){
                        getView().registerSucceed();
                        getView().showToast(result.getMsg());
                    }else {
                        getView().showToast(result.getMsg());
                    }
                }else {
                    getView().showToast("注册失败result == null");
                }
            }
        });
    }

    /**
     * 判断email格式是否正确
     *
     * @param email 邮箱
     */
//    public boolean isEmail(String email){
//        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
//        Pattern p = Pattern.compile(str);
//        Matcher m = p.matcher(email);
//        return m.matches();
//    }
}
