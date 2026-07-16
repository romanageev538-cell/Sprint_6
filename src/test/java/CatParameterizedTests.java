

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class CatParameterizedTests {

    // Параметры – ожидаемый список еды
    private final List<String> expectedFood;

    // Мок для Feline (будет использоваться в каждом тестовом запуске)
    @Mock
    private Feline mockFeline;

    // Конструктор тестового класса (принимает параметры)
    public CatParameterizedTests(List<String> expectedFood) {
        this.expectedFood = expectedFood;
    }

    // Данные для параметризации – разные списки еды
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("Животные", "Птицы", "Рыба")},
                {Arrays.asList("Мыши", "Птицы")},
                {Arrays.asList("Трава", "Ягоды")}
        });
    }

    // Инициализация моков перед каждым тестом (т.к. раннер Parameterized не создаёт моки автоматически)
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    // Параметризованный тест – проверяет, что Cat.getFood() возвращает то, что вернул predator.eatMeat()
    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockFeline);
        assertEquals(expectedFood, cat.getFood());
    }
}