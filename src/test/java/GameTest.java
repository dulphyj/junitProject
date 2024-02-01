import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private static final int OPTIONS = 3;

    private static final int OPTION_SCISSORS = 2;

    private static final int OPTION_PAPER = 1;

    private static final int OPTION_ROCK = 0;

    private ByteArrayOutputStream out;

    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Mock
    Random random;


    @Before
    public void setUp(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }
    
    @Test
    public void whenWriteQuiteThenExitGame(){
        //Mock no funcionaba en clases "final", se debia crear un archivo org.mockito.plugins.MockMaker
        when(scanner.nextLine()).thenReturn("Quit");
        game.play();
        Assert.assertTrue(out.toString().contains("Let's play Rock, Paper, Scissors!"));
    }

    @Test
    public void whenChooseRockThenBeatsScissors(){
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(OPTIONS)).thenReturn(OPTION_SCISSORS);
        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("you win!"));
    }

    @Test
    public void whenChooseScissorsThenBeatsPaper(){
        when(scanner.nextLine()).thenReturn("Scissors").thenReturn("Quit");
        when(random.nextInt(OPTIONS)).thenReturn(OPTION_PAPER);
        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("you win!"));
    }

    @Test
    public void whenChoosePaperThenBeatsRock(){
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("Quit");
        when(random.nextInt(OPTIONS)).thenReturn(OPTION_ROCK);
        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("you win!"));
    }

    @Test
    public void whenBothChoosePaperThenTie(){
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("Quit");
        when(random.nextInt(OPTIONS)).thenReturn(OPTION_PAPER);
        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("It's a tie"));
    }

    @Test
    public void whenChoosePaperThenLoseScissors(){
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("quit");
        when(random.nextInt(OPTIONS)).thenReturn(OPTION_SCISSORS);
        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("you lose."));
    }
}
