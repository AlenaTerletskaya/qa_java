import com.example.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Family feline = new Feline();
        Animal animal = new Feline();
        Predator predator = new Feline();

        Lion lion = new Lion(feline, "Самка");

        System.out.println(lion.getKittens());
        System.out.println(lion.getFood());
        System.out.println(lion.doesHaveMane());
        System.out.println(animal.getFamily());
        System.out.println(predator.eatMeat());

        Aleks aleks = new Aleks(feline);

        System.out.println(aleks.getFriends());
        System.out.println(aleks.getPlaceOfLiving());
        System.out.println(aleks.getKittens());
        System.out.println(aleks.getFood());
        System.out.println(aleks.doesHaveMane());






    }
}
