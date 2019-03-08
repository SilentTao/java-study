package com.silent.gc;


/**
 * \* User: silent
 * \* Date: 07/03/19 Time: 10:11
 * \* Description:
 * \
 */
public class Student  {

    private String name="silent";
    private String code="007";

    static {
        System.out.println("我被初始化了");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我被gc了");
    }
}
