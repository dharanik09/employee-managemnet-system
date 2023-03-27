package com.employeestorageservice.employeestorageservice.mapper;

import org.springframework.stereotype.Component;

@Component
public class test1 implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Test1");
        System.out.println("Test3");
        throw new Exception();

    }
}
