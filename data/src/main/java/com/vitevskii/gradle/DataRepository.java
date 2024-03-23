package com.vitevskii.gradle;

public class DataRepository {
    public String getGreeting(String name) {
        if (name == null || name.isEmpty()){
            name = "Joe Doe";
        }
        return "Hello, " + name + "!";
    }
}
