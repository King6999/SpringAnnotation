package jx.test;

import jx.bean.Person;
import jx.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyValuesTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test1(){
        printBeans(applicationContext);
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }

    public void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }
    }
}
