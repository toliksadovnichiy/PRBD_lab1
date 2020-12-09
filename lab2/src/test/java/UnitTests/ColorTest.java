package UnitTests;

import instrument.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    Color color;

    @Test
    void ToString_ConvertingToString_String() {
        color = Color.GREEN;
        assertEquals(color.toString(), "GREEN Color{hex='#008000'}");
    }
}