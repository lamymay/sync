package com.arc.nio;

import java.nio.ByteBuffer;

/**
 * NIO服务端
 * 缓冲区buffer： 在NIO中负责数据的存取，缓冲区就是数组，用于存储不同类型的数据
 * 1
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 2
 * 上述缓冲区的管理方式几乎一致，通过allocate（）获取缓存区
 * 3
 * 缓冲区存取数据的两个核心方法
 * put()：存
 * get()：取
 * 4
 * 缓冲区的四核心属性
 * capacity：容量，一旦声明不可改变，表示缓存区中最大存储数据的容量
 * limit：界限，表示缓存区可以操作数据的大小（limit后数据不能进行读写）
 * position：位置，表示缓冲区正在操作数据的位置
 * position<=mark<= limit <= capacity
 *mark 标记，记录当前position位置，reset恢复到mark的位置
 *
 * @author may
 */
public class NIOServer {
    public static void main(String[] args) {

//        test1();
        test2();

    }

    private static void test2() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        //read
        byte[] dest = new byte[buffer.limit()];
        buffer.get(dest, 0, 2);
        System.out.println(new String(dest, 0, 2));
        System.out.println(buffer.position());


        System.out.println("------------- put --------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


    }

    private static void test1() {
        String str = "abcde";
        //1、分配…(给); 分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("------------- allocate --------------");
        System.out.println(byteBuffer.position());//位置
        System.out.println(byteBuffer.limit());//限制
        System.out.println(byteBuffer.capacity());//容量

        //2、put数据到缓冲区
        byteBuffer.put(str.getBytes());
        System.out.println("------------- put --------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        //3、fip()切换 写数据模式，读数据模式
        byteBuffer.flip();
        System.out.println("------------- flip --------------");
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //4、get() 读取缓存区数据
        System.out.println("------------- get --------------");
        System.out.println(byteBuffer.limit());
        System.out.println(3 == byteBuffer.limit());
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //5、可重复读取，复位
        byteBuffer.rewind();
        System.out.println("------------- rewind --------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //6、清空缓冲区，数据还在，只是出于被遗忘状态
        byteBuffer.clear();
        System.out.println("------------- clear --------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

    }
}
