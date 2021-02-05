package com.shaun.informal.test;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private TestObject firstName;
    private String lastName;

    Person() {}

    Person(TestObject firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TestObject getFirstName() {
        return firstName;
    }

    public void setFirstName(TestObject firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
