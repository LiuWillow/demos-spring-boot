package com.lwl.thrift.controller;

import com.lwl.thrift.api.HiApi;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController implements HiApi.Iface {

    @Override
    public boolean exists(String path) throws TException {
        return false;
    }
}
