package com.zjxu.hwl.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.zjxu.hwl.ui.main.equipment.EquipmentFragment;
import com.zjxu.hwl.ui.main.message.MessageFragment;
import com.zjxu.hwl.ui.main.mine.MineFragment;
import com.zjxu.hwl.ui.main.scene.SceneFragment;

public class MainFragmentPagerAdapter  extends FragmentPagerAdapter {
    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i){
            case 0:
                fragment=new MessageFragment();
                break;
            case 1:
            fragment=new EquipmentFragment();
            break;
            case 2:
                fragment=new SceneFragment();
                break;
            case 3:
                fragment=new MineFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
