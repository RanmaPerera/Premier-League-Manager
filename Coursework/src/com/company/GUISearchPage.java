package com.company;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import static com.company.PremierLeagueManager.getMatchData;

public class GUISearchPage {
    public static void guiSearchPage() {

        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Search about team statistics.");

        TableView<MatchesPoints> searchResultsTableView;
        searchResultsTableView = new TableView();

        Font fontLabel = new Font("Franklin Gothic Demi", 18);
        Font fontButton = new Font("Dubai", 14);

        Image image = new Image("GUISearchPage.png");
        Pane pane = new StackPane();
        Scene scene = new Scene(pane, 1000, 600);

        ImageView GUISearchPage = new ImageView();
        GUISearchPage.setImage(image);
        GUISearchPage.setFitWidth(1000);
        GUISearchPage.setFitHeight(600);

        Label lblSearchFromDate = new Label(" Enter Date(mm-dd-yyyy):  ");
        lblSearchFromDate.setLayoutX(80);
        lblSearchFromDate.setLayoutY(60);
        lblSearchFromDate.setStyle("-fx-background-color: aqua");

        TextField txtMatchDate = new TextField("");
        txtMatchDate.setLayoutX(300);
        txtMatchDate.setLayoutY(60);
        txtMatchDate.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                txtMatchDate.getText();
            }
        });

        Button btnSearch = new Button(" Search ");
        btnSearch.setLayoutX(480);
        btnSearch.setLayoutY(60);
        btnSearch.setOnAction(event -> {
             String day = String.valueOf(Integer.parseInt(txtMatchDate.getText()));
             searchResultsTableView.setItems((ObservableList) getMatchData());
        });

        Stage resultsStage = new Stage();
        Pane resultsPane = new Pane();

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

        searchResultsTableView.getColumns().addAll(column01WonTeam, column02LostTeam, column03WonTeamScoredGoals, column04LostTeamScoredGoals, column05WonTeamReceivedGoals, column06LostTeamReceivedGoals, column07GoalDifference, column08MatchDate);
        searchResultsTableView.setMaxWidth(950);
        searchResultsTableView.setMaxHeight(520);
        searchResultsTableView.setId("SearchResultsTable");
        searchResultsTableView.setLayoutX(30);
        searchResultsTableView.setLayoutY(110);


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

        Pane branch = new Pane();
        branch.getChildren().add(GUISearchPage);
        branch.getChildren().add(btnSearch);
        branch.getChildren().add(btnBack);
        branch.getChildren().add(txtMatchDate);
        branch.getChildren().add(lblSearchFromDate);
        branch.getChildren().add(searchResultsTableView);

        btnSearch.setFont(fontButton);
        btnBack.setFont(fontButton);
        lblSearchFromDate.setFont(fontLabel);

        Stage GUI = new Stage();
        GUI.setTitle("Search about team statistics.");
        GUI.setScene(new Scene(branch, 1000, 600));
        GUI.show();

    }
}
