package declarative;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import model.Person;
import supplier.MockData;

public class _Supplier {
  public static Supplier<List<Person>> personList = () -> MockData.peopleList.get().stream()
      .limit(10)
      .map(people -> Person.mapToPerson.apply(people))
      .collect(Collectors.toList());
}
