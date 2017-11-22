package com.ssdt.banbury.mydagger2demo;

import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;
import com.ssdt.banbury.mydagger2demo.dagger.data.Clothes;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:04.
 * @description
 */

public class ClothHandler {

    public Clothes handle(Cloth cloth) {
        return new Clothes(cloth);
    }
}
