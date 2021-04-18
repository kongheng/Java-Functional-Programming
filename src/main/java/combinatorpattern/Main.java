package combinatorpattern;

import util.Customer;
import util.ValidatorResult;

import static combinatorpattern.CustomerRegistrationValidator.isAdult;
import static combinatorpattern.CustomerRegistrationValidator.isValidPhoneNumber;
import static util.ValidatorResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        CustomerValidatorService service = CustomerValidatorService.createInstance.get();
        Customer customer = Customer.createInstance.get();
        customer.customerList.get().stream()
                .filter(cus -> service.isValid.test(cus))
                .map(cus -> cus.getEmail())
                .forEach(System.out::println);
        Customer customer1 = customer.customerList.get().stream().findFirst().get();
        ValidatorResult result = CustomerRegistrationValidator
                .isValidEmail()
                .and(isAdult())
                .and(isValidPhoneNumber())
                .apply(customer1);
        System.out.println(result);
        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
