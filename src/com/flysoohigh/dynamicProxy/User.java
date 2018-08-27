package com.flysoohigh.dynamicProxy;

public class User implements IUser {
    private String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
