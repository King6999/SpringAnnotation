package jx.test;

import jx.bean.Person;
import jx.config.MainConfigOfProfile;
import jx.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.File;

public class ProfileTest {



    @Test
    public void test1(){
        //通过无参构造函数创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //启动刷新容器
        applicationContext.refresh();

        printBeans(applicationContext);
        //Person person = (Person)applicationContext.getBean("person");
        //System.out.println(person);

        String a = "a";
        String b = "bb";
        String c = String.join(File.separator,a,b);
        System.out.println("======="+c);

    }

    public void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }
        
    }
}
