package simplejavacalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

class UITest {
    private UI ui;

    @BeforeEach
    void setUp() throws IOException {
        ui = new UI();
        // Required since writer() and text work on JTextArea
        // But we do NOT call ui.init() as it shows GUI
    }

    @Test
    void testWriterAndReader() {
        ui.writer(123.45);
        assertEquals(123.45, ui.reader());
        ui.writer(Double.NaN);
        assertThrows(NumberFormatException.class, () -> ui.reader());
    }

    @Test
    void testNumberButtonAction() {
        JButton btn = (JButton) TestUtils.getField(ui, "but", 3);  // should be button "3"
        JTextArea text = (JTextArea) TestUtils.getField(ui, "text");
        text.setText("");
        btn.doClick();
        assertEquals("3", text.getText());
    }

    @Test
    void testAddition() {
        JTextArea text = (JTextArea) TestUtils.getField(ui, "text");
        JButton butAdd = (JButton) TestUtils.getField(ui, "butAdd");
        JButton butEqual = (JButton) TestUtils.getField(ui, "butEqual");

        text.setText("12");
        butAdd.doClick();

        text.setText("8");
        butEqual.doClick();

        assertEquals("20.0", text.getText());
    }

    @Test
    void testCancel() {
        JTextArea text = (JTextArea) TestUtils.getField(ui, "text");
        JButton butCancel = (JButton) TestUtils.getField(ui, "butCancel");

        text.setText("25");
        butCancel.doClick();

        assertEquals("0.0", text.getText()); // Calculator.reset() returns 0.0
    }

    @Test
    void testBinaryConversion() {
        JTextArea text = (JTextArea) TestUtils.getField(ui, "text");
        JButton butBinary = (JButton) TestUtils.getField(ui, "butBinary");

        text.setText("10");
        butBinary.doClick();

        assertEquals("1010", text.getText());
    }

    // --- Helper to access private fields by reflection ---
    static class TestUtils {
        static Object getField(Object target, String fieldName) {
            try {
                java.lang.reflect.Field f = target.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                return f.get(target);
            } catch (Exception e) { throw new RuntimeException(e); }
        }
        static Object getField(Object target, String fieldName, int idx) {
            Object arr = getField(target, fieldName);
            if (arr instanceof Object[]) return ((Object[]) arr)[idx];
            else if (arr.getClass().isArray()) return java.lang.reflect.Array.get(arr, idx);
            throw new IllegalArgumentException("Not an array");
        }
    }
}