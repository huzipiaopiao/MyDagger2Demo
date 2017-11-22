package com.ssdt.banbury.mydagger2demo.dagger.qulifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_16:49.
 * @description
 */
@Qualifier //通过这个注解，让自定义的注解@MyRedClothes有限定作用，自定义的这个注解@MyRedClothes效果和dagger中的@Named一样
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRedClothes {
}
