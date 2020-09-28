package com.shaun.informal.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

    final static Base64.Decoder decoder = Base64.getDecoder();

    public static void main(String[] args) throws Exception {

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

//        String data = "eyJkaXN0aW5jdF9pZCI6ImYxMGViYjM1NDAxYzQxNjlhOWQ0YzM0YmNjNjZjMzdlIiwibGliIjp7IiRsaWIiOiJqcyIsIiRsaWJfbWV0aG9kIjoiY29kZSIsIiRsaWJfdmVyc2lvbiI6IjEuMTUuOSJ9LCJwcm9wZXJ0aWVzIjp7IiR0aW1lem9uZV9vZmZzZXQiOi00ODAsIiRzY3JlZW5faGVpZ2h0Ijo3MzYsIiRzY3JlZW5fd2lkdGgiOjQxNCwiJGxpYiI6ImpzIiwiJGxpYl92ZXJzaW9uIjoiMS4xNS45IiwiJGxhdGVzdF9yZWZlcnJlciI6InVybOeahGRvbWFpbuino+aekOWksei0pSIsIiRsYXRlc3RfdHJhZmZpY19zb3VyY2VfdHlwZSI6InVybOeahGRvbWFpbuino+aekOWksei0pSIsIiRsYXRlc3Rfc2VhcmNoX2tleXdvcmQiOiJ1cmznmoRkb21haW7op6PmnpDlpLHotKUiLCIkcmVmZXJyZXIiOiJodHRwOi8vbG9jYWxob3N0OjMwMDUvbG9naW4uaHRtbCIsIiR1cmwiOiJodHRwOi8vbG9jYWxob3N0OjMwMDUvbG9naW4uaHRtbCMvIiwiJHVybF9wYXRoIjoiL2xvZ2luLmh0bWwiLCIkdGl0bGUiOiIiLCIkaXNfZmlyc3RfZGF5IjpmYWxzZSwiJGlzX2ZpcnN0X3RpbWUiOmZhbHNlLCIkcmVmZXJyZXJfaG9zdCI6ImxvY2FsaG9zdCJ9LCJsb2dpbl9pZCI6ImYxMGViYjM1NDAxYzQxNjlhOWQ0YzM0YmNjNjZjMzdlIiwiYW5vbnltb3VzX2lkIjoiMTcyYTI1NmIxNGE2Y2MtMGRhMjk1MzYyZTQzM2UtNWQ0OTJmMTItMzY4NjQwMC0xNzJhMjU2YjE0Yjg3ZiIsInR5cGUiOiJ0cmFjayIsImV2ZW50IjoiJHBhZ2V2aWV3IiwiX3RyYWNrX2lkIjo5MjU2NDIzODB9";
//        System.out.println(new String(decoder.decode(data), "UTF-8"));

//        BigDecimal bigDecimal = new BigDecimal("0.00");
//        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO)==0 );


//        String str = "abcabcbb";
//        for (int i = 0; i < str.length(); i++) {
//            String subStr = str.substring(i, )
//        }

//        try{
//            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
//            Date d1 = sdformat.parse("2020-07-30");
//            Date d2 = new Date();
//            System.out.println("The date 1 is: " + sdformat.format(d1));
//            System.out.println("The date 2 is: " + sdformat.format(d2));
//            if(d1.compareTo(d2) > 0) {
//                System.out.println("Date 1 occurs after Date 2");
//            } else if(d1.compareTo(d2) < 0) {
//                System.out.println("Date 1 occurs before Date 2");
//            } else if(d1.compareTo(d2) == 0) {
//                System.out.println("Both dates are equal");
//            }
//        }catch (Exception ex){
//
//        }

//        int a = Integer.parseInt("2014-02-14".substring(0,4)) - Integer.parseInt("3019-02-14".substring(0,4));
//        System.out.println(a==-1005);

//        System.out.println(new Date().after(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22")));
//        System.out.println(new Date().after(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22T16:00:00.000Z")));
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).after(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21")));

//
//        System.out.println((int)(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-14").getTime() - new Date().getTime()) / (1000*3600*24));


//        Child child = new Child();
//        child.setFirstName("ssss");

//        System.out.println(LocalDate.parse("2010-08-23T00:00:00.000Z", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

//        int age = 20, years = 10;
//        if((age < 16 && years != 5) || (age > 15 && age < 26 && years != 10) || (age > 25 && age < 46 && years != 20) || (age > 45 && years != -1)){
//            System.out.println("cc");
//        }
//
//        System.out.println("测试");

//        BigDecimal bigDecimal = new BigDecimal(0);
//        bigDecimal = bigDecimal.add(new BigDecimal(2.0));
//        System.out.println(bigDecimal.toString());


        System.out.println(getAge("20200925", "20100925"));
    }


    private static Integer getAge(String now, String born){

        //计算年龄差
        Integer ageBit = Integer.parseInt(now) - Integer.parseInt(born);
        Integer personAge;
        if (ageBit.toString().length() > 4) {
            personAge = Integer.parseInt(ageBit.toString().substring(0, ageBit.toString().length() - 4));
        }else {
            personAge = 0;
        }

        return personAge;
    }
}

