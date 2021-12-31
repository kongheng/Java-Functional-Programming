package declarative;

import static combinatorpattern.PersonRegistrationValidator.isAdult;
import static combinatorpattern.PersonRegistrationValidator.isEmailValid;

import com.liferay.petra.string.StringPool;
import java.time.LocalDate;
import java.util.Optional;
import model.People;
import model.Person;

public class Main {

  public static void main(String[] args) {
    // Function take only one argument and produce one result.
    _Function.incrementByOneFunction.apply(5);
    // BiFunction take two arguments and produce one result.
    _BiFunction.sum.apply(5, 10);
    // Consumer represents an operation that accepts a single input argument and returns no result.
    _Consumer.greetingPerson.accept(People.getPeopleById.apply(45));
    // Consumer represents an operation that accepts two input arguments and returns no result.
    _BiConsumer.greetingPerson.accept(People.getPeopleById.apply(45), true);
    _BiConsumer.greetingPerson.accept(People.getPeopleById.apply(45), false);
    // Predicate represents a predicate (boolean-valued function) of one argument.
    _Predicate.isValidPhoneNumber.test("85581829069");
    _Predicate.isValidPhoneNumber.test("0121776376");
    // Supplier represents a supplier of results.
    _Supplier.personList.get().forEach(System.out::println);
    // Optional
    String emailAddress = "kongheng.long@gmail.com";
    Optional.of(emailAddress)
        .ifPresentOrElse(
            email -> System.out.println("Email sent to " + email),
            () -> System.out.println("EmailAddress can not be empty")
        );
    // Combinator pattern
    Person person = Person.mapToPerson.apply(People.getPeopleById.apply(5));
    System.out.println(isEmailValid().and(isAdult()).apply(person));
    person.setDob(LocalDate.now());
    System.out.println(isEmailValid().and(isAdult()).apply(person));
    person.setEmail(StringPool.BLANK);
    System.out.println(isEmailValid().and(isAdult()).apply(person));
  }
}
