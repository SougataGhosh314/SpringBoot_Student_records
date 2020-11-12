package com.sougata.httpmethods.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DAOImpl implements DAO {
    @Override
    public void DAOMethod(){
        System.out.println("Inside DAO Method...");
    }
}
