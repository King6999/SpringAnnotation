package jx.config;

import jx.bean.Color;
import jx.bean.ColorFactoryBean;
import jx.bean.Person;
import jx.condition.MacCondition;
import jx.condition.MyImportSelector;
import jx.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//配置类等同于配置文件
@Configuration //告诉Spring这是一个配置类
//快速导入组件，默认id是组件的全类名
@Import({Color.class, MyImportSelector.class})
@Conditional(WindowsCondition.class)
public class MainConfig2 {

    //singleton:单实例（默认值）,在IOC容器创建的时候调用方法创建对象放到IOC容器中以后每次获取就是从容器中拿map.get()；
    //prototype:多实例；在IOC容器创建时不会调用方法创建对象在容器中，而是在每次获取的时候才调用方法创建对象，每次获取都会创建一次；
    //request：同一个请求使用同一个实例；session：同一个session创建一个实例。
    //@Scope("prototype")
    //懒加载：单例bean默认在容器启动的时候创建对象，而懒加载是容器启动后并不进行创建对象，在第一次使用（获取）Bean创建对象，并进行初始化。
    @Lazy
    @Bean("person")//value属性用来记录id,
    public Person person(){
        System.out.println("对象创建");
        return new Person("lisi",25);
    }

    //如果放在方法上面，按一定条件进行判断，满足条件给容器注册bean对象
    //如果放在类上面，表示满足这个条件，这个类中的所有bean注册才会生效
    @Conditional(WindowsCondition.class)
    @Bean("win")
    public Person person1(){
        return new Person("win", 100);
    }

    @Conditional(MacCondition.class)
    @Bean("ios")
    public Person person2(){
        return new Person("ios",120);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
