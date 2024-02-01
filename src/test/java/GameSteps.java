import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameSteps {
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
        MockitoAnnotations.initMocks(this);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    
    @Given("the user will choose {string}")
    public void theUserWillChoose(String userSelection){
        when(scanner.nextLine()).thenReturn(userSelection).thenReturn("Quit");
    }

    @Given("the computer will choose {string}")
    public void the_computer_will_choose(String computerSelection) {
        int option;
        if ("Rock".equals(computerSelection)){
            option = OPTION_ROCK;
        } else if ("Paper".equals(computerSelection)){
            option = OPTION_PAPER;
        } else {
            option = OPTION_SCISSORS;
        }
        when(random.nextInt(OPTIONS)).thenReturn(option);
    }

    @When("they play")
    public void they_play() {
        game.play();
    }

    @Then("verify that the computer chose {string}")
    public void verifyThatTheComputerChose(String computerSelection) {
        Assert.assertTrue(out.toString().contains("Computer chose " + computerSelection));
    }

    @Then("the user wins")
    public void the_user_wins() {
        Assert.assertTrue(out.toString().contains("you win!"));
    }

    @And("the user lose")
    public void theUserLose() {
        Assert.assertTrue(out.toString().contains("you lose."));
    }

    @And("the user tie")
    public void theUserTie() {
        Assert.assertTrue(out.toString().contains("It's a tie"));
    }
}
