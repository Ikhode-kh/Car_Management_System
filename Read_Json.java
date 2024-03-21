import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_Json {
  public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(fileName)) {
      JSONObject root = (JSONObject) parser.parse(reader);
      return (JSONArray) root.get("Cars"); // Directly access the "Cars" array
    }
  }
}
