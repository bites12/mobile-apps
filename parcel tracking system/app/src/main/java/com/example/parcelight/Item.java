package com.example.parcelight;

public class Item {

    private String Tracking;
    private String DMName;
    private String CustName;
    private String Address;
    private String Postcode;
    private String Phone;


    public Item(){

    }

    public Item(String tracking,String dmname, String custname, String address, String postcode,String phone ){
        Tracking = tracking;
        DMName = dmname;
        CustName = custname;
        Address = address;
        Postcode = postcode;
        Phone = phone;

    }

    public String getTracking() {
        return Tracking;
    }

    public void setTracking(String tracking) {
        Tracking = tracking;
    }

    public String getDMName() {
        return DMName;
    }

    public void setDMName(String dmname) {
        DMName = dmname;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custname) {
        CustName = custname;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }




}
