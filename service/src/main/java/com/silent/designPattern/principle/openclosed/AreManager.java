package com.silent.designPattern.principle.openclosed;

import java.util.List;

/**
 * \* User: silent
 * \* Date: 14/03/19 Time: 10:35
 * \* Description: 总面积管理类
 * \
 */
public class AreManager {

    public Integer allCountAre(List<Shape> shapes) {
        int are = 0;
        for (Shape shape : shapes) {
            are = are + shape.countArea();
        }
        return are;
    }
}
