package com.lorica.training.java8.domain;

import javax.annotation.Nullable;
public class Student extends Person {
    public Double getWAM() {
        return WAM;
    }

    private final Double WAM;
    public Student(String firstName, String secondName, @Nullable Integer age, Double wam) {
        super(firstName, secondName, age);
        WAM = wam;
    }
}
