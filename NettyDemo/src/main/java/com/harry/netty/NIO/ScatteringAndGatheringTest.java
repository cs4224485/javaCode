package com.harry.netty.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering：将数据写入到 buffer 时，可以采用 buffer 数组，依次写入 [分散]
 * Gathering：从 buffer 读取数据时，可以采用 buffer 数组，依次读
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {
        // 使用ServerSocketChannel和SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(3000);

        // 绑定端口到socket 并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;

        // 循环读取
        while (true){
            int byteRead = 0;
            while (byteRead < messageLength){
                long l = socketChannel.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead = " + byteRead);
                //使用流打印,看看当前的这个 buffer 的 position 和 limit
                Arrays.stream(byteBuffers).map(buffer -> "position = " + buffer.position() + ", limit"+
                        buffer.limit()).forEach(System.out::println);
            }
            // 将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
            // 将数据读出显示客户端
            long byteWirte  = 0;
            while (byteWirte  < messageLength){
                long l = socketChannel.write(byteBuffers);
                byteWirte  += l;
            }
            // 将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
            System.out.println("byteRead = " + byteRead + ", byteWrite = " + byteWirte + ", messagelength = " + messageLength);
        }
    }
}
