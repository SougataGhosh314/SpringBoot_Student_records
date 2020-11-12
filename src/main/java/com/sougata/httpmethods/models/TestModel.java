package com.sougata.httpmethods.models;

import java.io.Serializable;

public class TestModel implements Serializable {

    String name;
    long phoneNumber;
    FriendOfTestModel friend;

    public TestModel(String name, long phoneNumber,
                     FriendOfTestModel friend) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.friend = friend;
    }

    public String displayData(){
        return name + "  Phone: " + phoneNumber + "\n" +
                "   Friend: " + friend.name + "  Phone: " +
                friend.phoneNumber;
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

    public FriendOfTestModel getFriend() {
        return friend;
    }

    public void setFriend(FriendOfTestModel friend) {
        this.friend = friend;
    }
}
