package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogAgeComparator;
import main.java.com.magicvet.comparator.DogNameComparator;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        /*Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS),
                new Dog(Dog.S)
        };
        Arrays.sort(dogs, new DogSizeComparator());
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }*/
        //NEW   new Dog(String name, String age, String sex, String size)
        Dog[] dogs = { //NEW
                new Dog("Rex", "3", "male", Pet.HealthState.GREEN, Dog.Size.XL),
                new Dog("Lessi", "5", "female", Pet.HealthState.GREEN, Dog.Size.L),
                new Dog("Sharic", "2", "male", Pet.HealthState.RED, Dog.Size.M),
                new Dog("Barbos", "10", "male", Pet.HealthState.GREEN, Dog.Size.L),
                new Dog("Penelopa", "3", "female", Pet.HealthState.YELLOW, Dog.Size.S),
                new Dog("Monica", "2", "female", Pet.HealthState.GREEN, Dog.Size.S)
        };
        System.out.println("---Sorting dogs by name:");
        Arrays.sort(dogs, new DogNameComparator());
        for (Dog dog : dogs) {
            System.out.println(dog.getName() +
                    " (age = " + dog.getAge() +
                    ", sex = " + dog.getSex() +
                    ", healthState = '" + dog.getHealthState() +
                    ", size = " + dog.getSize() + ")");
        }
        System.out.println("---Sorting dogs by age:");
        Arrays.sort(dogs, new DogAgeComparator());
        for (Dog dog : dogs) {
            System.out.println(dog.getAge() +
                    " (name = " + dog.getName() + ")");
        }
        System.out.println("---Sorting dogs by size:");
        //Arrays.sort(dogs, new DogSizeComparator());
        //Arrays.sort(dogs, new Comparator<Dog>()
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });
        for (Dog dog : dogs) {
            System.out.println(dog.getSize() +
                    " (name = " + dog.getName() + ")");
        }

        System.out.println("---Sorting dogs by healthState:");
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });
        for (Dog dog : dogs) {
            System.out.println(dog.getHealthState() +
                    " (name = " + dog.getName() + ")");
        }

    }
}//class Sandbox
