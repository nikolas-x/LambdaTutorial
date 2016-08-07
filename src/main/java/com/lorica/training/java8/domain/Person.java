package com.lorica.training.java8.domain;

import javax.annotation.Nullable;

public class Person {
    final private String firstName;
    final private String secondName;

    @Nullable
    final Integer age;

    public Person(String firstName, String secondName, @Nullable Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Nullable
    public Integer getAge() {
        return age;
    }
}
