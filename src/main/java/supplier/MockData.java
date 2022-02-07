package supplier;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import model.People;
import org.apache.commons.io.IOUtils;

public class MockData {

  public static Supplier<List<People>> peopleList = () -> {
    try {
      InputStream inputStream = Resources.getResource("people.json").openStream();
      String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      Type listType = new TypeToken<ArrayList<People>>() {
      }.getType();
      return new Gson().fromJson(json, listType);
    } catch (Exception e) {
      e.printStackTrace();
      return Collections.EMPTY_LIST;
    }
  };
}
