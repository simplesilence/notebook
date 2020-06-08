package com.shaun.informal.test;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}