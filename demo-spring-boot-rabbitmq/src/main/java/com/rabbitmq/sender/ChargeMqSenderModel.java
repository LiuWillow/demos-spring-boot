package com.rabbitmq.sender;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChargeMqSenderModel implements Serializable {
    private long userId;
    private String username;
    private String company;
    private Date openTime;
    private Date closeTime;
    private Integer storeId;
}