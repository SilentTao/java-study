package com.silent.jvm.reflection;

public class Refelct {
    private String name;
    public void sayHi(String helloScentence){
        System.out.println("hi "+helloScentence+name );
    }

  private String thowHello(String tag){
        return "hello"+tag;
  }
}
