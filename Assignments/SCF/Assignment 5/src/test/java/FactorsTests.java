package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import main.Factors;

public class FactorsTests {
    
    Factors factor = new Factors();
     @Test
    public void lcmOfTwoPositiveNumbers() {
        assertEquals(12, factor.findLCM(4, 6, 1));
    }

    @Test
    public void lcmOfSameNumbers() {
        assertEquals(7, factor.findLCM(7, 7, 1));
    }

    @Test
    public void lcmOfZero() {
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            factor.findLCM(0,5,1);
        });
        assertEquals("Cannot compute LCM for zero values.", exception.getMessage());
    }

    @Test
    public void lcmOfNegativeNumber() {
        assertEquals(12, factor.findLCM(-4, 6, 1));
    }

    @Test
    public void hcfOfTwoPositiveNumbers() {
        assertEquals(4, factor.findHCF(8, 12));
    }

    @Test
    public void hcfOfSameNumbers() {
        assertEquals(7, factor.findHCF(7, 7));
    }

    @Test
    public void hcfOfNegativeNumber() {
        assertEquals(6, factor.findHCF(-12, 18));
    }

    @Test
    public void hcfOfZero() {
        assertEquals(5, factor.findHCF(0, 5));
    }
}
