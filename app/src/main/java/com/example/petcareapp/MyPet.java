package com.example.petcareapp;

public class MyPet {
    String edPetname, edPettype, edPetbreed;

    public MyPet() {
    }

    public MyPet(String edPetname, String edPettype, String edPetbreed) {
        this.edPetname = edPetname;
        this.edPettype = edPettype;
        this.edPetbreed = edPetbreed;
    }

    public String getEdPetname() {
        return edPetname;
    }

    public void setEdPetname(String edPetname) {
        this.edPetname = edPetname;
    }

    public String getEdPettype() {
        return edPettype;
    }

    public void setEdPettype(String edPettype) {
        this.edPettype = edPettype;
    }

    public String getEdPetbreed() {
        return edPetbreed;
    }

    public void setEdPetbreed(String edPetbreed) {
        this.edPetbreed = edPetbreed;
    }
}
