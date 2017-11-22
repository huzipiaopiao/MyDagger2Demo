package com.ssdt.banbury.mydagger2demo.dagger.data;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_14:26.
 * @description
 */

public class Cloth {
    private String color;

    @Override
    public String toString() {
        return color + "布料";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
