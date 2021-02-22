package com.company;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    static List<PremierLeagueManager> list = new ArrayList<PremierLeagueManager>();
    static LeagueManager leagueManager = new PremierLeagueManager() {
        @Override
        public boolean contains(String clubName) {
            return false;
        }
    };
    public static  int count = 0;
    public static PremierLeagueManager object01;

    public static void main(String[] args) throws IOException {

        PremierLeagueManager leagueManager = new PremierLeagueManager() {
            @Override
            public boolean contains(String clubName) {
                return false;
            }
        };
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nWelcome to Premier League!");
            System.out.println("~~GUIDE~~ \nAccording to the below options please choose as you prefer.");
            System.out.println("\tPlease enter 1 if you want to add a new club.");
            System.out.println("\tPlease enter 2 if you want to delete a club.");
            System.out.println("\tPlease enter 3 if you want to see some details and statistics of a selected club.");
            System.out.println("\tPlease enter 4 if you want to see the Premier League Table.");
            System.out.println("\tPlease enter 5 if you want to add a played match.");
            System.out.println("\tPlease enter 6 if you want to open the GUI of the system.");
            System.out.println("\tPlease enter 7 if you want to save information to a file.");
            System.out.println("\tPlease enter 8 if you want to exit the system.");
            System.out.print("Please enter your selection(Only the Number is required) : ");
            int guideSelection = input.nextInt();
            switch(guideSelection){
                case 1: //Adding Club to the system
                    System.out.println("\n\tPlease enter 'F' for define the club as a default football club.");
                    System.out.println("\tPlease enter 'S' for define the club as a school football club.");
                    System.out.println("\tPlease enter 'U' for define the club as a university football club.");
                    System.out.print("Please enter your selection(Only the Number is required) : ");
                    String selection = input.next();
                    if ("f".equalsIgnoreCase(selection)){
                        footballClub();
                    }else if ("s".equalsIgnoreCase(selection)){
                        schoolFootballClub();
                    }else if ("u".equalsIgnoreCase(selection)){
                        universityFootballClub();
                    }else {
                        System.out.println("Please check your input.");
                    }
                    break;
                case 2:
                    DeleteClub();
                    break;
                case 3:
                    DisplayStatistics();
                    break;
                case 4:
                    DisplayPremierLeagueTable();
                    break;
                case 5:
                    AddPlayedMatches();
                    break;
                case 6: //Opens the GUI
                    launch(args);
                    break;
                case 7:
                    leagueManager.DataSavingToAFile();
                    break;
                case 8:
                    System.out.println("\nExiting the System.");
                    System.out.println("\nThank you for joining with us!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    //Adding Clubs to the ArrayList as objects.
    private static void footballClub() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the club: ");
        String clubName = input.next();
        System.out.print("Please enter the location of the club: ");
        String clubLocation = input.next();
        System.out.print("Please enter the no of seasons played: ");
        int stats = input.nextInt();

        FootballClub footballClub = new com.company.FootballClub(clubName,clubLocation,stats);
        leagueManager.AddClub(footballClub);

    }

    private static void schoolFootballClub() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the club: ");
        String clubName = input.next();
        System.out.print("Please enter the location of the club: ");
        String clubLocation = input.next();
        System.out.print("Please enter the no of seasons played: ");
        int stats = input.nextInt();;
        System.out.print("Please enter the name of the school: ");
        String schoolName = input.next();
        System.out.print("Please enter the age category: ");
        int ageCategory = input.nextInt();

        SchoolFootballClub SclFootballClub = new SchoolFootballClub(clubName, clubLocation, stats, schoolName, ageCategory);
        leagueManager.AddClub(SclFootballClub);
    }

    private static void universityFootballClub() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the club: ");
        String clubName = input.next();
        System.out.print("Please enter the location of the club: ");
        String clubLocation = input.next();
        System.out.print("Please enter the no of seasons played: ");
        int stats = input.nextInt();;
        System.out.print("Please enter the name of the university: ");
        String uniName = input.next();
        System.out.print("Please enter the age category: ");
        int ageCategory = input.nextInt();

        UniversityFootballClub universityFootballClub = new UniversityFootballClub(clubName,clubLocation,stats,uniName,ageCategory);
        leagueManager.AddClub(universityFootballClub);
    }

    //Deleting a specific club by giving the club name.
    public static void DeleteClub(){
        System.out.println("\n~~Deleting a club from the System.~~");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your club name: ");
        String clubName;
        clubName = input.next();
        boolean result;
        result = leagueManager.DeleteClub(clubName);
        System.out.println("You have successfully deleted the club from the system.");
        if (result) {
            count--;
        }
    }

    public static void DisplayStatistics(){
        System.out.println("\n~~Displaying statistics of a selected club.~~");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your club name: ");
        String clubName = input.next();
        leagueManager.DisplayStatistics(clubName);
    }

    public static void DisplayPremierLeagueTable(){
        System.out.println("\n~~The Premier League Table.~~");
        leagueManager.DisplayPremierLeagueTable();
    }

    public static void AddPlayedMatches(){
        System.out.println("\n~~Adding New Played Match to the Premier League Manager.~~");
        leagueManager.AddPlayedMatches();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUIHomePage.guiHomePage();
    }

}
