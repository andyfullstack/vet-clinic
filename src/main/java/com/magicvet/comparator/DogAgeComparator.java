package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class DogAgeComparator implements Comparator<Dog> { //NEW
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return parseInt(dog1.getAge()) - parseInt(dog2.getAge());
    }

}
