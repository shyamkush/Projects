package TicTacToe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Score {

    final String driver="com.mysql.cj.jdbc.Driver";
    final String url="jdbc:mysql://localhost:3306/score";
    final String user="root";
    final String password="root123";

    public void addScore(String name1, String name2, int a, int b)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);

            Statement st1=(Statement)con.createStatement();
            Statement st2=(Statement)con.createStatement();

            ResultSet rs1=st1.executeQuery("select * from scores where name='"+name1+"'");
            ResultSet rs2=st2.executeQuery("select * from scores where name='"+name2+"'");

            String str1="insert into scores values('"+name1+"',"+a+","+b+")";
            String str2="insert into scores values('"+name2+"',"+b+","+a+")";
            
            if(!rs1.next())
            {
                st1.executeUpdate(str1);
            }
            else
            {
                String str3="update scores set win="+(rs1.getInt(2)+a)+", lose="+(rs1.getInt(3)+b)+" where name='"+name1+"'";
                st1.executeUpdate(str3);
            }
            if(!rs2.next())
            {
                st2.executeUpdate(str2);
            }
            else
            {
                String str4="update scores set win="+(rs2.getInt(2)+b)+", lose="+(rs2.getInt(3)+a)+" where name='"+name2+"'";
                st2.executeUpdate(str4);
            }
        }

        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }

        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void showScores(Stage stage)
    {
        stage.setTitle("Score");
        VBox root=new VBox(15);
        root.setAlignment(Pos.TOP_CENTER);
        
        Scene scene=new Scene(root,400,525);

        Button reset=new Button("Reset Scores");
        reset.setPrefHeight(40);
        reset.setPrefWidth(120);
        reset.setFont(Font.font(15));

        Button goback=new Button("Go Back");
        goback.setPrefHeight(30);
        goback.setPrefWidth(90);
        goback.setFont(Font.font(16));
        goback.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) 
            {
                Game g=new Game();
                g.start(stage);                
            }
        });

        TableView<ScoreValue> table=new TableView<>();

        TableColumn<ScoreValue, String> nameCol=new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<ScoreValue, Integer> winCol=new TableColumn<>("Win");
        winCol.setMinWidth(100);
        winCol.setCellValueFactory(new PropertyValueFactory<>("win"));

        TableColumn<ScoreValue, Integer> loseCol=new TableColumn<>("Lose");
        loseCol.setMinWidth(100);
        loseCol.setCellValueFactory(new PropertyValueFactory<>("lose"));

        ObservableList<ScoreValue> score=FXCollections.observableArrayList();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=(Statement)con.createStatement();
            Statement st1=(Statement)con.createStatement();
            
            reset.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae)
                {
                    try 
                    {
                        st1.executeUpdate("delete from scores");
                        showScores(stage);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

            ResultSet rs=st.executeQuery("select * from scores");
            while(rs.next())
            {
                score.add(new ScoreValue(rs.getString(1),rs.getInt(2),rs.getInt(3)));
            }
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        table.setItems(score);
        table.getColumns().addAll(Arrays.asList(nameCol,winCol,loseCol));

        root.getChildren().addAll(table,reset,goback);
        stage.setScene(scene);
        stage.show();
    }
}
