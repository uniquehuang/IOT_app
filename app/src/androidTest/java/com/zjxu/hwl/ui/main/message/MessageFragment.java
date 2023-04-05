package com.zjxu.hwl.ui.main.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.base.BaseFragment;
import com.zjxu.hwl.entity.MessageEntity;

import java.util.List;

import javax.inject.Inject;

public class MessageFragment extends BaseFragment<MessageView,MessagePresenter>implements MessageView {

    @Inject
    MessagePresenter messagePresenter;
    @Override
    protected MessagePresenter createPresenter() {
        return messagePresenter;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_message,container,false);
        return view;
    }
    @Override
    protected void injectDependencies(){
        super.injectDependencies();
        /*((BaseActivity)getActivity()).getActivityComponent().inject(this);*/
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void getData(List<MessageEntity> data) {

    }
}
