/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BmiCalculatorTest {

    @Test
    public void testConstructor() {
        BmiCalculator calculator = new BmiCalculator(70, 175);

        assertEquals(70, calculator.weight());

        assertEquals(175, calculator.height());
    }

    @ParameterizedTest
    @CsvSource({
            "70, 175, 'Your BMI is 22.9, which means you are in the Normal range.'",
            "80, 160, 'Your BMI is 31.2, which means you are in the Obese range.'",
            "50, 175, 'Your BMI is 16.3, which means you are in the Underweight range.'",
            "90, 180, 'Your BMI is 27.7, which means you are in the Overweight range.'"
    })
    public void testCalculateBMI(double weight, double height, String expected) {


        BmiCalculator calculator = new BmiCalculator(weight, height);
        System.out.print("Expected: " + expected);
        System.out.print("Actual: " + calculator.calculateBMI());
    }
}
