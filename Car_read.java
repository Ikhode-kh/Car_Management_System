
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Car_read {
  public static void main(String[] args) {
    try {
      JSONArray jsonArray = readJsonArrayFromFile("Car_DataSet.json");
      System.out.printf("%-5s %-10s %-10s %-10s %-10s %-20s %-10s\n", "ID", "Make", "Model", "Year", "Mileage",
          "maintenace_stat", "Price");
          for (Object obj : jsonArray) {
            JSONObject car = (JSONObject) obj;
            System.out.printf("%-5s %-10s %-10s %-10s %-10s %-20s %-10s\n", car.get("id"), car.get("make"), car.get("model"),car.get("year"),car.get("mileage"),car.get( "maintenace_stat"),car.get("price"));
        }

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

