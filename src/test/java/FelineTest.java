import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline mockFeline;

    @Mock
    Animal mockAnimal;

    // Проверяем, что метод eatMeat() вызван два раза
    @Test
    public void checkFelineEatMeat_calledTwice() throws Exception {
        mockFeline.eatMeat();
        mockFeline.eatMeat(); // вызвали метод два раза
        Mockito.verify(mockFeline, Mockito.times(2)).eatMeat();
        // проверили, что метод вызван два раза
    }

    // Проверяем, что метод getFamily() вызван два раза
    @Test
    public void checkFelineGetFamily_calledTwice() {
        mockFeline.getFamily();
        mockFeline.getFamily(); // вызвали метод два раза
        Mockito.verify(mockFeline, Mockito.times(2)).getFamily();
        // проверили, что метод вызван два раза
    }

    // Проверяем, что метод getKittens(int kittensCount) вызван с параметром 1, один раз
    @Test
    public void checkFelineGetKittens_calledOnceWithArgument1() {
        mockFeline.getKittens(1); // вызвали метод с параметром 1, один раз
        Mockito.verify(mockFeline, Mockito.times(1)).getKittens(1);
        // проверили, что метод вызван с этим параметром один раза
    }

    // Проверяем, что при вызове метода eatMeat() возвращается результат вызова Animal.getFood("Хищник")
    @Test
    public void checkFelineEatMeatCall_expectAnimalGetFoodResult() throws Exception {
        Feline feline = new Feline();
        List<String> expected = feline.getFood("Хищник");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что при вызове метода getFamily() возвращается "Кошачьи"
    @Test
    public void checkFelineGetFamilyCall_expectStringFeline() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что при вызове метода без аргументов getKittens() получаем 1
    @Test
    public void checkFelineGetKittensCallWithoutArgument_expect1() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что при вызове метода с параметром getKittens(2) получаем 2
    @Test
    public void checkFelineGetKittensCallWithArgument1_expect1() {
        Feline feline = new Feline();
        int expected = 2;
        int actual = feline.getKittens(2);
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }



}
