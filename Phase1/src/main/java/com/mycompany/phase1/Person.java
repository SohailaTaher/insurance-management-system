package com.mycompany.phase1;

public abstract class Person {
    protected int id;
    protected String name;
    protected int phoneNum;
    protected String address;

    public Person(int id, String name, int phoneNum, String address) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }



    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNum + ", Address: " + address;
    }
}

