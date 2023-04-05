package com.zjxu.hwl.ui.main.mine;

import com.zjxu.hwl.base.BaseView;

public interface MineView extends BaseView {
    void showUserHead(String imgUrl);

    void showUserName(String username);

    void showUserEmail(String email);

    void showToast(String msg);

    void logoutSucceed();
}