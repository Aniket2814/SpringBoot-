package com.springboot.beans.SpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


public class Apple {

    public void eatApple()
    {
        System.out.println("Eat Apple ");
    }

    @PostConstruct
    public void show1()
    {

        System.out.println("Bean is Created ");
    }

    @PreDestroy
    public void show2()
    {
        System.out.println("Bean is Destroyed");
    }
}
