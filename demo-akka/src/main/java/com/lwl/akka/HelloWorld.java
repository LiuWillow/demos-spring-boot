package com.lwl.akka;

import akka.actor.*;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * author liuweilong
 * date 2019/8/30 11:37
 * desc
 */
public class HelloWorld {
    static class SimpleActor extends AbstractActor{

        public Receive createReceive() {
            //方法是异步的
            return receiveBuilder().match(String.class, System.out::println).build();
        }
    }
    static class ActorDemo extends AbstractActor{

        public Receive createReceive() {
            //方法是异步的
            System.out.println(Thread.currentThread().getName());

            return receiveBuilder().match(String.class, (msg) -> {
//                ActorRef simpleActor = getContext().actorOf(Props.create(SimpleActor.class), "simpleActor");
                //发送，要指定发送者
//                simpleActor.tell("from simpleActor", getSelf());
                //转发，发送者是当前的接受者
//                simpleActor.forward(msg, getContext());
//                把消息返回给发送者
                getSender().tell("result ", getSelf());
                //并且在这个线程内部抛出的异常是可以被父线程获取到的，跟java的线程使用又有些不同
//                throw new NullPointerException();
            }).build();
        }
    }
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        //创建定义好的actor对象，指定名称，只能获取引用 ，不能调用其中的方法，必须通过消息的方式
        ActorRef actorDemo = system.actorOf(Props.create(ActorDemo.class), "actorDemo");
        //打印出来的是一个地址+名称+id，可以用地址+服务名来实现分布式微服务
        System.out.println(actorDemo);
//        System.out.println("主线程：" + Thread.currentThread().getName());
//        actorDemo.tell("hello world", ActorRef.noSender());

        Timeout timeout = new Timeout((Duration.create(1, TimeUnit.SECONDS)));
        //这个future是scala里的future，阻塞timeout时间内那消息
        Future<Object> future = Patterns.ask(actorDemo, "hello", timeout);
        future.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable failure, Object success) throws Throwable {
                System.out.println("进入onComplete, 结果为：" + success);
            }
        }, system.getDispatcher());

        //可以通过路径来查找actor
        ActorSelection actorSelection = system.actorSelection("akka://sys/user/actorDemo");
    }
}