package com.lwl.thrift.server;

import com.lwl.thrift.api.HiApi;
import com.lwl.thrift.controller.HiController;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ThriftServer {

    @Value("${thrift.port}")
    private int port;
    @Value("${thrift.minWorkerThreads}")
    private int minThreads;
    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    @Autowired
    private HiController hiController;

    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    @PostConstruct
    public void start() {
        //TMultiplexedProcessor processor = new TMultiplexedProcessor();
        //processor.registerProcessor(JazzService.class.getSimpleName(), new JazzService.Processor<JazzService.Iface>(hadoopService));
        HiApi.Processor<HiApi.Iface> processor = new HiApi.Processor<>(hiController);
        init();
        try {
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            //TServer server = new TSimpleServer(tArgs);
            log.info("thrift服务启动成功, 端口={}", port);
            server.serve();
        } catch (Exception e) {
            log.error("thrift服务启动失败", e);
        }

    }
}
