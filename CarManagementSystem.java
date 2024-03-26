import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class carManagementSystem {

    public static void main(String[] args) {
        carManagementSystem system = new carManagementSystem();
        system.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("Car Management System");
            System.out.println("1. Search cars by Manufacturer");
            System.out.println("2. Read cars from JSON file");
            System.out.println("3. Add a car to JSON file");
            System.out.println("4. delete a car from JSON file");
            System.out.println("5. Update a car from JSON file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Handle input mismatch exceptions
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the entire line to clear the buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to clear the buffer
                choice = 0; // Set choice to an invalid value to continue the loop
            }

            switch (choice) {
                case 1:
                    CarSearch.SearchByManufacture(scanner);
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    addCar();
                    break;
                case 4:
                    deleteCar(scanner);
                    break;
                case 5:
                    UpdateCar();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        // Close the scanner after the loop
        scanner.close();
    }

    // private void SearchSystem() {
    // CarSearch.SearchByManufacture();
    // }

    public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObj = (JSONObject) obj;

        return (JSONArray) jsonObj.get("Cars");
    }

    private void read() {
        Car_read.read();
    }

    private void addCar() {
        String _filepath = "Car_DataStorage.json";
        AddCar createCar = new AddCar(0, _filepath, _filepath, 0, 0, _filepath, 0);
        // createCar.addCar();
        createCar.CreateNewCar();
    }

    private void deleteCar(Scanner scanner) {
        System.out.print("Enter ID of the car to delete: ");

        // Handle input mismatch exceptions
        try {
            int carId = scanner.nextInt();
            CarDeletion.deleteCar("Car_DataStorage.json", carId);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid car ID.");
            scanner.next(); // Consume the invalid input
        }
    }

    private void UpdateCar() {
        CarUpdate.modifyCar("Car_DataStorage.json");
    }
}
