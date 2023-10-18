package TicTacToe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Player {
    public void player(Stage stage)
    {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);

        Label l1=new Label("Player1 :");
        l1.setFont(Font.font(18));
        TextField tf1=new TextField();
        root.add(l1, 0, 0);
        root.add(tf1, 1, 0);
        
        Label l2=new Label("Player2 :");
        l2.setFont(Font.font(18));
        TextField tf2=new TextField();
        root.add(l2, 0, 1);
        root.add(tf2, 1, 1);

        Button b1= new Button("Go Back");
        b1.setPrefHeight(10);
        b1.setPrefWidth(70);
        b1.setFont(Font.font(13));
        b1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                Game obj=new Game();
                obj.start(stage);
            }
        });

        Button b2= new Button("Play");
        b2.setPrefHeight(10);
        b2.setPrefWidth(70);
        b2.setFont(Font.font(13));
        b2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(tf1.getText().length()>0&&tf2.getText().length()>0)
                {
                    TTT t=new TTT(tf1.getText(),tf2.getText());
                    t.grid(stage);
                }
            }
        });

        root.add(b1, 1, 2);
        root.add(b2, 2, 2);
        Scene scene=new Scene(root,400,300);
        stage.setScene(scene);
    }
}
