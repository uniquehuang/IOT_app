package com.zjxu.hwl.ui.main.message;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.base.BaseFragment;
import com.zjxu.hwl.entity.MessageEntity;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

public class MessageFragment extends BaseFragment<MessageView,MessagePresenter> implements MessageView,MessageAdapter.OnItemClickListener {

    @Inject
    HttpService httpService;
    @BindView(R.id.iv_add_device)
    ImageView imageView;
    @Inject
    MessagePresenter messagePresenter;
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    private MessageAdapter adapter;
    @Override
    protected MessagePresenter createPresenter() {
        return messagePresenter;
    }
    private PopupMenu popupMenu;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_message,container,false);
        ButterKnife.bind(this,view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置适配器
        adapter = new MessageAdapter(getActivity());

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        return view;
    }
    @Override
    protected void injectDependencies(){
        super.injectDependencies();
        ((BaseActivity)getActivity()).getmActivityComponent().inject(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getData(List<MessageEntity> data) {
        adapter.resetDataAndNotifyDataSetChanged(data);
    }


    @Override
    public void onItemClick(int position, MessageEntity item) {
        showToast(item.getDes());
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        messagePresenter.getMessageList();
        popupMenu =new PopupMenu(getActivity(),imageView);
        getActivity().getMenuInflater().inflate(R.menu.menu_message,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.clear:
                    Observable<HttpResult<String>> observable = httpService.deleteAllMessage();
                    toSubscribe(observable, new ProgressDialogSubscriber<HttpResult<String>>(getActivity()) {
                        @Override
                        public void onNext(HttpResult<String> result) {
                            if (result.getStatus()==200){
                                Toast.makeText(getActivity(),result.getMsg(),Toast.LENGTH_SHORT).show();
                                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                //设置适配器
                                adapter = new MessageAdapter(getActivity());
                                recyclerView.setAdapter(adapter);

                            }else {
                                Toast.makeText(getActivity(),result.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
            }
            return true;
        });
    }
    @OnClick(R.id.iv_add_device)
    void pop(){
        popupMenu.show();
    }

}
