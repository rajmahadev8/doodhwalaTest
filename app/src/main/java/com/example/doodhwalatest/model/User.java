package com.example.doodhwalatest.model;

import java.io.Serializable;

public class User implements Serializable {
    String id, name, email, dob, home_Address, phone_number, Current_place, Transplace1, Transplace2, Transplace3, Transplace4, Transplace5, sex, marrital_status, current_dist, dist_to_transfer, q1, q2, q3, taluka_to_transfer, taluka_Current, strlevel_subject, strlevel;

    public User() {
    }

    public User(String id, String name, String email, String dob, String home_Address, String phone_number, String Current_place, String Transplace1, String Transplace2, String Transplace3, String Transplace4, String Transplace5, String sex, String marrital_status, String current_dist, String dist_to_transfer, String q1, String q2, String q3,String  taluka_Current,String  taluka_to_transfer,String strlevel ,String strlevel_subject ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

        this.home_Address = home_Address;
        this.phone_number = phone_number;
        this.Current_place = Current_place;

        this.Transplace1 = Transplace1;
        this.Transplace2 = Transplace2;
        this.Transplace3 = Transplace3;
        this.Transplace4 = Transplace4;
        this.Transplace5 = Transplace5;

        this.sex = sex;
        this.marrital_status = marrital_status;

        this.current_dist = current_dist;
        this.dist_to_transfer = dist_to_transfer;

        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.taluka_to_transfer = taluka_to_transfer;
        this.taluka_Current = taluka_Current;
        this.strlevel_subject = strlevel_subject;
        this.strlevel = strlevel;

    }

    //Q1
    public String getq1() {
        return q1;
    }

    public void setq1(String q1) {
        this.q1 = q1;
    }

    //Q2
    public String getq2() {
        return q2;
    }

    public void setq2(String q2) {
        this.q2 = q2;
    }

    //Q3
    public String getq3() {
        return q3;
    }

    public void setq3(String q3) {
        this.q3 = q3;
    }


    public String getcurrent_dist() {
        if (current_dist == null)
            return "0";
        else
            return current_dist;
    }

    public void setcurrent_dist(String current_dist) {
        this.current_dist = current_dist;
    }

    public String getdist_to_transfer() {
        if (dist_to_transfer == null)
            return "0";
        else
            return dist_to_transfer;
    }

    public void setdist_to_transfer(String dist_to_transfer) {
        this.dist_to_transfer = dist_to_transfer;
    }

    public String gettaluka_to_transfer() {
        if (taluka_to_transfer == null)
            return "0";
        else
            return taluka_to_transfer;
    }

    public void settaluka_to_transfer(String taluka_to_transfer) {
        this.taluka_to_transfer = taluka_to_transfer;
    }

    public String gettaluka_current() {
        if (taluka_Current == null)
            return "0";
        else
            return taluka_Current;
    }

    public void settaluka_current(String taluka_to_current) {
        this.taluka_Current = taluka_to_current;
    }

    public String getlevel() {
        if (strlevel == null)
            return "0";
        else
            return strlevel;
    }

    public void setlevel(String strlevel) {
        this.strlevel = strlevel;
    }

    public String getlevel_subject() {
        if (strlevel_subject == null)
            return "0";
        else
            return strlevel_subject;
    }

    public void setlevel_subject(String strlevel_subject) {
        this.strlevel_subject = strlevel_subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (name == null)
            return "";
        else
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        if (email == null)
            return "";
        else
            return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gethome_Address() {
        return home_Address;
    }

    public void sethome_Address(String home_Address) {
        this.home_Address = home_Address;
    }

    public String getphone_number() {
        return phone_number;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCurrent_place() {
        return Current_place;
    }

    public void setCurrent_place(String Current_place) {
        this.Current_place = Current_place;
    }

    public String getTransplace1() {
        return Transplace1;
    }

    public void setTransplace1(String Transplace1) {
        this.Transplace1 = Transplace1;
    }

    public String getTransplace2() {
        return Transplace2;
    }

    public void setTransplace2(String Transplace2) {
        this.Transplace2 = Transplace2;
    }

    public String getTransplace3() {
        return Transplace3;
    }

    public void setTransplace3(String Transplace3) {
        this.Transplace3 = Transplace3;
    }

    public String getTransplace4() {
        return Transplace4;
    }

    public void setTransplace4(String Transplace4) {
        this.Transplace4 = Transplace4;
    }

    public String getTransplace5() {
        return Transplace5;
    }

    public void setTransplace5(String Transplace5) {
        this.Transplace5 = Transplace5;
    }

    public String getsex() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    public String getmarrital_status() {
        return marrital_status;
    }

    public void setmarrital_status(String marrital_status) {
        this.marrital_status = marrital_status;
    }

}
