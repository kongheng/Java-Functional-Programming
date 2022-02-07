package callback;

public class Main {

  public static void main(String[] args) {
    _CallBack.sayHello("Long", null, firstName -> System.out.printf(
        "No lastName provided for %s%n", firstName));

    _CallBack.sayHello2("Long", null, () ->
        System.out.println("No lastName provided"));
  }
}
