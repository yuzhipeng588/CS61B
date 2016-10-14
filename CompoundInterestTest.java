import static org.junit.Assert.*;
import org.junit.Test;

public class CompoundInterestTest {

    @Test
    public void testNumYears() {
//Zhipeng
        assertEquals(10,CompoundInterest.numYears(2026) );
        assertEquals(0,CompoundInterest.numYears(2016) );
        assertEquals(-1,CompoundInterest.numYears(2015) );
//Zhipeng
        /** Sample assert statement for comparing integers.

        assertEquals(0, 0); */
    }

    @Test
    public void testFutureValue() {
        double tolerance = 0.01;
//Zhipeng
        assertEquals(75.937,CompoundInterest.futureValue(10, 50,2020) ,tolerance);
        assertEquals(10,CompoundInterest.futureValue(10, 50,2015) ,tolerance);
//Zhipeng
    }

    @Test
    public void testFutureValueReal() {
        double tolerance = 0.01;
//Zhipeng
        assertEquals(58.758,CompoundInterest.futureValueReal(10, 50,2020,5) ,tolerance);
        assertEquals(10,CompoundInterest.futureValueReal(10, 50,2015,5) ,tolerance);
//Zhipeng
    }


    @Test
    public void testTotalSavings() {
        double tolerance = 0.01;
//Zhipeng
        assertEquals(207.817,CompoundInterest.totalSavings(10, 2020,50) ,tolerance);
        assertEquals(10,CompoundInterest.totalSavings(10, 2015,50) ,tolerance);
//Zhipeng
    }

    @Test
    public void testTotalSavingsReal() {
        double tolerance = 0.01;
        assertEquals(24.25,CompoundInterest.totalSavingsReal(10, 2016,50,5) ,tolerance);
        assertEquals(10,CompoundInterest.totalSavingsReal(10, 2015,50,5) ,tolerance);
    }


    /* Run the unit tests in this file. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(CompoundInterestTest.class));
    }
}
