import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class CarSearch {
    public static void main(String[] args) {
        // Replace "path/to/Car_DataSet.json" with the actual path to your car data JSON file
        String carDataFilePath = "./Car_DataSet.json";

        // Replace "searchModel" with the model you want to search for
        String searchModel = "Camry";

        try (FileReader reader = new FileReader(carDataFilePath)) {
            // Parse the JSON file using Gson
            JsonArray carsArray = JsonParser.parseReader(reader).getAsJsonObject().getAsJsonArray("cars");

            // Perform the search
            for (int i = 0; i < carsArray.size(); i++) {
                JsonObject car = carsArray.get(i).getAsJsonObject();
                String model = car.get("model").getAsString();

                if (model.equalsIgnoreCase(searchModel)) {
                    // Return the relevant information
                    System.out.println("Car found:");
                    System.out.println("Make: " + car.get("make").getAsString());
                    System.out.println("Model: " + model);
                    System.out.println("Year: " + car.get("year").getAsInt());
                    System.out.println("Mileage: " + car.get("mileage").getAsInt());
                    System.out.println("Maintenance Status: " + car.get("maintenance_status").getAsString());
                    System.out.println("Price: " + car.get("price").getAsInt());

                    return; // Stop searching after finding the first match
                }
            }

            // If no matching car is found
            System.out.println("Car with model '" + searchModel + "' not found.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
