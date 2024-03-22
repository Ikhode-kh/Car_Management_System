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
        int choice;
        do {
            System.out.println("Car Management System");
            System.out.println("1. Search cars by make");
            System.out.println("2. Read cars from JSON file");
            System.out.println("3. Add a car to JSON file");
            System.out.println("4. delete a car from JSON file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Handle input mismatch exceptions
            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                choice = 0; // Set choice to an invalid value to continue the loop
            }

            switch (choice) {
                case 1:
                    SearchSystem();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    addCar();
                    break;
                case 4:
                    deleteCar();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private void SearchSystem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter make to search: ");
            String make = scanner.nextLine();
            CarSearch.SearchByManufacture(make);
        }
    }

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
        try {
            createCar.CreateNewCar();
        } catch (ParseException e) {
            System.out.println(e.getMessage().toString());
        }
    }

    private void deleteCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of the car to delete: ");
        int carId = scanner.nextInt();
        CarDeletion.deleteCar("Car_DataStorage.json", carId); // Replace with your actual file path
        scanner.close();
    }
}
