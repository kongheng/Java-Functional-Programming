package model;

import supplier.MockData;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class People {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String gender;
  private Integer age;

  public static Function<Integer, People> getPeopleById = id -> MockData.peopleList.get().stream()
      .filter(p -> p.getId().equals(id))
      .findFirst()
      .orElseThrow(() -> new IllegalStateException(String.format("People not found with id=%d", id)));
}
