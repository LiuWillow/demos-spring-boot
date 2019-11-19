package com.lwl.rocketmq.originclient.orderexample;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * author liuweilong
 * date 2019/11/17 18:52
 * desc
 */
public class OrderedProducer {
    /**
     * 不太懂
     */
    public static void main(String[] args) throws Exception {
        MQProducer producer = new DefaultMQProducer("my_group");
        producer.start();
        String[] tags = new String[]{"ta1", "tag2"};
        Message message = new Message("my_topic", "ta1", "hello".getBytes(RemotingHelper.DEFAULT_CHARSET));
        Integer orderId = 1;
        SendResult sendResult = producer.send(message, (list, message1, o) -> {
            Integer id = (Integer) o;
            int index = id % list.size();
            return list.get(index);
        }, orderId);
        System.out.println(sendResult);
        producer.shutdown();
    }
}
