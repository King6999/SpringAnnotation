package jx.bean;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    public Car(){
        System.out.println("Car---创建");
    }

//    public void init(){
//        System.out.println("Car---初始化");
//    }
//
//    public void destroy(){
//        System.out.println("Car---销毁");
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car---初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car---销毁");
    }
}
