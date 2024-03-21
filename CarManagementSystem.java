import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
            System.out.println("4. Delete a car from JSON file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void SearchSystem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter make to search: ");
            String make = scanner.nextLine();
            CarSearch.SearchCar(make);
        }
    }

    public static JSONArray readJsonArrayFromFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObj = (JSONObject) obj;

        return (JSONArray) jsonObj.get("Cars");
    }
    private void read(){
        Car_read.read();
    }
    

    @SuppressWarnings("unchecked")
    private void addCar() {
        // AddCar.main(null);

        try (Scanner ent = new Scanner(System.in)) {
            System.out.println("Enter Car ID: ");
            int id = ent.nextInt();
            ent.nextLine();
            System.out.println("Enter Car Make: ");
            String make = ent.nextLine();

            System.out.println("Enter Car model: ");
            String model = ent.nextLine();

            System.out.println("Enter Car year: ");
            int year = ent.nextInt();
            System.out.println("Enter Car mileage: ");
            int mileage = ent.nextInt();
            ent.nextLine();
            System.out.println("Enter Car Maintenace status: ");
            String maintenace_stat = ent.nextLine();

            System.out.println("Enter Car Price: ");
            int price = ent.nextInt();

            AddCar newCar = new AddCar(id, make, model, year, mileage, maintenace_stat, price);
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Price", newCar.price);
            jsonObj.put("Maintenace_stat", newCar.maintenace_stat);
            jsonObj.put("Mileage", newCar.mileage);
            jsonObj.put("Year", newCar.year);
            jsonObj.put("Model", newCar.model);
            jsonObj.put("Make", newCar.make);
            jsonObj.put("Id", newCar.id);
            String filepath = "Car_DataStorage.json";
            try (Writer writeData = new FileWriter(filepath, true)) {
                writeData.write(jsonObj.toJSONString() + "\n"); // Append new car data to the file
                System.out.println("Successfully added new car to JSON file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of the car to delete: ");
        int carId = scanner.nextInt();
        scanner.close();
        CarDeletion.deleteCar("Car_DataStorage.json", carId);
    }
}
