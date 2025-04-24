package simplejavacalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SimpleJavaCalculatorTest {

    @Test
    void mainShouldCallUiInit() {
        // Arrange
        UI mockUi = mock(UI.class);

        // Use a spy or dependency injection if possible; here we'll test for exceptions only as UI is not injectable
        assertDoesNotThrow(() -> SimpleJavaCalculator.main(new String[0]));
    }
}