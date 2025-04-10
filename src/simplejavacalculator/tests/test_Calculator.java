import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import simplejavacalculator.Calculator;
import simplejavacalculator.Calculator.BiOperatorModes;
import simplejavacalculator.Calculator.MonoOperatorModes;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(Double.valueOf(5), calculator.calculateBi(BiOperatorModes.add, 2.0));
        Assert.assertEquals(Double.valueOf(7), calculator.calculateEqual(7.0));
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(Double.valueOf(2), calculator.calculateBi(BiOperatorModes.minus, 5.0));
        Assert.assertEquals(Double.valueOf(-1), calculator.calculateEqual(3.0));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(Double.valueOf(10), calculator.calculateBi(BiOperatorModes.multiply, 5.0));
        Assert.assertEquals(Double.valueOf(50), calculator.calculateEqual(10.0));
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(Double.valueOf(2), calculator.calculateBi(BiOperatorModes.divide, 10.0));
        Assert.assertEquals(Double.valueOf(5), calculator.calculateEqual(2.0));
    }

    @Test
    public void testSquare() {
        Assert.assertEquals(Double.valueOf(16), calculator.calculateMono(MonoOperatorModes.square, 4.0));
    }

    @Test
    public void testSquareRoot() {
        Assert.assertEquals(Double.valueOf(3), calculator.calculateMono(MonoOperatorModes.squareRoot, 9.0), 0.001);
    }

    @Test
    public void testOneDividedBy() {
        Assert.assertEquals(Double.valueOf(0.25), calculator.calculateMono(MonoOperatorModes.oneDividedBy, 4.0));
    }

    @Test
    public void testCosine() {
        Assert.assertEquals(Double.valueOf(1), calculator.calculateMono(MonoOperatorModes.cos, 0.0));
    }

    @Test
    public void testSine() {
        Assert.assertEquals(Double.valueOf(0), calculator.calculateMono(MonoOperatorModes.sin, 0.0));
    }

    @Test
    public void testTangent() {
        Assert.assertEquals(Double.valueOf(0), calculator.calculateMono(MonoOperatorModes.tan, 0.0));
    }

    @Test
    public void testLogarithm() {
        Assert.assertEquals(Double.valueOf(2), calculator.calculateMono(MonoOperatorModes.log, 100.0));
    }

    @Test
    public void testLN() {
        Assert.assertEquals(Double.valueOf(0), calculator.calculateMono(MonoOperatorModes.ln, 1.0));
    }
    
    @Test
    public void testReset() {
        calculator.calculateBi(BiOperatorModes.add, 5.0);
        calculator.calculateEqual(3.0);
        Assert.assertEquals(Double.NaN, calculator.reset(), 0.0);
    }
}