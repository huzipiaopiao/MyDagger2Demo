package com.ssdt.banbury.mydagger2demo.dagger.scope;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_17:35.
 * @description
 *
 * 单例是在同一个Component实例提供依赖的前提下才有效的,不同的Component实例只能通过Component依赖才能实现单例.
 * 也就是说,你虽然在两个Component接口上都添加了MyPerActivity注解,但是这两个Component提供依赖时是没有联系的,他们只能在各自的范围内实现单例
 *
 * Dagger2既然有了Singleton为什么还要我们自定义PerActivity注解?这就涉及到代码可读性了,
 * 当依赖需求方是Activity时,我们可以自定义一个PerActivity注解,当依赖需求方是Fragment时,我们又可以自定义一个PerFragment注解,这样我们就能清楚的区分依赖对象的提供目标了
 *
 * 那我们通过构造函数提供依赖的方式又要怎么声明作用范围呢?答案就是在类名上使用注解标明,切记不要在构造函数上用注解标明,这样是无效的.
 */
@Scope //添加注解@Scope后，自定义的注解可以提供一个作用域，具体效果和@Singleton相同，自定义主要是为了代码的可阅读性；通过在Component类上和对应Module提供对象的方法上添加自定义的这个注解，就可以实现提供的对象是同一个对象（单例）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyPerActivity {
}
