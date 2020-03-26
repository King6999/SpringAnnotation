package jx.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    //1、基本类型
    //2、SpEL类型：#{}
    //3、${}:取出配置文件(properties文件)中的值（环境变量中的值）
    @Value("king")
    private String name;
    @Value("#{28-2}")
    private Integer age;
    @Value("${person.nikeName}")
    private String nikeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }

    public Person() {
    }
}
