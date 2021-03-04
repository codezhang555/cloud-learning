package com.itz.cloud.juc;


/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.juc
 * @Version 1.0
 * @date 2020/12/20 21:45
 */

public class Person {
    private Integer id;
    private String name;

    public Person(String name){
        this.name = name;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
