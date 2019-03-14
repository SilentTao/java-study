package com.silent.designPattern.principle.openclosed;

import java.util.ArrayList;
import java.util.List;

/**
 * \* User: silent
 * \* Date: 14/03/19 Time: 10:37
 * \* Description:
 * \
 */
public class OpenCloseDemo {

    public static void main(String[] args) {
        Circular circular = new Circular(3);
        Triangular triangular = new Triangular(2, 2);
        Square square = new Square(2, 3);
        AreManager areManager = new AreManager();

        List<Shape> shapes = new ArrayList<>(2);
        shapes.add(circular);
        shapes.add(triangular);
        shapes.add(square);
        int allAre = areManager.allCountAre(shapes);
        System.out.println("区域总面积为: " + allAre);
    }
}
