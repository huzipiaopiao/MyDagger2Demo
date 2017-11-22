package com.ssdt.banbury.mydagger2demo.dagger.module;

import com.ssdt.banbury.mydagger2demo.ClothHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:07.
 * @description
 */
@Module
public class BaseModule {

    @Singleton
    @Provides //配合对应的component中，如果有方法返回某个对象，则module中需要有方法提供对象；
    public ClothHandler getClothHandler() {
        return new ClothHandler();
    }
}
