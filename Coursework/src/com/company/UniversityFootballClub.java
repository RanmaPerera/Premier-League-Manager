package com.company;

import java.io.Serializable;

public class UniversityFootballClub extends FootballClub implements Serializable {

    //Instance Variables
    private String universityName;
    private int ageCategoryUnder;

    //Default Constructor
    public UniversityFootballClub(String clubName, String clubLocation, int stats, int totalPoints, int totalReceivedGoals, int totalScoredGoals, int totalNumberOfMatchesPlayed, int wins, int defeats, int draws, String universityName, int ageCategoryUnder) {
        super(clubName, clubLocation, stats, totalPoints, totalReceivedGoals, totalScoredGoals, totalNumberOfMatchesPlayed, wins, defeats, draws);
        this.universityName = universityName;
        this.ageCategoryUnder = ageCategoryUnder;
    }

    //Args Constructor
    public UniversityFootballClub(String clubName, String clubLocation, int stats, String universityName, int ageCategoryUnder) {
        super(clubName, clubLocation, stats);
        this.universityName = universityName;
        this.ageCategoryUnder = ageCategoryUnder;
    }

    //Getter and Setter Methods

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getAgeCategoryUnder() {
        return ageCategoryUnder;
    }

    public void setAgeCategoryUnder(int ageCategoryUnder) {
        this.ageCategoryUnder = ageCategoryUnder;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "universityName='" + universityName + '\'' +
                ", ageCategoryUnder=" + ageCategoryUnder +
                '}';
    }
}
