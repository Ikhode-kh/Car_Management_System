import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_Json {
  public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(new FileReader(fileName));

    if (obj instanceof JSONObject) {
      JSONObject jsonObj = (JSONObject) obj;
      return (JSONArray) jsonObj.get("Cars");
    } else if (obj instanceof JSONArray) {
      return (JSONArray) obj;
    } else {
      throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
    }
  }

}