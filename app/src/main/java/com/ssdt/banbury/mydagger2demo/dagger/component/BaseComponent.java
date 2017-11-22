package com.ssdt.banbury.mydagger2demo.dagger.component;

import com.ssdt.banbury.mydagger2demo.ClothHandler;
import com.ssdt.banbury.mydagger2demo.dagger.module.BaseModule;
import com.ssdt.banbury.mydagger2demo.dagger.module.MySubModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:07.
 * @description
 * 为什么没有inject方法呢,因为我们通过inject方法依赖需求方实例送到Component中,从而帮助依赖需求方实现依赖,
 * 但是我们这个BaseComponent是给其他Component提供依赖的,所以我们就可以不用inject方法
 * 但是多了一个getClothHandler方法,它的返回值是ClothHandler对象,这个方法有什么用呢?
 * 它的作用就是告诉依赖于BaseComponent的Component,BaseComponent能为你们提供ClothHandler对象,如果没有这个方法,BaseComponent就不能提供ClothHandler对象
 */
@Singleton//特别注意这里，是为了确保单例
@Component(modules = BaseModule.class)
public interface BaseComponent {

    //告诉依赖于BaseComponent的Component,BaseComponent能为你们提供ClothHandler对象，配合@dependencies
    ClothHandler getClothhandler();


    //@Subcomponent使用的声明方式,声明一个返回值为子组件的方法,子组件需要什么Module,就在方法参数中添加什么
    MySubComponent getSubComponent(MySubModule mySubModule);
}
