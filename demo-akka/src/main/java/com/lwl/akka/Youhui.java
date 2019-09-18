package com.lwl.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * author liuweilong
 * date 2019/8/30 14:18
 * desc
 */
public class Youhui {
    static class ActorDemo extends AbstractActor{
        private int count = 0;
        Receive receive = receiveBuilder().matchAny((msg) -> {
            System.out.println("优惠500");
            if (msg.equals("unbecome")){
                getContext().unbecome();
            }
        }).build();
        @Override
        public Receive createReceive() {
            return receiveBuilder().match(String.class, (msg) -> {
                count++;
                System.out.println("优惠1000");
                if (count == 3){
                    //如果加了true，则会丢弃前一个actor，其实是一个栈
                    getContext().become(receive, true);
                }
            }).build();
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef ref = system.actorOf(Props.create(ActorDemo.class), "actorDemo");
        ref.tell("1", ActorRef.noSender());
        ref.tell("2", ActorRef.noSender());
        ref.tell("3", ActorRef.noSender());
        ref.tell("4", ActorRef.noSender());
        ref.tell("5", ActorRef.noSender());
        ref.tell("unbecome", ActorRef.noSender());
        ref.tell("7", ActorRef.noSender());
        ref.tell("8", ActorRef.noSender());
    }
}
