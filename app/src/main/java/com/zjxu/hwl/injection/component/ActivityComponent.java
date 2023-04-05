package com.zjxu.hwl.injection.component;


import com.zjxu.hwl.injection.PerActivity;
import com.zjxu.hwl.injection.module.ActivityModule;
import com.zjxu.hwl.ui.main.MainActivity;
import com.zjxu.hwl.ui.main.equipment.EquipmentFragment;
import com.zjxu.hwl.ui.main.login.LoginAcivity;
import com.zjxu.hwl.ui.main.message.MessageFragment;
import com.zjxu.hwl.ui.main.mine.MineFragment;
import com.zjxu.hwl.ui.main.register.RegisterActivity;
import com.zjxu.hwl.ui.main.scene.SceneFragment;


import javax.inject.Inject;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(MessageFragment messageFragment);

    void inject(EquipmentFragment equipmentFragment);

    void inject(MineFragment mineFragment);

    void inject(SceneFragment sceneFragment);

    void inject(LoginAcivity loginActivity);

    void inject(RegisterActivity registerActivity);


}























