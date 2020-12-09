package UnitTests;

import instrument.Guitar;
import instrument.Instrument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentTest {

    Instrument guitar;

    @Test
    void RandomFillInstruments_FillingPriceAndWeight_IsNotNull() {
         guitar = new Guitar();
         guitar.randomFillInstruments();
         assertTrue(guitar.getPrice() != 0 && guitar.getWeight() != 0);
    }
}