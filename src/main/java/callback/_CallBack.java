package callback;

import com.liferay.portal.kernel.util.Validator;
import java.util.function.Consumer;

public class _CallBack {
  public static void sayHello(String firstName, String lastName, Consumer<String> callback) {
    System.out.println(firstName);
    if (Validator.isNull(lastName)) {
      callback.accept(firstName);
    } else {
      System.out.println(lastName);
    }
  }
  public static void sayHello2(String firstName, String lastName, Runnable callback) {
    System.out.println(firstName);
    if (Validator.isNull(lastName)) {
      callback.run();
    } else {
      System.out.println(lastName);
    }
  }
}
