

import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTests {

    @Test
    public void testDefaultConstructorHasNoMane() {
        Feline feline = new Feline();
        assertFalse(feline.doesHaveMane());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline(true);
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline(true);
        List<String> food = feline.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline(true);
        List<String> meat = feline.eatMeat();
        assertEquals(3, meat.size());
        assertTrue(meat.contains("Животные"));
        assertTrue(meat.contains("Птицы"));
        assertTrue(meat.contains("Рыба"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline(true);
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetFoodWithUnknownKindThrowsExceptionWithMessage() {
        Feline feline = new Feline(true);
        try {
            feline.getFood("Неизвестно");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }
}
