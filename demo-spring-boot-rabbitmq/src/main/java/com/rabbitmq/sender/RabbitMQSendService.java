package com.rabbitmq.sender;

public interface RabbitMQSendService {
    void sendFanout(String msg);
    void sendFanout(CorpLogoModel corpLogoModel, String fanoutExhcangeName);
    void sendTopic(String message, String routingKey);

    void sendCloseStore(ChargeMqSenderModel senderModel);
    void sendDelay(String msgDelay);
}