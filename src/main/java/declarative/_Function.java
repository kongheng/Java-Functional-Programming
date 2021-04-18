package declarative;

import util.Customer;

import java.util.function.*;

public class _Function {
    public static void main(String[] args) {
        Customer customer = new Customer("kongheng", "9999");
        System.out.println(addByOneMultipleByTen.apply(1));
        System.out.println(incrementByOneMultiplyByBiFunction.apply(4, 10));
        greetingCustomerConsumer.accept(customer);
        greetingCustomerBiConsumer.accept(customer, false);
        greetingCustomerBiConsumer.accept(customer, true);
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000"));
        System.out.println(getDBConnectionUrlSupplier.get());
    }
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;
    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;
    static Function<Integer, Integer> addByOneMultipleByTen =
            incrementByOneFunction.andThen(multiplyByTenFunction);
    static BiFunction<Integer, Integer, Integer> incrementByOneMultiplyByBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
    static Consumer<Customer> greetingCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getName() + ", thanks for registering phone number " + "\"" + customer.getEmail() + "\"");
    static BiConsumer<Customer, Boolean> greetingCustomerBiConsumer = (customer, showPhone) ->
            System.out.println("Hello " + customer.getName() + ", thanks for registering phone number " + ( showPhone
            ? "\"" + customer.getEmail() + "\"" : "***********"));
    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";
}
