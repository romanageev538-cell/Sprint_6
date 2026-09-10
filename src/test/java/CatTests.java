

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline mockFeline;

    @Test
    public void shouldCreateCatInstanceWhenConstructorInvoked() {
        Cat cat = new Cat(mockFeline);
        assertNotNull(cat);
    }

    @Test
    public void shouldReturnMeowWhenGetSoundCalled() {
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void shouldReturnMeatFoodListWhenGetFoodCalled() throws Exception {
        // given
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        // when
        Cat cat = new Cat(mockFeline);
        List<String> actualFood = cat.getFood();

        // then
        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenEatMeatFails() throws Exception {
        // given
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка"));

        // when
        Cat cat = new Cat(mockFeline);
        cat.getFood();
        // then ожидается исключение
    }
}