package com.zjxu.hwl.ui.main.equipment;

import com.zjxu.hwl.base.BaseView;
import com.zjxu.hwl.entity.HolderDeviceEntity;

import java.util.List;

public interface EquipmentView extends BaseView {
    void showToast(String msg); //提示结果
    void refreshData(List<HolderDeviceEntity> data);  //刷新列表
    void stopRefresh();   //停止刷新
    void onPermissionGranted();   //系统权限动态申请结果的回调
}
