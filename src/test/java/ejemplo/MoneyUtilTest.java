package ejemplo;
import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilTest {

    @Test
    public void moneyTest(){
        String money = MoneyUtil.format(1000);
        Assert.assertEquals("$1000.00", money);
    }

    @Test
    public void roundedDecimalMoneyTest(){
        String money = MoneyUtil.format(1000.149);
        Assert.assertEquals("$1000.15", money);
    }

    @Test
    public void negativeMoneyTest(){
        String money = MoneyUtil.format(-1000);
        Assert.assertEquals("-$1000.00", money);
    }

    @Test (expected = IllegalArgumentException.class)
    public void notNullExceptionMoneyTest(){
        MoneyUtil.format(null,-1000);
    }
}
