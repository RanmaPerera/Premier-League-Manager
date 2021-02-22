package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    @Test
    public void getTotalPoints() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(20,footballClub.getTotalPoints());
    }

    @Test
    public void getTotalReceivedGoals() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(20,footballClub.getTotalReceivedGoals());
    }

    @Test
    public void getTotalScoredGoals() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(30,footballClub.getTotalScoredGoals());
    }

    @Test
    public void getTotalNumberOfMatchesPlayed() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(50,footballClub.getTotalNumberOfMatchesPlayed());
    }

    @Test
    public void getWins() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(40,footballClub.getWins());
    }

    @Test
    public void getDefeats() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(6,footballClub.getDefeats());
    }

    @Test
    public void getDraws() {
        FootballClub footballClub = new FootballClub("liverpool","Stamford", 10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals(4,footballClub.getDraws());
    }


    @Test
    public void testToString() {
        FootballClub footballClub = new FootballClub("liverpool","Stanford",10, 20, 20, 30, 50, 40, 6, 4);
        assertEquals("FootballClub{totalPoints=20, totalReceivedGoals=20, totalScoredGoals=30, totalNumberOfMatchesPlayed=50, wins=40, defeats=6, draws=4}",footballClub.toString());
    }
}
