package com.zjxu.hwl.ui.main.mine; //黄万霖

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.base.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment<MineView,MinePresenter>implements MineView {
    @Inject
    MinePresenter minePresenter;

    @BindView(R.id.head_image)
    ImageView head_image;
    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.tv_user_email)
    TextView tv_user_email;

    protected MinePresenter createPresenter(){
        return minePresenter;
    }

    @OnClick(R.id.head_image)
    void headClick(){
        minePresenter.changeHead();
    }
    @OnClick(R.id.ll_change_password)
    void changePassword(){
        showToast("changePassword");
    }
    @OnClick(R.id.ll_change_email)
    void changeEmail(){showToast("changeEmail");}
    @OnClick(R.id.ll_feedback)
    void feedback(){showToast("feedback");}
    @OnClick(R.id.ll_aboutus)
    void aboutUs(){showToast("aboutUs");}
    @OnClick(R.id.bt_logout)
    void logout(){minePresenter.logout();}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        minePresenter.getUserInfo();
    }

    @Override
    protected void injectDependencies(){
        super.injectDependencies();
        ((BaseActivity)getActivity()).getmActivityComponent().inject(this);
    }

    private Unbinder unbinder;

    @Override
    public View initView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
    // 加载头像
    @Override
    public void showUserHead(String imgUrl) {
        Glide.with(getActivity())
                .load(imgUrl)//支持的格式
//                .asGif()//加载动态图片，如果不是gif图片,则加载error图片；
//                .skipMemoryCache(true) //内存缓存，默认为false
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//磁盘缓存
//                .error(R.drawable.image_error)//异常时图片占位
                .into(head_image);//指定加载的对象
        //清除缓存
//        Glide.get(this.getActivity()).clearDiskCache();
//        Glide.get(this.getActivity()).clearMemory();
    }

    @Override
    public void showUserName(String username){
        tv_user_name.setText(username);
    }
    @Override
    public void showUserEmail(String email){
        tv_user_email.setText(email);
    }
    @Override
    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logoutSucceed(){
        getActivity().finish();
    }
//    @Override
//    public Fragment getFragment(){
//        return this;
//    }
//    @Override
//    public void onActivityResult(int requestCode,int resultCode,Inject data){
//        super.onActivityResult(requestCode,resultCode,data);
//        minePresenter.onActivityResult(requestCode,resultCode,data);
//    }

}
