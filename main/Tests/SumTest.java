package Tests;
import TP1.Calculator_api;
import org.junit.Assert;
import org.junit.Test;


public class SumTest {

    Calculator_api api = new Calculator_api();


    @Test
    public void testFillMethod(){
        String a = "101110";
        String b = "10110000";

        Assert.assertEquals("00001100", api.fill(a));
    }


    @Test
    public void testSumMethod(){
        String a = "101110";
        String b = "10110000";

        Assert.assertEquals("11011110", api.sumGuardiola(a, b));
    }
}
