package com.silent.reactor;

/**
 * Author liutao
 * Date 2019/11/29 9:17 上午
 * Description:
 * Version: 1.0
 **/
public class Event {

    private InputSource source;
    private EventType type;

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
