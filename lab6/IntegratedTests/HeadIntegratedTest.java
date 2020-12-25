package IntegratedTests;

import instrument.Head;
import instrument.Tuners;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import javax.lang.model.type.NullType;

import static org.junit.jupiter.api.Assertions.*;

class HeadIntegratedTest {

    @Test //using Mock
    void TuneTheGuitar_ReturningCorrectString_UseMock_String() {
        Tuners mockedTuners = Mockito.mock(Tuners.class);
        Head head = new Head(mockedTuners);
        Mockito.when(mockedTuners.turnTuners()).thenReturn("\nGuitar was tuned.");

        head.tuneTheGuitar();
        assertNull(head.tuneTheGuitar());
        Mockito.verify(mockedTuners).turnTuners();
    }

    @Test //using Spy
    void TuneTheGuitar_ReturningCorrectString_UseSpy_String() {
        Tuners spyedTuners = Mockito.spy(Tuners.class);
        Head head = new Head(spyedTuners);
        Mockito.when(spyedTuners.turnTuners()).thenReturn("\nGuitar was tuned.");
        head.tuneTheGuitar();
        assertEquals(head.tuneTheGuitar(), "\nGuitar was tuned.");
        Mockito.verify(spyedTuners).turnTuners();
    }
}