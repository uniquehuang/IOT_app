package com.zjxu.hwl.ui.main.equipment;

import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.entity.HolderDeviceEntity;

import java.util.List;

import javax.inject.Inject;

public class EquipmentFragment extends BaseActivity<EquipmentView,EquipmentPresenter>implements EquipmentView {
    @Inject
    EquipmentPresenter equipmentPresenter;
    @Override
    protected void injectDependencies() {

    }

    @Override
    protected EquipmentPresenter createPresenter() {
        return equipmentPresenter;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void refreshData(List<HolderDeviceEntity> data) {

    }

    @Override
    public void stopRefresh() {

    }

    @Override
    public void onPermissionGranted() {

    }
}
