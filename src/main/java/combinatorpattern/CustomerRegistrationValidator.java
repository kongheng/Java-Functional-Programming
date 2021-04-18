package combinatorpattern;

import util.Customer;
import util.ValidatorResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static util.ValidatorResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidatorResult> {
    static CustomerRegistrationValidator isValidEmail() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }
    static CustomerRegistrationValidator isValidPhoneNumber() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_ADULT;
    }
    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidatorResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
}
