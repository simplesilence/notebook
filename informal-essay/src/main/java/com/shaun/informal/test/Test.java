package com.shaun.informal.test;

public class Test {

    public static void main(String[] args) {

//        System.out.println(new String[0].getClass());

        // 直接引用 Person 构造器
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);


    }
}
