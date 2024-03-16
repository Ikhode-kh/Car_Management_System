import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Car_read {
  public static void main(String[] args) {
    try {
      JSONArray jsonArray = readJsonArrayFromFile("Car_DataSet.json");
      System.out.println("JSON Array: " + jsonArray);
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(new FileReader(fileName));
    JSONObject jsonObj = (JSONObject) obj;

    JSONArray jsonArray = new JSONArray();
    for (Object key : jsonObj.keySet()) {
      String diagramKey = (String) key;
      jsonArray.add(jsonObj.get(diagramKey));
    }
    return jsonArray;
  }
}