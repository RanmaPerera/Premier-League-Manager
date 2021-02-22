package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolFootballClubTest {

    @Test
    public void getSchoolName() {
        SchoolFootballClub schoolFootballClub = new SchoolFootballClub("liverpool","Stanford",10, "HFC", 15);
        assertEquals("HFC",schoolFootballClub.getSchoolName());
    }

    @Test
    public void getAgeCategoryUnder() {
        SchoolFootballClub schoolFootballClub = new SchoolFootballClub("liverpool","Stanford",10, "HFC", 15);
        assertEquals(15,schoolFootballClub.getAgeCategoryUnder());
    }

    @Test
    public void testToString() {
        SchoolFootballClub schoolFootballClub = new SchoolFootballClub("liverpool","Stanford",10, "HFC", 15);
        assertEquals("SchoolFootballClub{schoolName='HFC', ageCategoryUnder=15}",schoolFootballClub.toString());
    }
}