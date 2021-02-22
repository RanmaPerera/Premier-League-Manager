package com.company;

import java.io.Serializable;

public class SportsClub implements Serializable {

    //Instance Variables
    private String clubName;
    private String clubLocation;
    private int stats;

    //Default Constructor
    public SportsClub(String clubName, String clubLocation, int statistics) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.stats = statistics;
    }

    @Override
    public boolean equals (Object object01){
        return this.clubName.equals(((SportsClub) object01).clubName);
    }

    //Getter and Setter Methods

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String s) {
        this.clubName = s;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String s) {
        this.clubLocation = s;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                ", stats=" + stats +
                '}';
    }

}
