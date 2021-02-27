import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadAndCalculate_Test {

    @Test
    public void testdoCalculations(){
        ReadAndCalculate test=new ReadAndCalculate();

        String[] data1={"","4.5","5.6","6"};
        assertEquals(true,test.doCalculations(data1));
        String[] data2= {"","4.5","5.6"};
        assertEquals(false,test.doCalculations(data2));
        String[] data3={"","a","5.6","6"};
        assertEquals(false,test.doCalculations(data3));
        String[] data4={"","4.5","b","6"};
        assertEquals(false,test.doCalculations(data4));
        String[] data5={"","4.5","5.6","c"};
        assertEquals(false,test.doCalculations(data5));
        String[] data6={"","4.5","5.6","5.5"};
        assertEquals(false,test.doCalculations(data6));
        String[] data7={"","4.5","5.6","5",""};
        assertEquals(false,test.doCalculations(data7));

    }
}
