package com.zjxu.hwl.ui.main;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.zjxu.hwl.R;
import com.zjxu.hwl.base.BaseActivity;
import com.zjxu.hwl.view.NoSlideViewPager;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainView,MainPresenter> implements MainView {
    @Inject
    MainPresenter mainPresenter;
    private NoSlideViewPager viewPager;
    private RadioGroup main_radio_group;
    private RadioButton main_radio_message;
    private RadioButton main_radio_equipment;
    private RadioButton main_radio_scene;
    private RadioButton main_radio_mine;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_vp_select);
        main_radio_group = findViewById(R.id.main_radio_group);
        main_radio_message = findViewById(R.id.main_radio_message);
        main_radio_equipment = findViewById(R.id.main_radio_equipment);
        main_radio_scene = findViewById(R.id.main_radio_scene);
        main_radio_mine = findViewById(R.id.main_radio_mine);
        MainFragmentPagerAdapter pagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setSlidable(false);
        main_radio_message.setChecked(true);
        main_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_radio_message:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.main_radio_equipment:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.main_radio_scene:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.main_radio_mine:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    @Override
    protected void injectDependencies() {
        getmActivityComponent().inject(this);
    }

    @Override
    protected MainPresenter createPresenter() {
        return mainPresenter;
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}