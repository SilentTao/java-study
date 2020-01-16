package com.silent.reactor;

/**
 * Author liutao
 * Date 2019/11/29 9:21 上午
 * Description:
 * Version: 1.0
 **/
public class Server {

    Selector selector = new Selector();
    Dispatcher eventLooper = new Dispatcher(selector);
    Acceptor acceptor;

    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

    public static void main(String[] args) {
        new Server(8080).start();
    }
}
