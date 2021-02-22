package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    @Test
    public void getUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("liverpool","Stanford",10 , "UGC", 25);
        assertEquals("UGC",universityFootballClub.getUniversityName());
    }

    @Test
    public void getAgeCategoryUnder() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("liverpool","Stanford",10 , "UGC", 25);
        assertEquals(25,universityFootballClub.getAgeCategoryUnder());
    }

    @Test
    public void testToString() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("liverpool","Stanford",10 , "UGC", 25);
        assertEquals("UniversityFootballClub{universityName='UGC', ageCategoryUnder=25}",universityFootballClub.toString());
    }

}