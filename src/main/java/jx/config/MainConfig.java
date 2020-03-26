package jx.config;

import jx.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类等同于配置文件
@Configuration //告诉Spring这是一个配置类
//value:指定要扫描的包;
//excludeFilters = Filter[] :扫描时按指定的规则排除哪些组件
//@ComponentScan(value = "jx", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})})
//includeFilters = Filter[] ：扫描时只需要包含哪些组件,必须同时使用useDefaultFilters=false；
//FilterType.ANNOTATION：按照注解的方式
//@ComponentScan(value = "jx", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, useDefaultFilters = false)
//FilterType.ASSIGNABLE_TYPE：按照给定的类型
//FilterType.ASPECTJ：按照ASPECTJ表达是过滤
//FilterType.REGEX：按照REGEX表达式进行过滤
//FilterType.CUSTOM：按照用户定义的规则进行过滤
@ComponentScan(value = "jx", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}, useDefaultFilters = false)
public class MainConfig {

    //给容器注册一个bean；类型为返回值的类型，默认方法明作为id。
    @Bean("person")//value属性用来记录id,默认是单例模式。
    public Person person(){
        return new Person("lisi",25);
    }
}
