package TicTacToe;

public class ScoreValue {
    private String name;
    private int win,lose;
    public ScoreValue()
    {
        name="";
        win=0;
        lose=0;
    }
    public ScoreValue(String name,int win,int lose) 
    {
        this.name=name;
        this.win=win;
        this.lose=lose;    
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getWin()
    {
        return win;
    }
    public void setWin(int win)
    {
        this.win=win;
    }
    public int getLose()
    {
        return lose;
    }
    public void setLose(int lose)
    {
        this.lose=lose;
    }
}
