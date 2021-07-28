package com.silent.socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author liutao
 * Date 2019/11/28 8:56 上午
 * Description:
 * Version: 1.0
 **/
public class Client {


    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 8080);
        try {
            PrintWriter output =
                    new PrintWriter(client.getOutputStream(), true);
            Scanner cin = new Scanner(System.in);
            String words;

            while (cin.hasNext()) {
                words = cin.nextLine();

                output.println(words);

                System.out.println("aaa" + words);
            }

            cin.close();
        } finally {
            client.close();
        }
    }
}
