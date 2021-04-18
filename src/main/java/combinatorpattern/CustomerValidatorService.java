package combinatorpattern;

import util.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CustomerValidatorService {
    private CustomerValidatorService() {}
    private Predicate<String> isEmailValid = email -> email.contains("@");
    private Predicate<String> isPhoneNumberValid = phoneNumber -> phoneNumber.startsWith("+0");
    private Predicate<LocalDate> isAdult = dob -> Period.between(dob, LocalDate.now()).getYears() > 16;
    public Predicate<Customer> isValid = customer ->
            isAdult.test(customer.getDob()) && isEmailValid.test(customer.getEmail()) && isPhoneNumberValid.test(customer.getPhoneNumber());
    private static class CustomerValidatorServiceHelper {
        private static final CustomerValidatorService service = new CustomerValidatorService();
    }
    public static Supplier<CustomerValidatorService> createInstance = () -> CustomerValidatorServiceHelper.service;
}
