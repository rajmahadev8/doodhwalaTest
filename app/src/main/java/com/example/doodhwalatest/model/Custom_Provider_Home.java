package com.example.doodhwalatest.model;

public class Custom_Provider_Home {
    String no;
    String Name;

    public Custom_Provider_Home(String no, String name) {
        this.no = no;
        Name = name;
    }

    public void setNo(String  no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
