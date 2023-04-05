package com.zjxu.hwl.ui.main.scene;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.base.BaseFragment;
import com.zjxu.hwl.http.HttpResult;
import com.zjxu.hwl.http.HttpService;
import com.zjxu.hwl.http.ProgressDialogSubscriber;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

public class SceneFragment extends BaseFragment<SceneView,ScenePresenter>implements SceneView {
    @Inject
    ScenePresenter scenePresenter;
    @Inject
    HttpService httpService;



    @BindView(R.id.tv_desc)
    ImageView imageView;
    @BindView(R.id.tv_desc2)
    ImageView imageView2;
    @Override
    protected ScenePresenter createPresenter() {
        return scenePresenter;
    }
    @Override
    protected void injectDependencies(){
        ((BaseActivity)getActivity()).getmActivityComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmenet_scene,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.tv_desc)
    void addScene(){
        Observable<HttpResult<String>> observable = httpService.addSence(1);
        toSubscribe(observable, new ProgressDialogSubscriber<HttpResult<String>>(getActivity()) {
            @Override
            public void onNext(HttpResult<String> result) {
                if (result.getStatus()==200){
                    Toast.makeText(getActivity(),"您有一条新消息,去消息模块看一下吧",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(),result.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.tv_desc2)
    void addScene2(){
        Observable<HttpResult<String>> observable = httpService.addSence(2);
        toSubscribe(observable, new ProgressDialogSubscriber<HttpResult<String>>(getActivity()) {
            @Override
            public void onNext(HttpResult<String> result) {
                if (result.getStatus()==200){
                    Toast.makeText(getActivity(),"您有一条新消息,去消息模块看一下吧",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(),result.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

}
