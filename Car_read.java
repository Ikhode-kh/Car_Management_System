import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*; 
import org.json.*; 

import java.io.FileReader;
import java.io.IOException;

public class Car_read {
  public static void main(String[] args) {
    try {
      JSONArray jsonArray = readJsonArrayFromFile("Car_DataSet.json");
      System.out.printf("%-5s %-10s %-10s %-10s %-10s %-20s %-10s\n", "ID", "Make", "Model", "Year", "Mileage",
          "Maintenance", "Price");
      List<String> value=new ArrayList<String>();
      for (int i=0;i<jsonArray.Length)

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader(fileName)) {
      return (JSONArray) parser.parse(reader);
    }
  }
}
