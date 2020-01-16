package com.silent.reactor;

/**
 * Author liutao
 * Date 2019/11/29 9:17 上午
 * Description:
 * Version: 1.0
 **/
public abstract class EventHandler {
    private InputSource source;

    public abstract void handle(Event event);

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }
}
