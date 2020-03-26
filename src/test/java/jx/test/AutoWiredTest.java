package jx.test;

import jx.config.MainConfigOfAutowired;
import jx.dao.BookDao;
import jx.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiredTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        //BookDao bookDao = (BookDao)applicationContext.getBean("bookDao2");
        //System.out.println(bookDao);
    }
}
