package com.java.StreamAPI.model;


import lombok.NoArgsConstructor;
@NoArgsConstructor
public class Person {
    private String name;
    private String country;
    private Integer age;

    public Person(String name, String country, Integer age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
