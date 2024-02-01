import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        gameRules();

        ScoreBoard scoreBoard = new ScoreBoard();
        String choice = getChoice();

        while (!choice.equals("QUIT")) //do the following if the user does not put in "quit"
        {
            GameOption choiceNum = choiceNumber(choice);
            while(choiceNum == null)
            {
                System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                choice = getChoice();
                choiceNum = choiceNumber(choice);
            }
            GameOption compNum = getCompNum();
            logicGame(compNum, choiceNum, scoreBoard);
            choice = getChoice();
        }
    }

    private void score(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWin() + "\nloses:" + scoreBoard.getLoss() + "\nties:" + scoreBoard.getTie()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private void logicGame(GameOption compNum, GameOption choiceNum, ScoreBoard scoreBoard) {
        if(choiceNum == compNum){
            System.out.println("It's a tie");
            scoreBoard.incrementTie();
        } else if ((choiceNum == GameOption.ROCK && compNum == GameOption.SCISSORS )
            || (choiceNum == GameOption.SCISSORS && compNum == GameOption.PAPER )
            || (choiceNum == GameOption.PAPER && compNum == GameOption.ROCK))
            {
                System.out.println("you win!");
                scoreBoard.incrementWin();
            }
            else
            {
                System.out.println("you lose.");
                scoreBoard.incrementLoss();
            }
            score(scoreBoard);
    }

    private GameOption getCompNum() {
        GameOption option = GameOption.values()[(random.nextInt(3))];
        System.out.println("Computer chose " + option.toString().toLowerCase());
        return option;
    }

    private String getChoice() {
        String choice = input.nextLine().toUpperCase();
        return choice;
    }

    private void gameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private GameOption choiceNumber(String choice){
        GameOption choiceNum = null;
        if(choice.equals("QUIT"))
            System.exit(0);
        try{
            choiceNum = GameOption.valueOf(choice);
        } catch (Exception e) {
            return null;
        }
        return choiceNum;
    }
}