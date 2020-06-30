package com.shaun.informal.test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {

    final static Base64.Decoder decoder = Base64.getDecoder();

    public static void main(String[] args) throws UnsupportedEncodingException {

//        System.out.println(new String[0].getClass());

        // 直接引用 Person 构造器
//        PersonFactory<Person> personFactory = Person::new;
//        Person person = personFactory.create("Peter", "Parker");
//        System.out.println(person);


//        String str = "\"test\"aaa\"bbb\"";
//        System.out.println(str.replace("\"", ""));
//        str.split("\"", 1);

//        System.out.println(str);
//        System.out.println(str.substring(1));
//        System.out.println(str.substring(0, str.length()-1));

        String data = "eyJkaXN0aW5jdF9pZCI6ImYxMGViYjM1NDAxYzQxNjlhOWQ0YzM0YmNjNjZjMzdlIiwibGliIjp7IiRsaWIiOiJqcyIsIiRsaWJfbWV0aG9kIjoiY29kZSIsIiRsaWJfdmVyc2lvbiI6IjEuMTUuOSJ9LCJwcm9wZXJ0aWVzIjp7IiR0aW1lem9uZV9vZmZzZXQiOi00ODAsIiRzY3JlZW5faGVpZ2h0Ijo3MzYsIiRzY3JlZW5fd2lkdGgiOjQxNCwiJGxpYiI6ImpzIiwiJGxpYl92ZXJzaW9uIjoiMS4xNS45IiwiJGxhdGVzdF9yZWZlcnJlciI6InVybOeahGRvbWFpbuino+aekOWksei0pSIsIiRsYXRlc3RfdHJhZmZpY19zb3VyY2VfdHlwZSI6InVybOeahGRvbWFpbuino+aekOWksei0pSIsIiRsYXRlc3Rfc2VhcmNoX2tleXdvcmQiOiJ1cmznmoRkb21haW7op6PmnpDlpLHotKUiLCIkcmVmZXJyZXIiOiJodHRwOi8vbG9jYWxob3N0OjMwMDUvbG9naW4uaHRtbCIsIiR1cmwiOiJodHRwOi8vbG9jYWxob3N0OjMwMDUvbG9naW4uaHRtbCMvIiwiJHVybF9wYXRoIjoiL2xvZ2luLmh0bWwiLCIkdGl0bGUiOiIiLCIkaXNfZmlyc3RfZGF5IjpmYWxzZSwiJGlzX2ZpcnN0X3RpbWUiOmZhbHNlLCIkcmVmZXJyZXJfaG9zdCI6ImxvY2FsaG9zdCJ9LCJsb2dpbl9pZCI6ImYxMGViYjM1NDAxYzQxNjlhOWQ0YzM0YmNjNjZjMzdlIiwiYW5vbnltb3VzX2lkIjoiMTcyYTI1NmIxNGE2Y2MtMGRhMjk1MzYyZTQzM2UtNWQ0OTJmMTItMzY4NjQwMC0xNzJhMjU2YjE0Yjg3ZiIsInR5cGUiOiJ0cmFjayIsImV2ZW50IjoiJHBhZ2V2aWV3IiwiX3RyYWNrX2lkIjo5MjU2NDIzODB9";
        System.out.println(new String(decoder.decode(data), "UTF-8"));
    }
}
