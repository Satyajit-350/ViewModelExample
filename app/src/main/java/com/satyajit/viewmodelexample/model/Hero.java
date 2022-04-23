package com.satyajit.viewmodelexample.model;

import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    private String name;
    @SerializedName("realname")
    private String realName;
    @SerializedName("team")
    private String team;
    @SerializedName("firstappearance")
    private String firstAppearance;
    @SerializedName("bio")
    private String bio;
    @SerializedName("imageurl")
    private String picture;

    public Hero(String name, String realName, String team, String firstAppearance, String bio, String picture) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.bio = bio;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
