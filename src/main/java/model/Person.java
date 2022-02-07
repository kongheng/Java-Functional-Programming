package model;

import static model.Gender.FEMALE;
import static model.Gender.MALE;

import com.liferay.petra.string.StringPool;
import java.time.LocalDate;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
  private Long id;
  private String name;
  private String email;
  private Gender gender;
  private LocalDate dob;

  public static Function<People, Person> mapToPerson = people ->
    Person.builder()
        .id((long) people.getId())
        .name(people.getFirstName().concat(StringPool.SPACE).concat(people.getLastName()))
        .gender(people.getGender().equalsIgnoreCase(MALE.toString()) ? MALE : FEMALE)
        .email(people.getEmail())
        .dob(LocalDate.of(1996, 03, 07))
        .build();
}
