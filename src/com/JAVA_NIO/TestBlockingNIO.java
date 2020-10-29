package com.JAVA_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/7 23:51
 * # @version 1.0
 * # @File : TestBlockingNIO.java
 * # @Software: IntelliJ IDEA
 */

/*
 * 一、使用NIO 完成网络通信的三个核心：
 *
 * 1、通道(Channel):负责连接
 *      java.nio.channels.Channel 接口：
 *           |--SelectableChannel
 *               |--SocketChannel
 *               |--ServerSocketChannel
 *               |--DatagramChannel
 *
 *               |--Pipe.SinkChannel
 *               |--Pipe.SourceChannel
 *
 * 2.缓冲区(Buffer):负责数据的存取
 *
 * 3.选择器(Selector):是 SelectableChannel 的多路复用器。用于监控SelectableChannel的IO状况
 */
public class TestBlockingNIO {//没用Selector，阻塞型的

    public static void main(String[] args) throws IOException {
//        client();
//        server();

    }

    //客户端

    public static void client() throws IOException {
        SocketChannel sChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        ByteBuffer buf= ByteBuffer.allocate(1024);
        while(inChannel.read(buf)!=-1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.shutdownOutput();//关闭发送通道，表明发送完毕


        //接收服务端的反馈
        int len=0;
        while((len=sChannel.read(buf))!=-1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            sChannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        sChannel.close();
    }

    //服务端

    public static void server() throws IOException{
        //1. 获取通道
        ServerSocketChannel ssChannel=ServerSocketChannel.open();


        FileChannel outChannel=FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
//        2.绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        //        3.获取客户端连接通道
        SocketChannel sChannel=ssChannel.accept();

        ByteBuffer buf=ByteBuffer.allocate(1024);
//          4.接受客户端的数据，并且保存到本地
        while(sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //发送反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();//给为读模式
        sChannel.write(buf);
//关闭通道
        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}