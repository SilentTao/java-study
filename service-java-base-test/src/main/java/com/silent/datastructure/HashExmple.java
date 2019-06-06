package com.silent.datastructure;

/**
 * \* User: silent
 * \* Date: 05/06/19 Time: 11:33
 * \* Description:
 * \
 */
public class HashExmple {


    static final int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    public static void main(String[] args) {
        int size=3;
        int hasch=hash("asdf");
        int hasch1=hash("asdfasdf");
        int index =2 & hasch;
        int index2=2&hasch1;
        System.out.println(index);
        System.out.println(index2);
        System.out.println(8&2);
        System.out.println(8&3);
        System.out.println(8&8);
    }
}
