package lambdas;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Name -> " + upperCaseName.apply("Kongheng", 25));
    }
    static BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
      if (name.isEmpty()) {
        throw new IllegalStateException("no name provided");
      } else {
          System.out.println("Age -> " + age);
          return name.toUpperCase();
      }
    };
}
