package TicTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage)
    {
        stage.setTitle("Tic-Tac-Toe");
        FlowPane root=new FlowPane(Orientation.VERTICAL,100,75);
        root.setAlignment(Pos.CENTER);
        Scene scene=new Scene(root,400,500);

        Image icon=new Image("icon.png");
        stage.getIcons().add(icon);

        Button a1=new Button("Start Game");
        a1.setPrefHeight(80);
        a1.setPrefWidth(150);
        a1.setFont(Font.font(18));
        a1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                Player p=new Player();
                p.player(stage);
            }
        });

        Button a2= new Button("Score");
        a2.setPrefHeight(80);
        a2.setPrefWidth(150);
        a2.setFont(Font.font(18));
        a2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                Score s=new Score();
                s.showScores(stage);
            }
        });

        root.getChildren().addAll(a1,a2);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
