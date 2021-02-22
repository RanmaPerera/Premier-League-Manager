package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.Main.object01;

public class GUIRandomStatPage {
    public static void guiRandomStatPage() {
        //PremierLeagueManager object = new PremierLeagueManager();
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Random PL Team Statistics Viewer.");

        Image image = new Image("GUIRandomPage.jpg");
        Pane pane = new StackPane();
        Scene scene = new Scene(pane, 1200, 600);

        Font fontLabel = new Font("Franklin Gothic Demi", 18);
        Font fontButton = new Font("Dubai", 14);

        ImageView GUIRandomPage = new ImageView();
        GUIRandomPage.setImage(image);
        GUIRandomPage.setFitWidth(1000);
        GUIRandomPage.setFitHeight(600);

        Button btnRandomGenerator = new Button(" Generator ");
        btnRandomGenerator.setLayoutX(490);
        btnRandomGenerator.setLayoutY(50);
        btnRandomGenerator.setOnAction(new EventHandler<ActionEvent>() {
            PremierLeagueManager Manager = object01;
            public void handle(ActionEvent event) {
                int clubA = ThreadLocalRandom.current().nextInt(0, Manager.getClubData().size());
                int clubB = ThreadLocalRandom.current().nextInt(0, Manager.getClubData().size());
                int scoresOfCluba = ThreadLocalRandom.current().nextInt(0, 6);
                int scoresOfClubB = ThreadLocalRandom.current().nextInt(0, 6);
                int date = ThreadLocalRandom.current().nextInt();

                while(clubA==clubB){
                    clubB = ThreadLocalRandom.current().nextInt(0, Manager.getClubData().size());
                }
//                Manager.AddPlayedMatches(
//                        Manager.getClubData().get(clubA).getClubName(),Manager.getClubData().get(clubB).getClubName(),scoresOfCluba,scoresOfClubB,date);
//                Manager.DataSavingToAFile(Manager);

                Alert alert = new Alert(Alert.AlertType.NONE,"Random Generated Match Results already Added", ButtonType.OK);
                alert.show();
            }

        });

        Label lblRandomResultsHeading = new Label(" The Random Results will be displayed here as a table. Press the Genarator botton for it. ");
        lblRandomResultsHeading.setLayoutX(280);
        lblRandomResultsHeading.setLayoutY(30);
        lblRandomResultsHeading.setStyle("-fx-background-color: aqua");

        TableView randomResultsTableView = new TableView();

        TableColumn column01WonTeam = new TableColumn(" WonTeam ");
        column01WonTeam.setCellValueFactory(new PropertyValueFactory<>(" WonTeam "));
        column01WonTeam.setMinWidth(50);

        TableColumn column02LostTeam = new TableColumn(" LostTeam ");
        column02LostTeam.setCellValueFactory(new PropertyValueFactory<>(" LostTeam "));
        column02LostTeam.setMinWidth(50);

        TableColumn column03WonTeamScoredGoals = new TableColumn(" WonTeamScoredGoals ");
        column03WonTeamScoredGoals.setCellValueFactory(new PropertyValueFactory<>(" WonTeamScoredGoals "));
        column03WonTeamScoredGoals.setMinWidth(150);

        TableColumn column04LostTeamScoredGoals = new TableColumn(" LostTeamScoredGoals ");
        column04LostTeamScoredGoals.setCellValueFactory(new PropertyValueFactory<>(" LostTeamScoredGoals "));
        column04LostTeamScoredGoals.setMinWidth(150);

        TableColumn column05WonTeamReceivedGoals = new TableColumn(" WonTeamReceivedGoals ");
        column05WonTeamReceivedGoals.setCellValueFactory(new PropertyValueFactory<>(" WonTeamReceivedGoals "));
        column05WonTeamReceivedGoals.setMinWidth(150);

        TableColumn column06LostTeamReceivedGoals = new TableColumn(" LostTeamReceivedGoals ");
        column06LostTeamReceivedGoals.setCellValueFactory(new PropertyValueFactory<>(" LostTeamReceivedGoals "));
        column06LostTeamReceivedGoals.setMinWidth(150);

        TableColumn column07GoalDifference = new TableColumn(" GoalDifference ");
        column07GoalDifference.setCellValueFactory(new PropertyValueFactory<>(" GoalDifference "));
        column07GoalDifference.setMinWidth(100);

        TableColumn column08MatchDate = new TableColumn(" MatchDate ");
        column08MatchDate.setCellValueFactory(new PropertyValueFactory<>(" MatchDate "));
        column08MatchDate.setMinWidth(50);

        randomResultsTableView.getColumns().addAll(column01WonTeam, column02LostTeam, column03WonTeamScoredGoals, column04LostTeamScoredGoals, column05WonTeamReceivedGoals, column06LostTeamReceivedGoals, column07GoalDifference, column08MatchDate);
        randomResultsTableView.setMaxWidth(950);
        randomResultsTableView.setMaxHeight(520);
        randomResultsTableView.setId("RandomResultsTable");
        randomResultsTableView.setLayoutX(30);
        randomResultsTableView.setLayoutY(110);


        Button btnBack = new Button(" Back ");
        btnBack.setLayoutX(760);
        btnBack.setLayoutY(535);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage calculators = (Stage) btnBack.getScene().getWindow();
                calculators.close();
                com.company.GUIHomePage.guiHomePage();
            }
        });

        Stage randomResultsStage = new Stage();
        Pane randomResultsPane = new Pane();


        Pane branch = new Pane();
        branch.getChildren().add(GUIRandomPage);
        branch.getChildren().add(btnBack);
        branch.getChildren().add(lblRandomResultsHeading);
        branch.getChildren().add(randomResultsTableView);
        branch.getChildren().add(btnRandomGenerator);

        btnBack.setFont(fontButton);
        btnRandomGenerator.setFont(fontButton);

        Stage GUI = new Stage();
        GUI.setTitle("Random PL Team Statistics Viewer.");
        GUI.setScene(new Scene(branch, 1000, 600));
        GUI.show();
    }
}
