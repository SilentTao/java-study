package com.silent.designPattern.principle.openclosed;

/**
 * \* User: silent
 * \* Date: 14/03/19 Time: 14:18
 * \* Description: 正方形
 * \
 */
public class Square implements Shape {
    private Integer length;
    private Integer high;

    public Square(Integer length, Integer high) {
        this.length = length;
        this.high = high;
    }

    @Override
    public Integer countArea() {
        return high * length;
    }
}
