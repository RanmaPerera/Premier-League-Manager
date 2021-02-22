package com.company;

import java.io.Serializable;
import java.util.Date;

public class MatchesPoints implements Serializable {
    private FootballClub clubA;
    private int scoresOfClubA;
    private FootballClub clubB;
    private int scoresOfClubB;
    private Date date;

    public FootballClub getClubA() {
        return clubA;
    }

    public void setClubA(FootballClub ClubA) {
        this.clubA = clubA;
    }

    public FootballClub getClubB() {
        return clubB;
    }

    public void setClubB(FootballClub ClubB) {
        this.clubB = clubB;
    }

    public int getScoresOfClubA() {
        return scoresOfClubA;
    }

    public void setScoresOfClubA(int scoresOfClubA) {
        this.scoresOfClubA = scoresOfClubA;
    }

    public int getScoresOfClubB() {
        return scoresOfClubB;
    }

    public void setScoresOfClubB(int scoresOfTClubB) {
        this.scoresOfClubB = scoresOfClubB;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MatchesPoints{" +
                "clubA=" + clubA +
                ", scoresOfClubA=" + scoresOfClubA +
                ", clubB=" + clubB +
                ", scoresOfClubB=" + scoresOfClubB +
                ", date=" + date +
                '}';
    }
}
