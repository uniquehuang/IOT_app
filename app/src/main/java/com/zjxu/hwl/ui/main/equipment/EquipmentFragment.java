package com.zjxu.hwl.ui.main.equipment;//黄万霖

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.base.BaseFragment;
import com.zjxu.hwl.entity.HolderDeviceEntity;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;
public class EquipmentFragment extends BaseFragment<EquipmentView,EquipmentPresenter> implements EquipmentView,DeviceAdapter.OnItemClickListener {

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    @BindView(R.id.tv_nodata)
    TextView tv_nodata;

    @Inject
    EquipmentPresenter equipmentPresenter;
    private DeviceAdapter adapter;

    @Override
    protected void injectDependencies() {
        super.injectDependencies();
        ((BaseActivity)getActivity()).getmActivityComponent().inject(this);
    }
    @Override
    protected EquipmentPresenter createPresenter() {
        return equipmentPresenter;
    }
    @OnClick(R.id.iv_add_device)
    void addDevice(){
        //TODO：添加设备
        showToast("添加设备");
    }

    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_equipment,container,false);
        ButterKnife.bind(this,view);
        initViews();
        return view;
    }
    private void initViews() {
        tv_nodata.setVisibility(View.VISIBLE);
        tv_nodata.setText("暂无设备哦~，马上去绑定吧");

        //设置刷新进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_dark,
                android.R.color.holo_orange_dark
        );
        //设置下拉刷新事件
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //网络请求
                equipmentPresenter.getDeviceList();
            }
        });
        //设置布局管理器为 LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置适配器
        adapter = new DeviceAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        //设置点击事件
        adapter.setOnItemClickListener(this);
    }

    private void onCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        equipmentPresenter.getDeviceList();
    }




    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void refreshData(List<HolderDeviceEntity> data){
        if (data == null || data.size() ==0){
            tv_nodata.setVisibility(View.VISIBLE);
        }else {
            tv_nodata.setVisibility(View.GONE);
        }

        adapter.resetDataAndNotifyDataSetChanged(data);
    }
    @Override
    public void stopRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onPermissionGranted() {

    }

    @Override
    public void onItemClick(int position, HolderDeviceEntity item) {
        showToast("onItemClick :"+position);
    }

}
