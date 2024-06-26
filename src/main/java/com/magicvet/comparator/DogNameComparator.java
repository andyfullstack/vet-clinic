package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> { //NEW
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return (dog1.getName()).compareTo(dog2.getName());
    }

}
