package imperative;

import util.Person;

import static util.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {
        Person.personList.get().stream()
            .filter(person -> person.getGender().equals(FEMALE))
            .forEach(System.out::println);
    }
}
