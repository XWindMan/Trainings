package com.vtrump.fragmentnestdemo;


public enum Gender {

    MALE("0"),
    FEMALE("1");

    Gender(String nativeStr) {
        this.nativeStr = nativeStr;
    }

    public final String nativeStr;
}
