package com.example.petcareapp;

public class MyProfile {
    String edName, edPhonenumber, edEmail;

    public MyProfile() {
    }

    public MyProfile(String edName, String edPhonenumber, String edEmail) {
        this.edName = edName;
        this.edPhonenumber = edPhonenumber;
        this.edEmail = edEmail;
    }

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public String getEdPhonenumber() {
        return edPhonenumber;
    }

    public void setEdPhonenumber(String edPhonenumber) {
        this.edPhonenumber = edPhonenumber;
    }

    public String getEdEmail() {
        return edEmail;
    }

    public void setEdEmail(String edEmail) {
        this.edEmail = edEmail;
    }
}
