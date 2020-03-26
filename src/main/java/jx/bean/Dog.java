package jx.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog() {
        System.out.println("Dog---Constructor---");
    }

    @PostConstruct//对象创建并赋值之后调用
    public void init(){
        System.out.println("Dog----init----");
    }

    @PreDestroy//容器移除对象之前调用
    public void destroy(){
        System.out.println("Dog----destroy---");
    }
}
