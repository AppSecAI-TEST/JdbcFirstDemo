package com.firstspringjdbc.JdbcFirstDemo.model;

/**
 * Created by abhi on 21/06/17.
 */

public class Student {

    private Integer id;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String name;
    private String city;

}
