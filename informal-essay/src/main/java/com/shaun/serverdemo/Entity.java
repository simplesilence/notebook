package com.shaun.serverdemo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Entity implements Serializable {

    private Integer id;

    private String name;

    private Byte age;

    private Integer[] intArr;

    private List<String> strList;

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

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Integer[] getIntArr() {
        return intArr;
    }

    public void setIntArr(Integer[] intArr) {
        this.intArr = intArr;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", intArr=" + Arrays.toString(intArr) +
                ", strList=" + strList +
                '}';
    }
}
