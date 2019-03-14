package com.silent.base;

/**
 * \* User: silent
 * \* Date: 13/03/19 Time: 15:32
 * \* Description:
 * \
 */
public class ShiftOperation {

    public static void main(String[] args) {
        int number = 10;
        System.out.println(Integer.toBinaryString(number));
        number = number << 1;
        System.out.println(Integer.toBinaryString(number));
    }

}
