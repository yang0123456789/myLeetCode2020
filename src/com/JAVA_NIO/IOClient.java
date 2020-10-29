package com.JAVA_NIO;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/3 12:22
 * # @version 1.0
 * # @File : IOClient.java
 * # @Software: IntelliJ IDEA
 */

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author 闪电侠
 * @date 2018年10月14日
 * @Description:客户端
 */
public class IOClient {

    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

    }

}
