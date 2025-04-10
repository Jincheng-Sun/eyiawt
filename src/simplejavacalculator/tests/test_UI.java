import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private UI calculatorUI;

    @Before
    public void setUp() throws Exception {
        calculatorUI = new UI();
    }

    @Test
    public void testAddition() {
        calculatorUI.text.setText("5");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butAdd, ActionEvent.ACTION_PERFORMED, null));
        calculatorUI.text.setText(calculatorUI.text.getText() + "3");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butEqual, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("8.0", calculatorUI.text.getText());
    }

    @Test
    public void testSubtraction() {
        calculatorUI.text.setText("10");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butMinus, ActionEvent.ACTION_PERFORMED, null));
        calculatorUI.text.setText(calculatorUI.text.getText() + "2");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butEqual, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("8.0", calculatorUI.text.getText());
    }

    @Test
    public void testMultiplication() {
        calculatorUI.text.setText("3");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butMultiply, ActionEvent.ACTION_PERFORMED, null));
        calculatorUI.text.setText(calculatorUI.text.getText() + "4");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butEqual, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("12.0", calculatorUI.text.getText());
    }

    @Test
    public void testDivision() {
        calculatorUI.text.setText("20");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butDivide, ActionEvent.ACTION_PERFORMED, null));
        calculatorUI.text.setText(calculatorUI.text.getText() + "4");
        calculatorUI.actionPerformed(new ActionEvent(calculatorUI.butEqual, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("5.0", calculatorUI.text.getText());
    }
}