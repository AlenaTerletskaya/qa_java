import com.example.Aleks;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AleksTest {

    @Mock
    Aleks mockAleks;

    @Mock
    Feline mockFeline;

    // Проверяем, что метод getFriends() вызван 1 раз.
    @Test
    public void checkAleksGetFriends_calledOnce() {
        mockAleks.getFriends();
        Mockito.verify(mockAleks, Mockito.times(1)).getFriends();
    }

    // Проверяем, что метод getPlaceOfLiving() вызван 1 раз.
    @Test
    public void checkAleksGetPlaceOfLiving_calledOnce() {
        mockAleks.getPlaceOfLiving();
        Mockito.verify(mockAleks, Mockito.times(1)).getPlaceOfLiving();
    }

    // Проверяем, что метод getKittens() вызван 1 раз.
    @Test
    public void checkAleksGetKittens_calledOnce() {
        mockAleks.getKittens();
        Mockito.verify(mockAleks, Mockito.times(1)).getKittens();
    }

    // Проверяем, что метод getFriends() возвращает список имён друзей Алекса
    @Test
    public void checkAleksGetFriends_expectListOfFriends() throws Exception{
        Aleks aleks = new Aleks(mockFeline);
        List<String> actual = aleks.getFriends();
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория ", "жираф Мелман");
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что метод getPlaceOfLiving() возвращает место, где живёт Алекс — Нью-Йоркский зоопарк
    @Test
    public void checkAleksGetPlaceOfLiving_expectPlaceOfLiving() throws Exception{
        Aleks aleks = new Aleks(mockFeline);
        String actual = aleks.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что метод getKittens() возвращает 0
    @Test
    public void checkAleksGetKittens_expect0() throws Exception{
        Aleks aleks = new Aleks(mockFeline);
        int actual = aleks.getKittens();
        int expected = 0;
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }

    // Проверяем, что в конструкторе Алекса передается пол "Самец". Проверяем через наличие гривы.
    @Test
    public void checkAleksConstructorArgumentMale_expectDoesHaveManeTrue() throws Exception{
        Aleks aleks = new Aleks(mockFeline);
        boolean actual = aleks.doesHaveMane();
        boolean expected = true;
        Assert.assertEquals("Expected: should return: " + expected, expected, actual);
    }




}
