package com.classassignment.e_softwarica.model;

import java.util.ArrayList;
import java.util.List;

public class Contacts {
    private String name;
    private String age;
    private String address;
    private String gender;


    static List<Contacts> contactsList = new ArrayList<>();

    public Contacts(String name, String age, String address, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
       // this.imagenumber = imagenumber;
    }

    public static List<Contacts> getContactsList() {
        return contactsList;
    }

    public static void setContactsList(List<Contacts> contactsList) {
        Contacts.contactsList = contactsList;
    }

//    public int getImagenumber() { return imagenumber; }
//
//    public void setImagenumber(int imagenumber) { this.imagenumber = imagenumber; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}