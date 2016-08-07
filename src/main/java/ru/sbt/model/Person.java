package ru.sbt.model;

public class Person {
    private String name;
    private Integer ages;

    public Person(String name, Integer ages) {
        this.name = name;
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    @Override
    public String toString() {
        return this.name + ", age " + this.ages;
    }
}