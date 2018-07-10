package com.flysoohigh.optional;

import java.util.Optional;

public class User {
    private String name;
    private int age;
    private Address address;
    private Optional<Hobby> hobby; // bad usage of Optional<T> as field (don't do this) with the purpose to test flatMap()

    public User(String name, int age, Address address, Optional<Hobby> hobby) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
    }

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Optional<Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(Optional<Hobby> hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobby=" + hobby +
                '}';
    }
}
