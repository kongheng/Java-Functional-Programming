package callback;

import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        sayHello("Long", null, value -> System.out.println("no last name provided for " + value));
        sayHello1("Long", null, () -> System.out.println("no last name provided"));
    }
    static void sayHello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        Optional.ofNullable(lastName)
                .ifPresentOrElse(
                        System.out::println,
                        () -> callback.accept(firstName)
                );
    }
    static void sayHello1(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        Optional.ofNullable(lastName)
                .ifPresentOrElse(
                        System.out::println,
                        () -> callback.run());
    }
}
