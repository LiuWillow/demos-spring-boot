package com.lwl.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author liuweilong
 * @date 2021/4/9
 * @description
 */
public class Test {
    public static void main(String[] args) throws java.io.IOException {
        ActorSystem system = ActorSystem.create("testSystem");

        ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");
        System.out.println("First: " + firstRef);
        firstRef.tell("printit", ActorRef.noSender());

        System.out.println(">>> Press ENTER to exit <<<");
        try {
            System.in.read();
        } finally {
            system.terminate();
        }
    }


    static class PrintMyActorRefActor extends AbstractActor {
        static Props props() {
            return Props.create(PrintMyActorRefActor.class, PrintMyActorRefActor::new);
        }

        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .matchEquals("printit", p -> {
                        ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
                        System.out.println("Second: " + secondRef);
                    })
                    .build();
        }
    }
}
