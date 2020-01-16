package com.silent.reactor;

/**
 * Author liutao
 * Date 2019/11/29 9:16 上午
 * Description:
 * Version: 1.0
 **/
public class InputSource {

    private Object data;  // 具体数据
    private long id;

    public InputSource(Object data, long id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        return "InputSource{" +
                "data=" + data +
                ", id=" + id +
                '}';
    }
}
