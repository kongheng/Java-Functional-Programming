package declarative;

import java.util.function.Predicate;

public class _Predicate {
  public static Predicate<String> isValidPhoneNumber = phoneNumber -> phoneNumber.startsWith("855")
      && phoneNumber.length() == 11;
}
