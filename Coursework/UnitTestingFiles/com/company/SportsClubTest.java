package com.company;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class SportsClubTest {

    @Test
    public void getClubName() {
        SportsClub sportsClub = new SportsClub("liverpool","Stanford",10);
        assertEquals("liverpool",sportsClub.getClubName());
    }

    @Test
    public void getClubLocation() {
        SportsClub sportsClub = new SportsClub("liverpool","Stanford",10);
        assertEquals("Stanford",sportsClub.getClubLocation());
    }

    @Test
    public void getStats() {
        SportsClub sportsClub = new SportsClub("liverpool","Stanford",10);
        assertEquals(10,sportsClub.getStats());
    }

    @Test
    public void testToString() {
        SportsClub sportsClub = new SportsClub("liverpool","Stanford",10);
        assertEquals("SportsClub{clubName='liverpool', clubLocation='Stanford', stats=10}",sportsClub.toString());
    }
}