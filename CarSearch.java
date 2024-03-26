import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class CarSearch {

    public static void SearchByManufacture() {
        String Manufacture;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter make to search: ");
            Manufacture = scanner.nextLine();
        }
        try {
            JSONArray jsonArray = Read_Json.readJsonArrayFromFile("Car_DataStorage.json");
            // System.out.println("JSON Array: " + jsonArray);

            // Example usage of search function
            JSONArray carsByManufacture = searchByManufacture(jsonArray, Manufacture);
            if (carsByManufacture.size() > 0) {
                System.out.println("Cars found:");
                System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Price", "Class",
                        "Units", "Model", "Manufacture");
                for (Object obj : carsByManufacture) {
                    JSONObject car = (JSONObject) obj;
                    System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", car.get("ID"), car.get("Price"),
                            car.get("Class"), car.get("Units"),
                            car.get("Model"), car.get("Manufacture"));
                }
            } else {
                System.out.println("No cars found for the specified Manufacture.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONArray searchByManufacture(JSONArray jsonArray, String ManufactureName) {
        JSONArray result = new JSONArray();

        for (Object obj : jsonArray) {
            JSONObject car = (JSONObject) obj;
            String Manufacture = (String) car.get("Manufacture");
            if (Manufacture.equalsIgnoreCase(ManufactureName)) {
                result.add(car);
            }
        }

        return result;
    }

}
