package com.silent.reactor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author liutao
 * Date 2020/6/17 10:19 上午
 * Description:
 * Version: 1.0
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",62093);
        //写操作
        Scanner scanner=null;
        OutputStream os= null;
        try {
            scanner=new Scanner(System.in);
            os= socket.getOutputStream();
            String in="";
            do {
                in=scanner.next();
                os.write((""+in).getBytes());
                os.flush();
            } while (!in.equals("bye"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
