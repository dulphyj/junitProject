public class ScoreBoard {

    private Integer tie;
    private Integer win;
    private Integer loss;


    public ScoreBoard(){
        tie = 0;
        win = 0;
        loss = 0;
    }

    public Integer getTie() {
        return tie;
    }
    public Integer getWin() {
        return win;
    }
    public Integer getLoss() {
        return loss;
    }
    
    public void incrementTie(){
        tie ++;
    }
    public void incrementWin(){
        win ++;
    }
    public void incrementLoss(){
        loss ++;
    }
}
