package jx.test;

import jx.bean.ColorFactoryBean;
import jx.bean.Person;
import jx.config.MainConfig;
import jx.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @SuppressWarnings("resource")
    @Test
    public void test1(){
        //IOC容器
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] strings = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < strings.length ; i++) {
            System.out.println(strings[i]);
        }
    }

    @Test
    public void test2(){
        //IOC容器
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person1 = applicationContext.getBean(Person.class);
//        Person person2 = applicationContext.getBean(Person.class);
//        System.out.println(person1 == person2);
    }

    @Test
    public void test3(){
        String[] strings = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        //获取环境变量的值
        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    @Test
    public void testImport(){
        String[] strings = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    @Test
    public void test4(){
        Object bean = applicationContext.getBean("colorFactoryBean");
        System.out.println(bean.getClass());
    }
}
