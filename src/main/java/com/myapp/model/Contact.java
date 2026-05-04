package com.myapp.model;

public class Contact {
    private static int nextId;
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;


    public Contact(String name, String address, String phoneNumber, String email)
    {   this.id = nextId++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(int id, String name, String address, String phoneNumber, String email)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'';
    }

    public String toCSV()
    {
        return id + "," + name + "," + address + "," + phoneNumber + "," + email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Contact.nextId = nextId;
    }
}
