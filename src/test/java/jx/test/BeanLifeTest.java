package jx.test;

import jx.config.MainConfig3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeTest {


    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        //Object car = applicationContext.getBean("car");
        //通过关闭容器使得对象销毁
        applicationContext.close();
    }
}
