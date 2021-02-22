package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

public class GUIPremierLeagueTable {
    public static void guiPremierLeagueTable() {

        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Premier League Table");

        Image image = new Image("GUIPremierLeagueTable.jpg");
        Pane pane = new StackPane();
        Scene scene = new Scene(pane, 800, 600);

        Font fontLabel = new Font("Franklin Gothic Demi", 30);
        Font fontButton = new Font("Dubai", 14);

        ImageView GUIPremierLeagueTable = new ImageView();
        GUIPremierLeagueTable.setImage(image);
        GUIPremierLeagueTable.setFitWidth(800);
        GUIPremierLeagueTable.setFitHeight(600);

        Label lblPLTable = new Label(" Premier League Table ");
        lblPLTable.setLayoutX(280);
        lblPLTable.setLayoutY(40);
        lblPLTable.setStyle("-fx-background-color: aqua");

        TableView PLTableView = new TableView();

        TableColumn column01ClubName = new TableColumn(" ClubName ");
        column01ClubName.setCellValueFactory(new PropertyValueFactory<>(" ClubName "));
        column01ClubName.setMinWidth(50);

        TableColumn column02Wins = new TableColumn(" Wins ");
        column02Wins.setCellValueFactory(new PropertyValueFactory<>(" Wins "));
        column02Wins.setMinWidth(50);

        TableColumn column03Defeats = new TableColumn(" Defeats ");
        column03Defeats.setCellValueFactory(new PropertyValueFactory<>(" Defeats"));
        column03Defeats.setMinWidth(50);

        TableColumn column04Draws = new TableColumn(" Draws ");
        column04Draws.setCellValueFactory(new PropertyValueFactory<>(" Draws"));
        column04Draws.setMinWidth(50);

        TableColumn column05TotalMatchesPlayed = new TableColumn(" TotalMatchesPlayed ");
        column05TotalMatchesPlayed.setCellValueFactory(new PropertyValueFactory<>(" TotalMatchesPlayed "));
        column05TotalMatchesPlayed.setMinWidth(130);

        TableColumn column06TotalPoints = new TableColumn(" TotalPoints ");
        column06TotalPoints.setCellValueFactory(new PropertyValueFactory<>(" TotalPoints "));
        column06TotalPoints.setMinWidth(90);

        TableColumn column07ScoredGoals = new TableColumn(" ScoredGoals ");
        column07ScoredGoals.setCellValueFactory(new PropertyValueFactory<>(" ScoredGoals "));
        column07ScoredGoals.setMinWidth(90);

        TableColumn column08ReceivedGoals = new TableColumn(" ReceivedGoals ");
        column08ReceivedGoals.setCellValueFactory(new PropertyValueFactory<>(" ReceivedGoals "));
        column08ReceivedGoals.setMinWidth(110);

        PLTableView.getColumns().addAll(column01ClubName, column02Wins, column03Defeats, column04Draws, column05TotalMatchesPlayed, column06TotalPoints, column07ScoredGoals, column08ReceivedGoals);
        PLTableView.setMaxWidth(740);
        PLTableView.setMaxHeight(520);
        PLTableView.setId("PLTable");
        PLTableView.setLayoutX(30);
        PLTableView.setLayoutY(110);

        Button btnBack = new Button(" Back ");
        btnBack.setLayoutX(670);
        btnBack.setLayoutY(535);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage calculators = (Stage) btnBack.getScene().getWindow();
                calculators.close();
                com.company.GUIHomePage.guiHomePage();
            }
        });

        PLTableView.setItems(PLTableInfo());

        Pane branch = new Pane();
        branch.getChildren().add(GUIPremierLeagueTable);
        branch.getChildren().add(lblPLTable);
        branch.getChildren().add(btnBack);
        branch.getChildren().add(PLTableView);

        btnBack.setFont(fontButton);
        lblPLTable.setFont(fontLabel);

        Stage GUI = new Stage();
        GUI.setTitle(" Welcome to Premier League Table! ");
        GUI.setScene(new Scene(branch, 800, 600));
        GUI.show();
    }

    public static ObservableList<FootballClub> PLTableInfo(){
        Path pathToGetData = Paths.get("./ClubData.ser");
        PremierLeagueManager leagueManager = new PremierLeagueManager() {
            @Override
            public boolean contains(String clubName) {
                return false;
            }
        };
        new PremierLeagueManager() {
            @Override
            public boolean contains(String clubName) {
                return false;
            }
        };
        if(Files.exists(pathToGetData)){
            try {
                leagueManager = leagueManager.ReadFromTheFile();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            leagueManager = new PremierLeagueManager() {
                @Override
                public boolean contains(String clubName) {
                    return false;
                }
            };
        }

        ObservableList<FootballClub> object01 = FXCollections.observableArrayList();
        for(FootballClub club: leagueManager.getClubData()){
            object01.add(club);
        }
        return object01;
    }
}
