package stream;

import util.Person;

import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        System.out.println(Person.personList.get());
        Person.personList.get().stream()
                .map(person -> person.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
