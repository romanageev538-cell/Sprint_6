

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline mockFeline;

    @Test
    public void testConstructorWithMockShouldCreateCat() {
        Cat cat = new Cat(mockFeline);
        assertNotNull(cat);
    }

    @Test
    public void testReturnGetSound() {
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionWhenEatMeatThrows() throws Exception {
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка"));
        Cat cat = new Cat(mockFeline);
        cat.getFood();
    }
}

