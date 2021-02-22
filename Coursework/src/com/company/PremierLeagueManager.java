package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class PremierLeagueManager implements LeagueManager, Serializable{
    public static List<FootballClub> clubData = new ArrayList<>();
    public static List<FootballClub> getClubData() {
        return clubData;
    }

    public static List<MatchesPoints> matchData = new ArrayList<>();
    public static List<MatchesPoints> getMatchData() {
        return matchData;
    }


    @Override
    public void AddClub(FootballClub member) {
        System.out.println("Number of Clubs: " + (1 + clubData.size()));
        System.out.println("Available space for new club: " + (19 - clubData.size()));
        if (clubData.size() < 20) {
            clubData.add(member);
        }else{
            System.out.println("20 clubs already registered. Try again in the next season!");
        }
    }

    @Override
    public boolean DeleteClub(String clubName) {
        boolean flag = false;
        for (FootballClub object01: clubData) {
            if (object01.getClubName().equals(clubName)){
                flag = true;
                clubData.remove(object01);
                System.out.println("Club with the Name of " + clubName + " is deleted successfully.");
                if (object01 instanceof SchoolFootballClub) {
                    System.out.println("Removed club is a School Football Club.");
                } else if (object01 instanceof UniversityFootballClub){
                    System.out.println("Removed club is a Unversity Football Club.");
                } else System.out.println("Removed club is a Football Club.");
                break;
            }
            if (!false)
                System.out.println("The club with " + clubName + " club name is not available in the sysytem or you may have have entered the club name incorrectly. Please try again.");
        }
        return flag;
    }

    @Override
    public void DisplayStatistics(String clubName) {
        for (FootballClub object01: clubData) {
            System.out.println("Club Name: " + object01.getClubName() + " ");
            if (object01 instanceof SchoolFootballClub) System.out.println("Club type: School Football Club.");
            else if (object01 instanceof UniversityFootballClub)
                System.out.println("Club type: University football Club.");
            else System.out.println("Club type: Football Club.");
            System.out.println("Wins: " + object01.getWins() + " ");
            System.out.println("Defeats: " + object01.getDefeats() + " ");
            System.out.println("Draws: " + object01.getDraws() + " ");
            System.out.println("Total points: " + object01.getTotalPoints() + " ");
            System.out.println("Total received goals: " + object01.getTotalReceivedGoals() + " ");
            System.out.println("Total scored goals: " + object01.getTotalScoredGoals() + " ");
            System.out.println("Total number of matches played: " + object01.getTotalNumberOfMatchesPlayed() + " ");
            return;
        }
    }

    @Override
    public void DisplayPremierLeagueTable() {
        Collections.sort(clubData, new StatisticsOrderingComparator());
        for (FootballClub object01: clubData){
            System.out.println("Club Name: " + object01.getClubName() + ", Total Points: " + object01.getTotalPoints() + ", Goals Difference: " + (object01.getTotalScoredGoals() - object01.getTotalReceivedGoals()) + ", Scored Goals: " + object01.getTotalScoredGoals() + ", Received Goals: " + object01.getTotalReceivedGoals() + ", Wins: " + object01.getWins() + ", Defeats: " + object01.getDefeats() + ", Draws: " + object01.getDraws());
        }
    }

    @Override
    public void AddPlayedMatches() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of the played match(Format mm-dd-yyyy): ");
        String input = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("mm-dd-yyyy").parse(String.valueOf(input));
        }catch (ParseException exception){
            System.out.println("You have to enter the date in mm-dd-yyyy format.");
            return;
        }
        System.out.println("Enter the club name of club who won the match: ");
        String inputWonClub = scanner.nextLine();
        FootballClub wonClub = null;
        for(FootballClub object01: clubData){
            if (object01.getClubName().equals(inputWonClub)){
                wonClub = object01;
            }
        }
        if (wonClub == null){
            System.out.println("Invalid club name entry.");
            return;
        }
        System.out.println("Enter the club name of club who loose the match: ");
        String inputLostClub = scanner.nextLine();
        FootballClub lostClub = null;
        for (FootballClub object01: clubData){
            if (object01.getClubName().equals(inputLostClub)){
                lostClub = object01;
            }
        }
        if (lostClub == null){
            System.out.println("Invalid club name entry.");
            return;
        }
        System.out.println("Enter the number of total goals of the won team: ");
        String inputWonClubGoals = scanner.nextLine();
        int totalWonTeamGoals = -1;
        try {
            totalWonTeamGoals = Integer.parseInt(String.valueOf(inputWonClubGoals));
        }catch (Exception exception){
        }
        if (totalWonTeamGoals == -1){
            System.out.println("You have enter the number of total goals of the wining team.");
            return;
        }
        System.out.println("Enter the number of total goals of the lost team: ");
        String inputLostClubGoals = scanner.nextLine();
        int totalLostTeamGoals = -1;
        try {
            totalLostTeamGoals = Integer.parseInt(String.valueOf(inputLostClubGoals));
        }catch (Exception exception){
        }
        if (totalLostTeamGoals == -1){
            System.out.println("You have enter the number of total goals of the lost team.");
            return;
        }
        MatchesPoints matchesPoints = new MatchesPoints();
        matchesPoints.setDate(date);
        matchesPoints.setClubA(wonClub);
        matchesPoints.setClubB(lostClub);
        matchesPoints.setScoresOfClubA(totalWonTeamGoals);
        matchesPoints.setScoresOfClubB(totalLostTeamGoals);
        matchData.add(matchesPoints);
        wonClub.setTotalScoredGoals(wonClub.getTotalScoredGoals() + totalWonTeamGoals);
        lostClub.setTotalScoredGoals(lostClub.getTotalScoredGoals() + totalLostTeamGoals);
        wonClub.setTotalReceivedGoals(wonClub.getTotalReceivedGoals() + totalLostTeamGoals);
        lostClub.setTotalReceivedGoals(lostClub.getTotalReceivedGoals() + totalWonTeamGoals);
        wonClub.setTotalNumberOfMatchesPlayed(wonClub.getTotalNumberOfMatchesPlayed() + 1);
        lostClub.setTotalNumberOfMatchesPlayed(lostClub.getTotalNumberOfMatchesPlayed() + 1);

        if (totalWonTeamGoals > totalLostTeamGoals) {
            wonClub.setTotalPoints(wonClub.getTotalPoints() + 3);
            wonClub.setWins(wonClub.getWins() + 1);
            lostClub.setDefeats(lostClub.getDefeats() + 1);
        } else if (totalWonTeamGoals < totalLostTeamGoals) {
            lostClub.setTotalPoints(lostClub.getTotalPoints() + 3);
            lostClub.setTotalPoints(lostClub.getWins() + 1);
            wonClub.setDefeats(wonClub.getDefeats() + 1);
        } else {
            wonClub.setTotalPoints(wonClub.getTotalPoints() + 1);
            lostClub.setTotalPoints(lostClub.getTotalPoints() + 1);
            wonClub.setDraws(wonClub.getDraws() + 1);
            lostClub.setDraws(lostClub.getDraws() + 1);
        }
    }

    @Override
    public void DataSavingToAFile() throws IOException {
        try{
            FileOutputStream fileWriter = new FileOutputStream("ClubData.ser");
            ObjectOutputStream clubDataOutput = new ObjectOutputStream(fileWriter);
            clubDataOutput.writeObject(Main.leagueManager);
            clubDataOutput.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }

    }

    @Override
    public PremierLeagueManager ReadFromTheFile() throws IOException, ClassNotFoundException {
        ArrayList<PremierLeagueManager> leagueManagerArray = new ArrayList<>();
        try{
            FileInputStream fileReader = new FileInputStream("ClubData.ser");
            ObjectInputStream clubDataInput = new ObjectInputStream(fileReader);
            PremierLeagueManager leagueManager = (PremierLeagueManager) clubDataInput.readObject();
            leagueManagerArray.add(leagueManager);
            clubDataInput.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return leagueManagerArray.get(0);
    }

    public abstract boolean contains(String clubName);
}
