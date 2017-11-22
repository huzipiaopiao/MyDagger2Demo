package com.ssdt.banbury.mydagger2demo.dagger.data;

import javax.inject.Inject;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_15:05.
 * @description
 */

public class Shoe {

    @Inject//表示通过这个方法可以得到这个对象
    public Shoe() {
    }

    @Override
    public String toString() {
        return "鞋子";
    }
}
