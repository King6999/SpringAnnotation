package jx.test;

import jx.aop.MathCalculator;
import jx.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        calculator.div(8,0);
    }
}
