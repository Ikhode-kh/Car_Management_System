import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Car_read {
  public static void main(String[] args) {
    try {
      System.out.println("Information:");
      System.out.printf("%-5s %-15s %-15s %-15s %-15s %-10s\n", "ID", "Model", "Year", "Make",
          "Price", "Maintenace_stat");

      JSONArray jsonArray = readJsonArrayFromFile("Car_DataStorage.json");

      for (Object object : jsonArray) {
        JSONObject obj = (JSONObject) object;

        
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-10s \n", 
        obj.get("Id"), 
        obj.get("Model"), 
        obj.get("Year"),
        obj.get("Make"),
        obj.get("Price"), 
        obj.get("Maintenace_stat"));
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(fileName)) {
      JSONObject root = (JSONObject) parser.parse(reader);
      return (JSONArray) root.get("Cars"); // Directly access the "Cars" array
    }
  }
}
