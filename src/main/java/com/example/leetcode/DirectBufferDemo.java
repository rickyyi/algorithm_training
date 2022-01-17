package com.example.leetcode;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectBufferDemo {
    public static void main(String[] args) throws Exception {
        FileChannel filechannel=new RandomAccessFile("/Users/jlgl/456.txt","rw").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2*1024*1024);
        filechannel.read(byteBuffer);
        System.out.println();

    }
}
