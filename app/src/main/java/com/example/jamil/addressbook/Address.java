package com.example.jamil.addressbook;

/**
 * Created by Jamil on 3/17/2016.
 */
public class Address {
    private int id;
    private String name;
    private String phoneNo;
    private String email;
    private String street;
    private String zip;
    private String city;

    public Address(int id, String name, String phoneNo, String email, String street, String zip, String city) {
        setId(id);
        setName(name);
        setPhoneNo(phoneNo);
        setEmail(email);
        setStreet(street);
        setZip(zip);
        setCity(city);
    }

    public Address(String name, String phoneNo, String email, String street, String zip, String city) {
        setName(name);
        setPhoneNo(phoneNo);
        setEmail(email);
        setStreet(street);
        setZip(zip);
        setCity(city);
    }

    public Address(String name, String phoneNo, String city) {
        setName(name);
        setPhoneNo(phoneNo);
        setCity(city);
    }

    public Address(String name, String phoneNo) {
        setName(name);
        setPhoneNo(phoneNo);
    }
    public Address(int id,String name, String phoneNo) {
        setId(id);
        setName(name);
        setPhoneNo(phoneNo);
    }

    public Address(String name) {
        setName(name);
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
