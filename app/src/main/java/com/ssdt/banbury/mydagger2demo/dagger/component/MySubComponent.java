package com.ssdt.banbury.mydagger2demo.dagger.component;

import com.ssdt.banbury.mydagger2demo.dagger.module.MySubModule;
import com.ssdt.banbury.mydagger2demo.dagger.scope.MyPerActivity;
import com.ssdt.banbury.mydagger2demo.view.MySubActivity;

import dagger.Subcomponent;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/22_11:37.
 * @description
 *
 *
 * 这里总结一下@Subcomponent的使用:
 * 子组件的声明方式由@Component改为@Subcomponent
 * 在父组件中要声明一个返回值为子组件的方法,当子组件需要什么Module时,就在该方法中添加该类型的参数
 */
@MyPerActivity
@Subcomponent(modules = MySubModule.class)
public interface MySubComponent {

    void inject(MySubActivity subActivity);
}
