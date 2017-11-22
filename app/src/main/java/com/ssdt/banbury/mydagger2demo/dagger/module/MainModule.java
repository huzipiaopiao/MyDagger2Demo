package com.ssdt.banbury.mydagger2demo.dagger.module;

import android.widget.Toast;

import com.ssdt.banbury.mydagger2demo.MyApplication;
import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;
import com.ssdt.banbury.mydagger2demo.dagger.data.Clothes;
import com.ssdt.banbury.mydagger2demo.dagger.qulifier.MyRedClothes;
import com.ssdt.banbury.mydagger2demo.dagger.scope.MyPerActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_14:29.
 * @description
 *
 * 步骤1：查找Module中是否存在创建该类的方法。
 * 步骤2：若存在创建类方法，查看该方法是否存在参数
 * 步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数
 * 步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 * 步骤3：若不存在创建类方法，则查找Inject注解的构造函数，看构造函数是否存在参数
 * 步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数
 * 步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 * 也就说Dagger2会递归的提供依赖.
 */

@Module//表示这是一个提供对象的类；
public class MainModule {

    @Singleton//会有误解的一个注解，这个注解其实是继承dagger中的注解@Scope，所以效果可以见@Scope的介绍，表示的是一个作用域，在同一个作用域内，调用这个方法返回的值都是同一个对象，也就是说同一个作用域里，返回的都是单例，注意的点是，对应的Component类上也要加上这个注解，否则编译时会报错
    @Provides//表示这个方法是提供对象的方法
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("普通色");
        return cloth;
    }

    @MyPerActivity//这是个自定义的注解，继承@Scope注解，效果类似@Singleton
    @Named("normal2Cloth")//此module中有其他方法也返回同一类型对象，则这个注解用来区分，根据括号中的值来判断，目标类中如果要用这个方法生成的对象时，声明对象是也要加上一模一样的注解，此注解实际上是继承的@Qulifier这个注解
    @Provides//表示这个方法是提供对象的方法
    public Cloth getNormalCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("普通色2");
        return cloth;
    }

    @Provides//表示这个方法是提供对象的方法
    @Named("red")//此module中有其他方法也返回同一类型对象，则这个注解用来区分，根据括号中的值来判断，目标类中如果要用这个方法生成的对象时，声明对象是也要加上一模一样的注解，此注解实际上是继承的@Qulifier这个注解
    public Cloth getRedCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    @Provides//表示这个方法是提供对象的方法
    @Named("blue")//此module中有其他方法也返回同一类型对象，则这个注解用来区分，根据括号中的值来判断，目标类中如果要用这个方法生成的对象时，声明对象是也要加上一模一样的注解，此注解实际上是继承的@Qulifier这个注解
    public Cloth getBlueCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }

    @Provides//表示这个方法是提供对象的方法
    @Named("lazy")
    public Cloth getLazyCloth() {
        Toast.makeText(MyApplication.mContext, "Lazy色cloth被创建了", Toast.LENGTH_SHORT).show();
        Cloth cloth = new Cloth();
        cloth.setColor("Lazy色");
        return cloth;
    }

    @Provides//表示这个方法是提供对象的方法
    public Clothes getClothes(Cloth cloth) {
        return new Clothes(cloth);
    }

    @Provides//表示这个方法是提供对象的方法
    @Named("other")
    @MyPerActivity
    public Clothes getOtherClothes(Cloth cloth) {
        return new Clothes(cloth);
    }

    @Provides//表示这个方法是提供对象的方法
    @MyRedClothes//自定义的这个注解@MyRedClothes效果和dagger中的@Named一样
    public Clothes getRedClothes(@Named("red") Cloth cloth) {//参数中同样也可以用@Named
        return new Clothes(cloth);
    }

    @Provides//表示这个方法是提供对象的方法
    @Named("normal2Clothes")//此module中有其他方法也返回同一类型对象，则这个注解用来区分，根据括号中的值来判断，目标类中如果要用这个方法生成的对象时，声明对象是也要加上一模一样的注解，此注解实际上是继承的@Qulifier这个注解
    public Clothes getNormal2Clothes(@Named("normal2Cloth") Cloth cloth) {//参数中同样也可以用@Named
        return new Clothes(cloth);
    }
}
