package com.ssdt.banbury.mydagger2demo.dagger.component;

import com.ssdt.banbury.mydagger2demo.dagger.module.MainModule;
import com.ssdt.banbury.mydagger2demo.dagger.scope.MyPerActivity;
import com.ssdt.banbury.mydagger2demo.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_14:34.
 * @description
 */
@MyPerActivity//这是个自定义的注解，继承@Scope注解，效果类似@Singleton（和@Singleton二选一就好了）
@Singleton//会有误解的一个注解，这个注解其实是继承dagger中的注解@Scope，所以效果可以见@Scope的介绍，表示的是一个作用域，在同一个作用域内，调用这个方法返回的值都是同一个对象，也就是说同一个作用域里，返回的都是单例。在对应的modules中，提供对象的方法上加上这个注解时，返回的对象都是同一个对象(单例)
@Component(modules = MainModule.class)//表示中间者，modules中表示的是对象的提供者；下面的inject方法中的参数表示需要注入对象的类（简称目标类）；通过这个接口就把目标类和要生成的对象联系起来了
public interface MainComponent {

    //参数表示需要注入对象的类（简称目标类），此方法会在目标类中手动调用
    void inject(MainActivity mainActivity);
}
