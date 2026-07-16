

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTests {

    private final boolean inputHasMane;
    private final boolean expectedHasMane;
    private final int kittensInput;
    private final int expectedKittens;

    public FelineParameterizedTests(boolean inputHasMane, boolean expectedHasMane,
                                    int kittensInput, int expectedKittens) {
        this.inputHasMane = inputHasMane;
        this.expectedHasMane = expectedHasMane;
        this.kittensInput = kittensInput;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, true, 1, 1},
                {true, true, 5, 5},
                {false, false, 10, 10},
                {false, false, 0, 0}
        });
    }

    @Test
    public void testConstructorMane() {
        Feline feline = new Feline(inputHasMane);
        assertEquals(expectedHasMane, feline.doesHaveMane());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline(inputHasMane);
        assertEquals(expectedKittens, feline.getKittens(kittensInput));
    }
}