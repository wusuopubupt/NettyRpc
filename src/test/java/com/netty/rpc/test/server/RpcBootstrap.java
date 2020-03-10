package com.netty.rpc.test.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.netty.rpc"})
//@ImportResource(locations = {"classpath:server-spring.xml"})
public class RpcBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(RpcBootstrap.class, args);
    }
}
