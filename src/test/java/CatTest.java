import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Cat mockCat;

    @Mock
    Feline mockFeline;

    @Mock
    Predator mockPredator;

    //Проверяем, что метод getSound() вызван 1 раз.
    @Test
    public void checkCatGetSound_calledOnce() {
        mockCat.getSound();
        Mockito.verify(mockCat, Mockito.times(1)).getSound();
    }

    //Проверяем, что метод getFood() вызван 1 раз.
    @Test
    public void checkCatGetFood_calledOnce() throws Exception {
        mockCat.getFood();
        Mockito.verify(mockCat, Mockito.times(1)).getFood();
    }

    // Проверяем, что метод getSound() возвращает "Мяу"
    @Test
    public void checkCatGetSound_expectMeow() {
        Cat cat = new Cat(mockFeline);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что вызов метода getFood() возвращает результат вызова predator.eatMeat()
    @Test
    public void check() throws Exception {
        Cat cat = new Cat(mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

}
