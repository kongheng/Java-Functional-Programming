package imperative;

import supplier.MockData;
import model.Person;

public class Main {

  public static void main(String[] args) {
    MockData.peopleList.get().stream()
        .limit(10)
        .map(people -> Person.mapToPerson.apply(people))
        .forEach(System.out::println);
  }
}
