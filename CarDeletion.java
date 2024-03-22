import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarDeletion {

    public static void deleteCar(String filePath, int carId) {
        try {
            // Read the JSON file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));

            // Handle both single object and array scenarios
            JSONObject jsonObject;
            JSONArray carsArray;
            if (obj instanceof JSONObject) {
                jsonObject = (JSONObject) obj;
                carsArray = (JSONArray) jsonObject.get("Cars");  // Assuming "Cars" is the key for the car data array
            } else {
                carsArray = (JSONArray) obj;  // Treat the entire object as an array
            }

            // Find the car to delete
            JSONObject carToDelete = null;
            for (Object carObject : carsArray) {
                JSONObject car = (JSONObject) carObject;
                if ((long) car.get("ID") == carId) {
                    carToDelete = car;
                    break;
                }
            }

            // Remove the car if found
            if (carToDelete != null) {
                carsArray.remove(carToDelete);

                // Write the updated JSON data back to the file
                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    if (carsArray.isEmpty()) {
                        // Handle empty array case (if the last car was deleted)
                        fileWriter.write("{}"); // Write an empty object
                    } else {
                        fileWriter.write(carsArray.toJSONString());
                    }
                    System.out.println("Car with ID " + carId + " deleted successfully.");
                }
            } else {
                System.out.println("Car with ID " + carId + " not found.");
            }

        } catch (IOException | ParseException e) {
            System.err.println("Error deleting car: " + e.getMessage());
        }
    }
}