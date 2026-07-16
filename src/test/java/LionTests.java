

import com.example.FelineCharacteristics;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private FelineCharacteristics infoFeline;

    // ---------- Тесты с моком ----------
    @Test
    public void testConstructorWithMockDoesHaveMane() {
        when(infoFeline.doesHaveMane()).thenReturn(false);
        Lion lion = new Lion(infoFeline);
        assertFalse(lion.doesHaveMane());
        assertNotNull(lion);
    }

    @Test
    public void testConstructorWithMockGetKittens() {
        when(infoFeline.getKittens()).thenReturn(5);
        Lion lion = new Lion(infoFeline);
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void testConstructorWithMockGetFood() throws Exception {
        List<String> fakeFood = Arrays.asList("Мыши", "Птицы");
        when(infoFeline.getFood()).thenReturn(fakeFood);
        Lion lion = new Lion(infoFeline);
        assertEquals(fakeFood, lion.getFood());
    }

    // ---------- Тест на исключение ----------
    @Test
    public void testInvalidSexThrowsExceptionWithMessage() {
        try {
            new Lion("Нечто");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }
}
