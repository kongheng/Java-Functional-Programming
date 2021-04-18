package util;

import java.util.List;
import java.util.function.Supplier;

public class Person {
    private final String name;
    private final Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public static Supplier<List<Person>> personList = () ->
        List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Sarah", Gender.FEMALE)
        );
}
