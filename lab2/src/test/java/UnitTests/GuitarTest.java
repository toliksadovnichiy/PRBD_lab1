package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import instrument.Color;
import instrument.Guitar;
import instrument.Material;
import org.junit.jupiter.api.*;

class GuitarTest {

    private final Guitar guitar = new Guitar();;

    @Test
    void IsSameColor_ComparisonOfColors_Boolean() {
        assertTrue(guitar.isSameColor().substring(0,4).equals("Head") ||
                guitar.isSameColor().substring(0,4).equals("Neck"));
    }

    @Test
    void RandomColor_ColorGeneration_IsOneOfColors() {
        boolean assertion = false;
        Color color = Guitar.randomColor();
        for(Color c : Color.values()) {
            if(c.name().equals(color.name())) {
               assertion = true;
            }
        }
        assertTrue(assertion);
    }

    @Test
    void RandomMaterial_MaterialGeneration_IsOneOfMaterial() {
        boolean assertion = false;
        Material material = Guitar.randomMaterial();
        for(Material m : Material.values()) {
            if(m.name().equals(material.name())) {
                assertion = true;
            }
        }
        assertTrue(assertion);
    }

    @Test
    void RandomNumber_NumberRandomizing_IsInBounds() {
        int low = 1, high = 10;
        int testNum = Guitar.randomNumber(low, high, 1);
        assertTrue(testNum >= low && testNum < high);
    }
}