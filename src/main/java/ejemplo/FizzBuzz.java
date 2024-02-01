package ejemplo;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";

    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++){
            numbers.add(number(i));
        }
        return numbers;
    }

    private String number(int i){
        if (isMultiple(i, 3) && isMultiple(i, 5)){
            return FIZZ + BUZZ;
        } else if (isMultiple(i, 3)){
            return FIZZ;
        } else if (isMultiple(i, 5)){
            return BUZZ;
        } else
            return "" + i;
    }
    
    private boolean isMultiple(int number, int multiple){
        return number % multiple == 0;
    }
}
