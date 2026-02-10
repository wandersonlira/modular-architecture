package com.example.client.core.domain;

import com.example.client.core.value_objects.Gender;

import java.util.Objects;

abstract sealed class Person permits Customer {
    private String name;
    private Gender sex;


    protected Person(String name, Gender sex) {
        nameValid(name);
        sexValid(sex);
        this.name = name;
        this.sex = sex;
    }


    private void nameValid(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
    }

    private void sexValid(Gender sex) {
        if (sex == null) {
            throw new IllegalArgumentException("Gender sex is required.");
        }
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getSex() {
        return sex;
    }
    public void setSex(Gender sex) {
        this.sex = sex;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
