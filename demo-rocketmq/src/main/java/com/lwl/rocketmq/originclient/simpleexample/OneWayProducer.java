package com.lwl.rocketmq.originclient.simpleexample;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * author liuweilong
 * date 2019/11/17 18:37
 * desc
 */
public class OneWayProducer {
    /**
     * 单向发送消息，不需要确认，用于可靠性比较低的场景，如日志
     */
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("my_producer_group");
        producer.setNamesrvAddr("119.3.210.17:9876");
        producer.start();
        Message msg = new Message("my_topic", "my_tag",
                "this is a message ".getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.sendOneway(msg);
        producer.shutdown();
    }
}
