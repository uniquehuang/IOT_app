package com.zjxu.hwl.ui.main.message;

import com.zjxu.hwl.base.BaseView;
import com.zjxu.hwl.entity.HolderDeviceEntity;
import com.zjxu.hwl.entity.MessageEntity;

import java.util.List;

public interface MessageView extends BaseView {
    void showToast(String msg); //提示结果
    void getData(List<MessageEntity> data);  //刷新列表
}
