package com.ssdt.banbury.mydagger2demo.dagger.data;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_15:07.
 * @description
 */

public class Clothes {
    private Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    @Override
    public String toString() {
        return cloth.getColor() + "衣服";
    }
}
