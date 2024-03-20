import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarSearch {
    public static void main(String[] args) {
        try {
            JSONArray jsonArray = readJsonArrayFromFile("Car_DataStorage.json");
            // System.out.println("JSON Array: " + jsonArray);

            // Example usage of search function
            JSONArray carsByMake = searchByMake(jsonArray, "Toyota");
            if (carsByMake.size() > 0) {
                System.out.println("Cars found:");
                System.out.printf("%-5s %-10s %-10s\n", "ID", "Make", "Price");
                for (Object obj : carsByMake) {
                    JSONObject car = (JSONObject) obj;
                    System.out.printf("%-5s %-10s %-10s\n", car.get("Id"), car.get("Make"), car.get("Price"));
                }
            } else {
                System.out.println("No cars found for the specified make.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void SearchCar(String CompanyName) {
        try {
            JSONArray jsonArray = readJsonArrayFromFile("Car_DataStorage.json");
            // System.out.println("JSON Array: " + jsonArray);

            // Example usage of search function
            JSONArray carsByMake = searchByMake(jsonArray, CompanyName);
            if (carsByMake.size() > 0) {
                System.out.println("Cars found:");
                System.out.printf("%-5s %-10s %-10s\n", "ID", "Make", "Price");
                for (Object obj : carsByMake) {
                    JSONObject car = (JSONObject) obj;
                    System.out.printf("%-5s %-10s %-10s\n", car.get("Id"), car.get("Make"), car.get("Price"));
                }
            } else {
                System.out.println("No cars found for the specified make.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObj = (JSONObject) obj;

        return (JSONArray) jsonObj.get("Cars");
    }

    @SuppressWarnings("unchecked")
    public static JSONArray searchByMake(JSONArray jsonArray, String makeName) {
        JSONArray result = new JSONArray();

        for (Object obj : jsonArray) {
            JSONObject car = (JSONObject) obj;
            String make = (String) car.get("Make");
            if (make.equalsIgnoreCase(makeName)) {
                result.add(car);
            }
        }

        return result;
    }
}
