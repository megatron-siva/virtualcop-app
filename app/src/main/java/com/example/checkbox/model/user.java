package com.example.checkbox.model;
import io.realm.RealmObject;

public class user extends RealmObject{
    String name;
    String number;
    String gender;
    String dob;
    String address;
    String pmob;
    String pname;
    String prelation;
    String p2mob;
    String p2name;
    String p2relation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPmob() {
        return pmob;
    }

    public void setPmob(String pmob) {
        this.pmob = pmob;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrelation() {
        return prelation;
    }

    public void setPrelation(String prelation) {
        this.prelation = prelation;
    }

    public String getP2mob() {
        return p2mob;
    }

    public void setP2mob(String p2mob) {
        this.p2mob = p2mob;
    }

    public String getP2name() {
        return p2name;
    }

    public void setP2name(String p2name) {
        this.p2name = p2name;
    }

    public String getP2relation() {
        return p2relation;
    }

    public void setP2relation(String p2relation) {
        this.p2relation = p2relation;
    }


}
