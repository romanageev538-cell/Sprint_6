

import com.example.Feline;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTests {

    @Test
    public void shouldReturnMeatPredatorDiet() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void shouldReturnFamilyName() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void shouldReturnDefaultKittensCount() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void shouldReturnSpecifiedKittensCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

}