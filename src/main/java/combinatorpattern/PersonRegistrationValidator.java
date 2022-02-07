package combinatorpattern;

import static combinatorpattern.ValidationResult.EMAIL_NOT_VALID;
import static combinatorpattern.ValidationResult.IS_NOT_AN_ADULT;
import static combinatorpattern.ValidationResult.SUCCESS;

import com.liferay.petra.string.StringPool;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import model.Person;

public interface PersonRegistrationValidator extends Function<Person, ValidationResult> {
  static PersonRegistrationValidator isEmailValid() {
    return person -> person.getEmail().contains(StringPool.AT) ? SUCCESS : EMAIL_NOT_VALID;
  }
  static PersonRegistrationValidator isAdult() {
    return person -> Period.between(person.getDob(), LocalDate.now()).getYears() > 16 ?
        SUCCESS : IS_NOT_AN_ADULT;
  }
  default PersonRegistrationValidator and(PersonRegistrationValidator other) {
    return person -> {
      ValidationResult result = this.apply(person);
      return result.equals(SUCCESS) ? other.apply(person) : result;
    };
  }
}
