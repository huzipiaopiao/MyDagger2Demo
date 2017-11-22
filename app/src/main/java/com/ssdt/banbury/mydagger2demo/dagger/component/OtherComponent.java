package com.ssdt.banbury.mydagger2demo.dagger.component;

import com.ssdt.banbury.mydagger2demo.dagger.module.OtherModule;
import com.ssdt.banbury.mydagger2demo.dagger.scope.MyPerActivity;
import com.ssdt.banbury.mydagger2demo.view.OtherActivity;

import dagger.Component;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:02.
 * @description
 */
@MyPerActivity
@Component(modules = OtherModule.class,dependencies = BaseComponent.class)//dependencies对应的值，表示依赖一个基类Component接口（此基类Component接口中一般会有返回对象的方法，表示它可以提供一个对象，而它对应的module中会提供方法返回对象，见BaseModule），一般用法是，不同的目标类中需要一个全局的单例对象；
public interface OtherComponent {

    void inject(OtherActivity otherActivity);
}
