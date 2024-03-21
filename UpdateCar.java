import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

class Car {
    private String id;
    private String model;
    private int modelYear;
    private String carClass;
    private int units;
    private double price;
    private String manufacturer;

    public Car(String id, String model, int modelYear, String carClass, int units, double price, String manufacturer) {
        this.id = id;
        this.model = model;
        this.modelYear = modelYear;
        this.carClass = carClass;
        this.units = units;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getCarClass() {
        return carClass;
    }

    public int getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

class CarManagementSystems {
    public void updateCar(String id, String newModel, int newModelYear, String newCarClass, int newUnits, double newPrice, String newManufacturer) {

    }
}

public class UpdateCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarManagementSystems cms = new CarManagementSystems();

        // Read data from JSON file
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Car_DataStorage.json"));
            JSONArray carsArray = (JSONArray) jsonObject.get("Cars");

            // Populate Car objects from JSON data
            for (Object obj : carsArray) {
                JSONObject carJson = (JSONObject) obj;
                String id = String.valueOf(carJson.get("Id"));
                String model = (String) carJson.get("Model");
                int modelYear = ((Long) carJson.get("Model_Year")).intValue(); // corrected key
                String carClass = (String) carJson.get("Class");
                int units = ((Long) carJson.get("Units")).intValue();
                double price = ((Number) carJson.get("Price")).doubleValue();
                String manufacturer = (String) carJson.get("Manufacturer");
            
                // Create Car object and add it to CarManagementSystem
                Car car = new Car(id, model, modelYear, carClass, units, price, manufacturer);
                cms.updateCar(id, model, modelYear, carClass, units, price, manufacturer); // corrected method name
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Update car
        System.out.print("Enter car ID to update: ");
        String updateId = scanner.nextLine();
        System.out.print("Enter new model: ");
        String newModel = scanner.nextLine();
        System.out.print("Enter new model year: ");
        int newModelYear = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new car class: ");
        String newCarClass = scanner.nextLine();
        System.out.print("Enter new units: ");
        int newUnits = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new manufacturer: ");
        String newManufacturer = scanner.nextLine();
        cms.updateCar(updateId, newModel, newModelYear, newCarClass, newUnits, newPrice, newManufacturer);
    }
}
// System.out.println("Updating car with ID: " + id);
//         System.out.println("New Model: " + newModel);
//         System.out.println("New Model Year: " + newModelYear);
//         System.out.println("New Car Class: " + newCarClass);
//         System.out.println("New Units: " + newUnits);
//         System.out.println("New Price: " + newPrice);
//         System.out.println("New Manufacturer: " + newManufacturer);