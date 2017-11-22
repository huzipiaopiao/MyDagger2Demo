package com.ssdt.banbury.mydagger2demo.dagger.data;

import javax.inject.Inject;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_15:14.
 * @description
 */

public class Hat {
    private Cloth cloth;

    @Inject//表示通过这个方法可以得到这个对象
    public Hat(Cloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return cloth.getColor() + "帽子";
    }
}
