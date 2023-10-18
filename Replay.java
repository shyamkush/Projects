package TicTacToe;

import javafx.stage.Stage;

public class Replay {
    public void Re(Stage stage, String name1,String name2)
    {
        TTT t=new TTT(name1,name2);
        t.grid(stage);
    }
}
