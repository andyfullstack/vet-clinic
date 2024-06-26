package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() { }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + getType() + '\'' +
                ", age='" + getAge() + '\'' +
                ", name='" + getName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", size='" + getSize() + '\'' +
                ", healthState='" + getHealthState() + '\'' +
                ", ownerName='" + getOwnerName() + '\'' +
                ", registrationDate = " + getRegistrationDate().format(FORMATTER) + '\'' +
                '}';
    }


    public Dog(Size size) {
        this.size = size;
    }
    public Dog(String name, String age, String sex, HealthState healthState,Size size){
        super.setName(name);
        super.setAge(age);
        super.setSex(sex);
        super.setHealthState(healthState);
        this.size = size;
    }
/*
    @Override
    public String toString() {
        return "Dog{" +
                " age='" + super.getAge() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", sex='" + super.getSex() + '\'' +
                ", size='" + size + '\'' +
                ", healthState='" + super.getHealthState() + '\'' +
                ", ownerName='" + super.getOwnerName() + '\'' +
                '}';
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public enum Size {

        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public static Size fromString(String value) {
            for (Size size : values()) {
                if (size.toString().equals(value)) {
                    return size;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }//fromString

        public int getValue() {
            return value;
        }
    }//enum Size

}//Dog
