package simplejavacalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.add, 5.0)));
        assertEquals(8.0, calc.calculateBi(Calculator.BiOperatorModes.add, 3.0));
        assertEquals(Double.NaN, calc.calculateEqual(0.0)); // After equal, mode reset
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.minus, 8.0)));
        assertEquals(3.0, calc.calculateBi(Calculator.BiOperatorModes.minus, 5.0));
        assertEquals(Double.NaN, calc.calculateEqual(0.0));
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.multiply, 7.0)));
        assertEquals(21.0, calc.calculateBi(Calculator.BiOperatorModes.multiply, 3.0));
    }

    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.divide, 12.0)));
        assertEquals(4.0, calc.calculateBi(Calculator.BiOperatorModes.divide, 3.0));
    }

    @Test
    void testPower() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0)));
        assertEquals(8.0, calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 3.0));
    }

    @Test
    void testReset() {
        Calculator calc = new Calculator();
        assertTrue(Double.isNaN(calc.reset()));
        assertTrue(Double.isNaN(calc.calculateBi(Calculator.BiOperatorModes.add, 1.0)));
    }

    @Test
    void testSquare() {
        Calculator calc = new Calculator();
        assertEquals(25.0, calc.calculateMono(Calculator.MonoOperatorModes.square, 5.0));
    }

    @Test
    void testSquareRoot() {
        Calculator calc = new Calculator();
        assertEquals(3.0, calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 9.0));
    }

    @Test
    void testOneDividedBy() {
        Calculator calc = new Calculator();
        assertEquals(0.2, calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 5.0));
    }

    @Test
    void testCos() {
        Calculator calc = new Calculator();
        assertEquals(1.0, calc.calculateMono(Calculator.MonoOperatorModes.cos, 0.0), 1e-10);
    }

    @Test
    void testSin() {
        Calculator calc = new Calculator();
        assertEquals(1.0, calc.calculateMono(Calculator.MonoOperatorModes.sin, 90.0), 1e-10);
    }

    @Test
    void testTan() {
        Calculator calc = new Calculator();
        assertEquals(0.0, calc.calculateMono(Calculator.MonoOperatorModes.tan, 0.0));
        assertTrue(Double.isNaN(calc.calculateMono(Calculator.MonoOperatorModes.tan, 90.0)));
        assertEquals(1.0, calc.calculateMono(Calculator.MonoOperatorModes.tan, 45.0), 1e-10);
    }

    @Test
    void testLog() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.calculateMono(Calculator.MonoOperatorModes.log, 100.0), 1e-10);
    }

    @Test
    void testLn() {
        Calculator calc = new Calculator();
        assertEquals(Math.log(10.0), calc.calculateMono(Calculator.MonoOperatorModes.ln, 10.0), 1e-10);
    }

    @Test
    void testRate() {
        Calculator calc = new Calculator();
        assertEquals(0.05, calc.calculateMono(Calculator.MonoOperatorModes.rate, 5.0));
    }

    @Test
    void testAbs() {
        Calculator calc = new Calculator();
        assertEquals(7.0, calc.calculateMono(Calculator.MonoOperatorModes.abs, -7.0));
    }
}