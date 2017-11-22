package com.ssdt.banbury.mydagger2demo.dagger.module;

import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;
import com.ssdt.banbury.mydagger2demo.dagger.scope.MyPerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:01.
 * @description
 */
@Module
public class OtherModule {

    @MyPerActivity
    @Provides
    public Cloth getBlueCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }
}
