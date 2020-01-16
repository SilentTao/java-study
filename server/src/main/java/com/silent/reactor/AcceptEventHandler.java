package com.silent.reactor;

/**
 * Author liutao
 * Date 2019/11/29 9:18 上午
 * Description:
 * Version: 1.0
 **/
public class AcceptEventHandler extends EventHandler {
    private Selector selector;

    public AcceptEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理Accept的event事件
        if (event.getType() == EventType.ACCEPT) {

            //TODO 处理ACCEPT状态的事件

            //将事件状态改为下一个READ状态，并放入selector的缓冲队列中
            Event readEvent = new Event();
            readEvent.setSource(event.getSource());
            readEvent.setType(EventType.READ);

            selector.addEvent(readEvent);
        }
    }
}
