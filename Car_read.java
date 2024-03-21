
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;

public class Car_read {
  public static void read(){
    try {
      System.out.println("Information:");
      System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-10s\n", "ID", "Model", "Manufacturer", "Model_Year",
          "Price", "Class","Units");

      JSONArray jsonArray = Read_Json.readJsonArrayFromFile("Car_DataStorage.json");

      for (Object object : jsonArray) {
        JSONObject obj = (JSONObject) object;

        
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-10s \n", 
        obj.get("Id"), 
        obj.get("Model"), 
        obj.get("Manufacturer"),
        obj.get("Model_Year"),
        obj.get("Price"),
        obj.get("Class"),
        obj.get("Units"));
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }
}
