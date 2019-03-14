package com.silent.designPattern.principle.openclosed;

/**
 * \* User: silent
 * \* Date: 14/03/19 Time: 10:25
 * \* Description: 三角形
 * \
 */
public class Triangular implements Shape {
    private Integer height;
    private Integer base;

    public Triangular(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public Integer countArea() {
        return (base * height) / 2;
    }
}
