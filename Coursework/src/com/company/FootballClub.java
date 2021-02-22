package com.company;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {

    //Instance Variables
    private int totalPoints;
    private int totalReceivedGoals;
    private int totalScoredGoals;
    private int totalNumberOfMatchesPlayed;
    private int wins;
    private int defeats;
    private int draws;

    //Default Constructor
    public FootballClub(String clubName, String clubLocation, int stats, int totalPoints, int totalReceivedGoals, int totalScoredGoals, int totalNumberOfMatchesPlayed, int wins, int defeats, int draws) {
        super(clubName, clubLocation, stats);
        this.totalPoints = totalPoints;
        this.totalReceivedGoals = totalReceivedGoals;
        this.totalScoredGoals = totalScoredGoals;
        this.totalNumberOfMatchesPlayed = totalNumberOfMatchesPlayed;
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
    }

    //Args Constructor
    public FootballClub(String clubName, String clubLocation, int stats) {
        super(clubName,clubLocation,stats);
    }

    //Getter and Setter Methods
    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int i) {
        this.totalPoints = i;
    }

    public int getTotalReceivedGoals() {
        return totalReceivedGoals;
    }

    public void setTotalReceivedGoals(int i) {
        this.totalReceivedGoals = i;
    }

    public int getTotalScoredGoals() {
        return totalScoredGoals;
    }

    public void setTotalScoredGoals(int i) {
        this.totalScoredGoals = i;
    }

    public int getTotalNumberOfMatchesPlayed() {
        return totalNumberOfMatchesPlayed;
    }

    public void setTotalNumberOfMatchesPlayed(int i) { this.totalNumberOfMatchesPlayed = i; }

    public int getWins() {
        return wins;
    }

    public void setWins(int i) {
        this.wins = i;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int i) {
        this.defeats = i;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int i) {
        this.draws = i;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "totalPoints=" + totalPoints +
                ", totalReceivedGoals=" + totalReceivedGoals +
                ", totalScoredGoals=" + totalScoredGoals +
                ", totalNumberOfMatchesPlayed=" + totalNumberOfMatchesPlayed +
                ", wins=" + wins +
                ", defeats=" + defeats +
                ", draws=" + draws +
                '}';
    }
}
