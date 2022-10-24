import com.example.Feline;
import com.example.Lion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(JUnitParamsRunner.class) // Используем параметризацию в некоторых тестах
public class LionTest {

    // Подключаем Mockito к тестовому классу
    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Lion mockLion;

    @Mock
    Feline mockFeline;

    // Проверяем, что метод getKittens() вызван два раза
    @Test
    public void checkLionGetKittens_calledTwice() {
        mockLion.getKittens();
        mockLion.getKittens(); // вызвали метод два раза
        Mockito.verify(mockLion, Mockito.times(2)).getKittens();
        // проверили, что метод вызван два раза
    }

        // Проверяем, что метод doesHaveMane() вызван два раза
    @Test
    public void checkLionDoesHaveMane_calledTwice() {
        mockLion.doesHaveMane();
        mockLion.doesHaveMane(); // вызвали метод два раза
        Mockito.verify(mockLion, Mockito.times(2)).doesHaveMane();
        // проверили, что метод вызван два раза
    }

    // Проверяем, что метод getFood() вызван два раза
    @Test
    public void checkLionGetFood_calledTwice() throws Exception {
        mockLion.getFood();
        mockLion.getFood(); // вызвали метод два раза
        Mockito.verify(mockLion, Mockito.times(2)).getFood();
        // проверили, что метод вызван два раза
    }

    // Проверяем, что при вызове метода getFood() возвращается результат вызова Feline.getFood("Хищник")
    @Test
    public void checkLionGetFoodCall_expectFelineGetFoodResult() throws Exception {
        Lion lion = new Lion(mockFeline, "Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что при вызове метода getKittens() возвращается результат вызова Feline.getKittens()
    @Test
    public void checkLionGetKittensCall_expectFelineGetKittensResult() throws Exception {
        Lion lion = new Lion(mockFeline, "Самец");
        int expected = 1;
        Mockito.when(mockFeline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем: если создать объект Lion правильного пола, то doesHaveMane() возвращает ожидаемый результат
    @Test
    @Parameters({"Самец, true", "Самка, false"})
    public void checkLionConstructorValidSex_expectValidHasMane(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(mockFeline, sex);
        Assert.assertEquals("Expected: should return: " + expected, expected, lion.doesHaveMane());
    }

    // Проверяем: если неправильно указать пол при создании объекта Lion, то выбрасывается исключение
    @Test(expected = Exception.class)
    public void checkLionConstructorInvalidSex_expectThrowsException() throws Exception {
        Lion lion = new Lion(mockFeline, "Другое");
    }

    // Проверяем: если неправильно указать пол при создании объекта Lion, то выводится текст исключения
    @Test
    public void checkLionConstructorInvalidSex_expectExceptionText() throws Exception {
        Exception exception = null;

        try { Lion lion = new Lion(mockFeline, "Другое"); }
        catch(Exception ex) {
            exception = ex;
        }

        String expected = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals("Expected: should return: " + expected, expected, exception.getMessage());
    }












}
