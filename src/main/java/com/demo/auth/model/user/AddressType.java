package com.demo.auth.model.user;

public enum AddressType {
    HOME("Home"),
    WORK("Work");

    private String name;

    AddressType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
