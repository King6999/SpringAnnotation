package jx.config;

import jx.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("jx.bean")
@Configuration
public class MainConfig3 {

    @Bean//(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
