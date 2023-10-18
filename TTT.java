package TicTacToe;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TTT {
    
    int count=0, a[][]=new int[3][3]; 
    boolean f=false;
    String name1="",name2="";

    TTT(String name1,String name2)
    {
        this.name1=name1;
        this.name2=name2;
    }

    void grid(Stage stage)
    {
        VBox root=new VBox(20);
        root.setAlignment(Pos.CENTER);
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        StackPane stackPane=new StackPane();

        Label l=new Label();
        l.setFont(Font.font(50));
        l.setText("Player X's Turn");
        
        Button b1=new Button();
        b1.setPrefHeight(100);
        b1.setPrefWidth(100);
        b1.setBackground(null);
        b1.setFont(Font.font(45));
        b1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b1.getText().length()<=0&&!f)
                {
                    ButtonActivity(0, 0, b1, stackPane, l, root);
                }
            }
        });
        gridPane.add(b1, 0, 0);
        
        Button b2=new Button();
        b2.setPrefHeight(100);
        b2.setPrefWidth(100);
        b2.setBackground(null);
        b2.setFont(Font.font(45));
        b2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b2.getText().length()<=0&&!f)
                {
                    ButtonActivity(0, 1, b2, stackPane, l, root);
                }
            }
        });
        gridPane.add(b2, 1, 0);

        Button b3=new Button();
        b3.setPrefHeight(100);
        b3.setPrefWidth(100);
        b3.setBackground(null);
        b3.setFont(Font.font(45));
        b3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b3.getText().length()<=0&&!f)
                {
                    ButtonActivity(0, 2, b3, stackPane, l, root);
                }
            }
        });
        gridPane.add(b3, 2, 0);

        Button b4=new Button();
        b4.setPrefHeight(100);
        b4.setPrefWidth(100);
        b4.setBackground(null);
        b4.setFont(Font.font(45));
        b4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b4.getText().length()<=0&&!f)
                {
                    ButtonActivity(1, 0, b4, stackPane, l, root);
                }
            }
        });
        gridPane.add(b4, 0, 1);

        Button b5=new Button();
        b5.setPrefHeight(100);
        b5.setPrefWidth(100);
        b5.setBackground(null);
        b5.setFont(Font.font(45));
        b5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b5.getText().length()<=0&&!f)
                {
                    ButtonActivity(1, 1, b5, stackPane, l, root);
                }
            }
        });
        gridPane.add(b5, 1, 1);

        Button b6=new Button();
        b6.setPrefHeight(100);
        b6.setPrefWidth(100);
        b6.setBackground(null);
        b6.setFont(Font.font(45));
        b6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b6.getText().length()<=0&&!f)
                {
                    ButtonActivity(1, 2, b6, stackPane, l, root);
                }
            }
        });
        gridPane.add(b6, 2, 1);

        Button b7=new Button();
        b7.setPrefHeight(100);
        b7.setPrefWidth(100);
        b7.setBackground(null);
        b7.setFont(Font.font(45));
        b7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b7.getText().length()<=0&&!f)
                {
                    ButtonActivity(2, 0, b7, stackPane, l, root);
                }
            }
        });
        gridPane.add(b7, 0, 2);

        Button b8=new Button();
        b8.setPrefHeight(100);
        b8.setPrefWidth(100);
        b8.setBackground(null);
        b8.setFont(Font.font(45));
        b8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b8.getText().length()<=0&&!f)
                {
                    ButtonActivity(2, 1, b8, stackPane, l, root);
                }
            }
        });
        gridPane.add(b8, 1, 2);

        Button b9=new Button();
        b9.setPrefHeight(100);
        b9.setPrefWidth(100);
        b9.setBackground(null);
        b9.setFont(Font.font(45));
        b9.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                if(b9.getText().length()<=0&&!f)
                {
                    ButtonActivity(2, 2, b9, stackPane, l, root);
                }
            }
        });
        gridPane.add(b9, 2, 2);

        Button go_back=new Button("Go Back");
        go_back.setPrefHeight(30);
        go_back.setPrefWidth(90);
        go_back.setFont(Font.font(16));
        go_back.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Player p=new Player();
                p.player(stage);
            }
        });

        Button go_home=new Button("Go Home");
        go_home.setPrefHeight(30);
        go_home.setPrefWidth(90);
        go_home.setFont(Font.font(16));
        go_home.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Game g=new Game();
                g.start(stage);
            }
        });
        
        Button replay=new Button("Replay");
        replay.setPrefHeight(30);
        replay.setPrefWidth(90);
        replay.setFont(Font.font(16));
        replay.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent arg0) {
                Replay r=new Replay();
                r.Re(stage,name1,name2);
            }
        });

        Line l1=new Line(100,0,100,300);
        l1.setTranslateX(-50);
        l1.setStrokeWidth(3);

        Line l2=new Line(100,0,100,300);
        l2.setTranslateX(50);
        l2.setStrokeWidth(3);

        Line l3=new Line(0,0,300,0);
        l3.setTranslateY(50);
        l3.setStrokeWidth(3);

        Line l4=new Line(0,300,300,300);
        l4.setTranslateY(-50);
        l4.setStrokeWidth(3);

        stackPane.getChildren().addAll(gridPane,l1,l2,l3,l4);
        root.getChildren().addAll(l,stackPane,go_home,go_back,replay);
        Scene scene=new Scene(root,600,600);
        stage.setScene(scene);
    }

    public void ButtonActivity(int r,int c,Button b, StackPane stackPane, Label l, VBox root)
    {
        count++;
        a[r][c]=count%2+1;
        Btext(count%2+1,b);
        f=check(stackPane,l,root);
        if(!f)
            Ltext(count%2+1,l);
    }

    public void Btext(int c, Button b)
    {
        if(c==2)
        {
            b.setText("X");
        }
        else
        {
            b.setText("O");
        }
    }
    public void Ltext(int c, Label l)
    {
        if(c==2)
        {
            l.setText("Player O's Turn");
        }
        else
        {
            l.setText("Player X's Turn");
        }
    }

    public boolean check(StackPane stackPane,Label l,VBox root)
    {
        Line line=new Line();
        line.setStartX(0);
        line.setStartY(0);
        int c=0;
        if(a[0][0]==a[0][1]&&a[0][1]==a[0][2]&&(a[0][2]==1||a[0][2]==2))
        {
            line.setEndX(300);
            line.setEndY(0);
            line.setTranslateY(-100);
            c=a[0][0];
        }
        else if(a[1][0]==a[1][1]&&a[1][1]==a[1][2]&&(a[1][2]==1||a[1][2]==2))
        {
            line.setEndX(300);
            line.setEndY(0);
            c=a[1][0];
        }
        else if(a[2][0]==a[2][1]&&a[2][1]==a[2][2]&&(a[2][2]==1||a[2][2]==2))
        {
            line.setEndX(300);
            line.setEndY(0);
            line.setTranslateY(100);
            c=a[2][0];
        }
        else if(a[0][0]==a[1][0]&&a[1][0]==a[2][0]&&(a[1][0]==1||a[1][0]==2))
        {
            line.setEndX(0);
            line.setEndY(300);
            line.setTranslateX(-100);
            c=a[1][0];
        }
        else if(a[0][1]==a[1][1]&&a[1][1]==a[2][1]&&(a[1][1]==1||a[1][1]==2))
        {
            line.setEndX(0);
            line.setEndY(300);
            c=a[1][1];
        }
        else if(a[0][2]==a[1][2]&&a[1][2]==a[2][2]&&(a[1][2]==1||a[1][2]==2))
        {
            line.setEndX(0);
            line.setEndY(300);
            line.setTranslateX(100);
            c=a[1][2];
        }
        else if(a[0][0]==a[1][1]&&a[1][1]==a[2][2]&&(a[1][1]==1||a[1][1]==2))
        {
            line.setEndX(0);
            line.setEndY(375);
            line.setRotate(-45);
            c=a[1][1];
        }
        else if(a[0][2]==a[1][1]&&a[1][1]==a[2][0]&&(a[1][1]==1||a[1][1]==2))
        {
            line.setEndX(0);
            line.setEndY(375);
            line.setRotate(45);
            c=a[1][1];
        }
        else
        {
            if(count==9)
            {
                l.setText("It's a Draw!!!");
                Score s=new Score();
                s.addScore(name1, name2, 0, 0);
                return true;
            }
            return false;
        }
        if(c==1)
        {
            l.setText("Player O won");
            Score s=new Score();
            s.addScore(name1, name2, 0, 1);
        }
        else
        {
            l.setText("Player X won");
            Score s=new Score();
            s.addScore(name1, name2, 1, 0);
        }
        stackPane.getChildren().add(line);
        return true;
    }
}