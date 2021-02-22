package com.company;

import java.io.IOException;

public interface LeagueManager {

    void AddClub(FootballClub member);

    boolean DeleteClub(String clubName);

    void DisplayStatistics(String clubName);

    void DisplayPremierLeagueTable();

    void AddPlayedMatches();

    void DataSavingToAFile() throws IOException;

    PremierLeagueManager ReadFromTheFile() throws IOException, ClassNotFoundException;


}
