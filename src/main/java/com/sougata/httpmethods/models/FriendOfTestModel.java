package com.sougata.httpmethods.models;

import java.io.Serializable;

public class FriendOfTestModel implements Serializable {
    String name;
    long phoneNumber;

    public FriendOfTestModel(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
