import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class Math_Test {


    @Test
    public void testPow(){
        Maths test=new Maths();
        assertEquals(25,test.pow(5,2),0);
        assertEquals(1.728,test.pow(1.2,3),0);
    }

    @Test
    public void testAbs(){
        Maths test=new Maths();
        assertEquals(1,test.abs(-1),0);
        assertEquals(1,test.abs(1),0);
    }

    @Test
    public void testcalculateMonthlyIntrestrate(){
        Maths test=new Maths();
        test.maths(1000,1,1);
        test.calculateMonthlyIntrestrate();
        assertEquals(1.0008295381143,test.getMinterest(),0.000001);
        test.maths(1000,2,2);
        test.calculateMonthlyIntrestrate();
        assertEquals(1.0016515813019,test.getMinterest(),0.000001);
    }
    @Test
    public void testcalculatePayement(){
        Maths test=new Maths();
        test.maths(1000,1,1);
        double value=Double.valueOf(test.calculatePayement().replace(",","."));
        assertEquals(83.78,value,3);
    }
}
