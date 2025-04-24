package simplejavacalculator;

import org.junit.jupiter.api.Test;

import java.awt.Image;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BufferedImageCustomTest {

    @Test
    void testImageReturn() throws IOException {
        BufferedImageCustom bufferedImageCustom = new BufferedImageCustom();
        Image img = bufferedImageCustom.imageReturn();
        assertNotNull(img);
        assertTrue(img.getWidth(null) > 0);
        assertTrue(img.getHeight(null) > 0);
    }
}