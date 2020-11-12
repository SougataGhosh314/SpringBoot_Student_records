package com.sougata.httpmethods.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ServiceImpl implements Service {
    @Override
    public void ServiceMethod(){
        System.out.println("Inside Service Method...");
    }
}
