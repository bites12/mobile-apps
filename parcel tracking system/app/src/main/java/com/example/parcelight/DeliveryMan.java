package com.example.parcelight;

public class DeliveryMan {
    private String DeliveryID;
    private String Phone;
    private String Name;
    private String Password;
    private String Address;
    private String Postcode;

    public DeliveryMan() {

    }

    public DeliveryMan(String dmID,String name, String password,String phone, String address, String postcode) {
        DeliveryID = dmID;
        Name = name;
        Password = password;
        Phone = phone;
        Address = address;
        Postcode = postcode;
    }

    public String getDeliverymanID() {
        return DeliveryID;
    }

    public void setDeliverymanID(String dmID) {
        DeliveryID = dmID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }


}
