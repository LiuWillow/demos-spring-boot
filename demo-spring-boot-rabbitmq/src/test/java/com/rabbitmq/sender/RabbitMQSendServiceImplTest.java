package com.rabbitmq.sender;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.DemoSpringBootRabbitmqApplication;
import com.rabbitmq.config.AmqpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringBootRabbitmqApplication.class)
public class RabbitMQSendServiceImplTest {
    Logger logger = LoggerFactory.getLogger(RabbitMQSendServiceImplTest.class);
    @Autowired
    private RabbitMQSendService rabbitService;

    @Test
    public void testSend(){
        logger.info("------------发送消息到交换机---------------");
        rabbitService.sendFanout("发送的消息");
    }

    @Test
    public void testSendFanout(){
        CorpLogoModel corpLogoModel = new CorpLogoModel();
        corpLogoModel.setUserId(8L);
        corpLogoModel.setLogo("fake.logo");
        rabbitService.sendFanout(corpLogoModel, AmqpConfig.CORP_LOGO_FANOUT_EXCHANGE_STORE);
        rabbitService.sendFanout(corpLogoModel, AmqpConfig.CORP_LOGO_FANOUT_EXCHANGE_STORE);
        rabbitService.sendFanout(corpLogoModel, AmqpConfig.CORP_LOGO_FANOUT_EXCHANGE_STORE);
    }

    @Test
    public void testSendTopic(){
        CorpLogoModel corpLogoModel = new CorpLogoModel();
        corpLogoModel.setUserId(8L);
        corpLogoModel.setLogo("fake.logo");
        rabbitService.sendTopic(JSON.toJSONString(corpLogoModel), AmqpConfig.CORP_LOGO_ROUTING_KEY);
    }

    @Test
    public void sendCloseStore(){

        ChargeMqSenderModel senderModel = new ChargeMqSenderModel();
        senderModel.setStoreId(222);
        rabbitService.sendCloseStore(senderModel);
    }

    @Test
    public void sendDelay(){
        rabbitService.sendDelay("这是一条延迟消息");
    }
}