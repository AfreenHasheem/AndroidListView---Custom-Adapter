package com.example.androidlistview_customadapter;

public class DataModel {

    String name;
    String type;
    String versionNumber;
    String feature;

    // Constructor that is used to create an instance of the Data object
    public DataModel(String name, String type, String versionNumber, String feature) {
        this.name = name;
        this.type = type;
        this.versionNumber = versionNumber;
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
