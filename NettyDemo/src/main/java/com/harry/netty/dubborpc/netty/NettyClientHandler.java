package com.harry.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    // 上下文
    private ChannelHandlerContext context;
    // 放回结果
    private String result;
    // 客户端调用方法时 传入的参数
    private String params;

    //与服务器的连接创建后，就会被调用, 这个方法是第一个被调用(1)
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive 被调用");
        //因为我们在其它方法会使用到 ctx
        context = ctx;
    }

    //收到服务器的数据后，调用方法 (4)
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channel 被调用");
        result = msg.toString();
        // 唤醒等待的线程
        notify();
    }


    @Override
    public synchronized Object call() throws Exception {
        //被代理对象调用, 发送数据给服务器，-> wait -> 等待被唤醒(channelRead) -> 返回结果 (3)-》5
        System.out.println("call1 被调用");
        context.writeAndFlush(params);
        // 进入wait 等待channelRead 方法获取到服务器的结果后，唤醒
        wait();
        System.out.println("call2被调用");
        // 服务返回的结果
        return result;
    }
    void setPara(String para){
        System.out.println("setPara");
        this.params = para;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
