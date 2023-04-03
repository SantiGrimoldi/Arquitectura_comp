package Tests;
import TP1.Calculator_api;
import org.junit.Assert;
import org.junit.Test;


public class SumTest {

    Calculator_api api = new Calculator_api();


    @Test
    public void testFillMethod(){
        String a = "10";
        String b = "10110000";
        //Assert.assertEquals("00001100", api.fill(a));
    }

    @Test
    public void testSumMethod(){
        String a = "0011101";
        String b = "1101011";

        Assert.assertEquals("10001000", api.sum(a, b));
    }

    @Test
    public void testMulMethod(){
        String a = "10110100";
        String b = "1011001";

        Assert.assertEquals("11111010010100", api.mult(a, b));
    }
}
