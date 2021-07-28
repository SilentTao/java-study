package com.silent.designPattern.principle.openclosed;

/**
 * \* User: silent
 * \* Date: 14/03/19 Time: 10:30
 * \* Description:圆的面积
 * \
 */
public class Circular implements Shape{
    public Integer r;

    public Circular(int r) {
        this.r = r;
    }

    public Integer countArea() {
        return (int) (Math.PI * r * r);
    }

}
