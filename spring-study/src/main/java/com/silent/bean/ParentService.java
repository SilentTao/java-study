package com.silent.bean;

import org.springframework.stereotype.Component;

/**
 * Author liutao
 * Date 2020/5/12 9:54 上午
 * Description:
 * Version: 1.0
 **/
@Component("parent")
public class ParentService {

    public String soutName(){
        return "bbb";
    }

}
