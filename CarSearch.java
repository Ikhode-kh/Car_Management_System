import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class CarSearch {

    public static void SearchByManufacture(String manufacturer) {
        try {
            JSONArray jsonArray = Read_Json.readJsonArrayFromFile("Car_DataStorage.json");
            // System.out.println("JSON Array: " + jsonArray);

            // Example usage of search function
            JSONArray carsByManufacturer = searchByManufacturer(jsonArray, manufacturer);
            if (carsByManufacturer.size() > 0) {
                System.out.println("Cars found:");
                System.out.printf("%-5s %-12s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Model Year", "Price", "Class",
                        "Units", "Model", "Manufacturer");
                for (Object obj : carsByManufacturer) {
                    JSONObject car = (JSONObject) obj;
                    System.out.printf("%-5s %-12s %-10s %-10s %-10s %-10s %-10s\n", car.get("Id"),
                            car.get("Model_Year"), car.get("Price"), car.get("Class"), car.get("Units"),
                            car.get("Model"), car.get("Manufacturer"));
                }
            } else {
                System.out.println("No cars found for the specified manufacturer.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONArray searchByManufacturer(JSONArray jsonArray, String manufacturerName) {
        JSONArray result = new JSONArray();

        for (Object obj : jsonArray) {
            JSONObject car = (JSONObject) obj;
            String manufacturer = (String) car.get("Manufacturer");
            if (manufacturer.equalsIgnoreCase(manufacturerName)) {
                result.add(car);
            }
        }

        return result;
    }

    // public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
    //     JSONParser parser = new JSONParser();
    //     Object obj = parser.parse(new FileReader(fileName));
    //     JSONObject jsonObj = (JSONObject) obj;

    //     return (JSONArray) jsonObj.get("Cars");
    // }
}
