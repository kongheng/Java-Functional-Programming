package declarative;

import java.util.function.BiConsumer;
import model.People;

public class _BiConsumer {
  public static BiConsumer<People, Boolean> greetingPerson = (people, showEmailAddress) ->
      System.out.println(String.format("Hello %s %s, thank for registering with email address = %s",
          people.getFirstName(), people.getLastName(), showEmailAddress ? people.getEmail() : "***"));
}
