package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public abstract class GUIHomePage extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public static void guiHomePage() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Welcome to the Home Page.");

        Image image = new Image("GUIHomepage.jpg");
        Pane pane = new StackPane();
        Scene scene = new Scene(pane, 600, 550);

        ImageView guiHomePage = new ImageView();
        guiHomePage.setImage(image);
        guiHomePage.setFitWidth(550);
        guiHomePage.setFitHeight(480);

        Font fontLabel = new Font("Franklin Gothic Demi", 30);
        Font fontButton = new Font("Dubai", 14);

        Label lblWelcomeNote = new Label(" Premier League Manager! ");
        lblWelcomeNote.setLayoutX(80);
        lblWelcomeNote.setLayoutY(10);
        lblWelcomeNote.setStyle("-fx-background-color: aqua");

        Button btnSearch = new Button(" Search Teams ");
        btnSearch.setLayoutX(120);
        btnSearch.setLayoutY(180);
        btnSearch.setOnAction(e -> {
                    primaryStage.close();
                    GUISearchPage.guiSearchPage();
                }
        );

        Button btnRandomStat = new Button(" Random View ");
        btnRandomStat.setLayoutX(280);
        btnRandomStat.setLayoutY(180);
        btnRandomStat.setOnAction(e -> {
                    primaryStage.close();
                    GUIRandomStatPage.guiRandomStatPage();
                }
        );

        Button btnPremierLeagueTable = new Button(" Premier League Table ");
        btnPremierLeagueTable.setLayoutX(120);
        btnPremierLeagueTable.setLayoutY(300);
        btnPremierLeagueTable.setOnAction(e -> {
                    primaryStage.close();
                    GUIPremierLeagueTable.guiPremierLeagueTable();
                }
        );

        Button btnExit = new Button(" Exit ");
        btnExit.setLayoutX(340);
        btnExit.setLayoutY(300);

        //Exit Button Functionality.
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        });

        Pane root = new Pane();
        root.getChildren().add(guiHomePage);
        root.getChildren().add(lblWelcomeNote);
        root.getChildren().add(btnPremierLeagueTable);
        root.getChildren().add(btnSearch);
        root.getChildren().add(btnRandomStat);
        root.getChildren().add(btnExit);

        btnPremierLeagueTable.setFont(fontButton);
        btnSearch.setFont(fontButton);
        btnRandomStat.setFont(fontButton);
        btnExit.setFont(fontButton);
        lblWelcomeNote.setFont(fontLabel);

        primaryStage.setTitle("Welcome to the Home Page.");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();


    }

}
