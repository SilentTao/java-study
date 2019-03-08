package com.silent.jvm.reflection;

/**
 * \* User: silent
 * \* Date: 06/03/19 Time: 11:55
 * \* Description:
 * \
 */
public class MyReflect {

    private String name;

    private void sayHi(String userName) {

        System.out.println("Hi " + userName);
    }

    public String sayBye(String userName) {
        System.out.println("Bye " + userName);
        return "BYE";
    }
}
