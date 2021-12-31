package declarative;

import java.util.function.Consumer;
import model.People;

public class _Consumer {
  public static Consumer<People> greetingPerson = people ->
      System.out.println(String.format("Hello %s %s, thank for registering with email address = %s",
          people.getFirstName(), people.getLastName(), people.getEmail()));
}
