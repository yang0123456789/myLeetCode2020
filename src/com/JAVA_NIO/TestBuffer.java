package com.JAVA_NIO;

import sun.applet.Main;

import java.nio.ByteBuffer;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/7 17:21
 * # @version 1.0
 * # @File : TestBuffer.java
 * # @Software: IntelliJ IDEA
 */
/*
 * 一、缓冲区（Buffer）：在java NIO 中负者数据的存储。缓冲区就是数组。用于存储不同类型的数据。
 *
 * 根据数据类型的不同(boolean 除外)，有以下 Buffer 常用子类：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put():存入数据到缓冲区中
 *       put(byte b)：将给定单个字节写入缓冲区的当前位置
 *       put(byte[] src)：将 src 中的字节写入缓冲区的当前位置
 *       put(int index, byte b)：将指定字节写入缓冲区的索引位置(不会移动 position)
 * get():获取缓存区中的数据
 *       get() ：读取单个字节
 *       get(byte[] dst)：批量读取多个字节到 dst 中
 *       get(int index)：读取指定索引位置的字节(不会移动 position)
 *
 * 三、缓冲区中的四个核心属性：
 * capacity：容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit：界限，表示缓冲区中可以操作数据的大小。(limit后数据不能进行读写)
 * position：位置，表示缓冲区中正在操作数据的位置。
 * mark:标记，表示记录当前position位置。可以通过reset()恢复到mark的位置。
 *
 * 0<=mark<=position<=limit<=capacity
 *
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中。
 *
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 *          此方法返回的 缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区 。
 *          直接缓冲区的内容可以驻留在常规的垃圾回收堆之外.
 *          将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。
 *          最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
 *          直接字节缓冲区还可以过 通过FileChannel 的 map() 方法 将文件区域直接映射到内存中来创建 。该方法返回MappedByteBuffe
 */
public class TestBuffer {
    public static void main(String[] args) {

    }
    public void test1() {
        String str = "abcde";

        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("--------------allocate()----------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        //2.利用put()存放数据到缓冲区中
        buf.put(str.getBytes());

        System.out.println("-------------put()-------------");
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        //3.切换读取数据模式
        buf.flip();
        System.out.println("--------------flip()------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //4.利用get()读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));//abcd

        System.out.println("--------------get()------------");
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //5.rewind():可重复读
        buf.rewind();

        System.out.println("--------------rewind()------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //6.clear():清空缓冲区。但是缓冲区中的数据依然存在，但是处在“被遗忘”状态
        buf.clear();

        System.out.println("--------------clear()------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        System.out.println((char) buf.get());//a 缓冲区依然有数据
    }

    public void test2() {
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));//ab
        System.out.println(buf.position());//2

        //mark():标记
        buf.mark();

        buf.get(dst, 2, 2);//再读两个位置
        System.out.println(new String(dst, 2, 2));//cd
        System.out.println(buf.position());//4

        //reset():恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());//2

        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());//3
        }
    }


    public void test3() {
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buf.isDirect());//false
    }
}
