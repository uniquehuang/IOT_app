package com.zjxu.hwl.ui.main.login;

import com.zjxu.hwl.base.BaseView;

public interface LoginView extends BaseView {
    void showToast(String msg); //显示登录信息
    void loginSucceed();        //登录成功后的处理，如跳转主界面

}
