package com.silent.jvm.classinit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * \* User: silent
 * \* Date: 02/04/19 Time: 10:39
 * \* Description:
 * \
 */
public class CachingEnumResolver {
    //单态实例　一切问题皆由此行引起
    private  static CachingEnumResolver SINGLE_ENUM_RESOLVER = new CachingEnumResolver();
    /*MSGCODE->Category内存索引*/
    private static Map CODE_MAP_CACHE;
    private static String aaa = "asdfds";
    private static  boolean aBoolean=false;
    private static  int anInt=1;
    private static  long aLong =10000L;
    private static  short aShort=12;

    static {

      /*  System.out.println("我是static静态块");
        System.out.println(CODE_MAP_CACHE);
        System.out.println("aaa: " + aaa);*/
        CODE_MAP_CACHE = new HashMap();
        //为了说明问题,我在这里初始化一条数据
        CODE_MAP_CACHE.put("0", "北京市");

    }

    //private, for single instance
    private CachingEnumResolver() {
     //   System.out.println("我是构造方法");
        //初始化加载数据  引起问题，该方法也要负点责任
        initEnums();
    }

    /**
     * 初始化所有的枚举类型
     */
    public static void initEnums() {
        // ~~~~~~~~~问题从这里开始暴露 ~~~~~~~~~~~//
        if (null == CODE_MAP_CACHE) {
          System.out.println("CODE_MAP_CACHE为空,问题在这里开始暴露.");
            CODE_MAP_CACHE = new HashMap();
        }
        CODE_MAP_CACHE.put("1", "北京市");
        CODE_MAP_CACHE.put("2", "云南省");

        //..... other code...
    }

    /**
     * 获取单态实例
     *
     * @return
     */
    public static CachingEnumResolver getInstance() {
        return SINGLE_ENUM_RESOLVER;
    }

    public static void main(String[] args) {
        System.out.println(CachingEnumResolver.getInstance().getCache());
    }

    public Map getCache() {
        return Collections.unmodifiableMap(CODE_MAP_CACHE);
    }
}
