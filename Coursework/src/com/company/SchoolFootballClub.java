package com.company;

import java.io.Serializable;

public class SchoolFootballClub extends FootballClub implements Serializable {

    //Instance Variables
    private String schoolName;
    private int ageCategoryUnder;


    //Default Constructor
    public SchoolFootballClub(String clubName, String clubLocation, int stats) {
        super(clubName, clubLocation, stats);
        this.schoolName = schoolName;
        this.ageCategoryUnder = ageCategoryUnder;
    }

    //Args Constructor
    public SchoolFootballClub(String clubName, String clubLocation, int stats, String schoolName, int ageCategory) {
        super(clubName,clubLocation,stats);
        this.schoolName = schoolName;
        this.ageCategoryUnder = ageCategory;
    }

    //Getter and Setter Methods

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getAgeCategoryUnder() {
        return ageCategoryUnder;
    }

    public void setAgeCategoryUnder(int ageCategoryUnder) {
        this.ageCategoryUnder = ageCategoryUnder;
    }

    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "schoolName='" + schoolName + '\'' +
                ", ageCategoryUnder=" + ageCategoryUnder +
                '}';
    }
}
