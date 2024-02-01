package ejemplo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";
    private FizzBuzz game;

    @Before
    public void before(){
        game = new FizzBuzz();
    }
    
    @Test
    public void shouldReturnNumbersWhenNotAMultipleOf3Or5(){
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals("1", numbersList.get(0));
        Assert.assertEquals("2", numbersList.get(1));
        Assert.assertEquals("4", numbersList.get(3));
        Assert.assertEquals("7", numbersList.get(6));
    }

    @Test
    public void shouldReturnFizzWhenAMultipleOf3(){
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ, numbersList.get(2));
        Assert.assertEquals(FIZZ, numbersList.get(5));
        Assert.assertEquals(FIZZ, numbersList.get(8));
        Assert.assertEquals(FIZZ, numbersList.get(11));
    }

    @Test
    public void shouldReturnBuzzWhenAMultipleOf5(){
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(BUZZ, numbersList.get(4));
        Assert.assertEquals(BUZZ, numbersList.get(9));
        Assert.assertEquals(BUZZ, numbersList.get(19));
    }

    @Test
    public void shouldReturnFizzBuzzWhenAMultipleOf3And5(){
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(14));
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(29));
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(44));
    }
}
