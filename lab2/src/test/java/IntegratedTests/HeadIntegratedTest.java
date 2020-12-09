package IntegratedTests;

import instrument.Head;
import instrument.Tuners;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class HeadIntegratedTest {

    @Test
    void TuneTheGuitar_ReturningCorrectString_String() {
        Tuners mockedTuners = Mockito.mock(Tuners.class);
        Head head = new Head(mockedTuners);
        Mockito.when(mockedTuners.turnTuners()).thenReturn("\nGuitar was tuned.");

        head.tuneTheGuitar();
        assertEquals(head.tuneTheGuitar(), "\nGuitar was tuned.");
        Mockito.verify(mockedTuners).turnTuners();
    }
}