import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 15));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));
        animals.add(new Horse("Clyde", "large", 950));

        for (Animal a : animals) {
            doAnimalStuff(a);
            if (a instanceof Mammal mammal) {
                mammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal) {

        animal.makeNoise();
        animal.move("slow");
    }
}
