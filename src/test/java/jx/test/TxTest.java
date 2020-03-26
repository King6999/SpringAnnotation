package jx.test;

import jx.Tx.TxConfig;
import jx.Tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.insertUser();
    }
}
