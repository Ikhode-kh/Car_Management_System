import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCar {
    int id;
    String make;
    String model;
    int year;
    int mileage;
    String maintenace_stat;
    int price;

    public void addCar() {
        ArrayList<AddCar> carList = new ArrayList<>();

        Scanner ent = new Scanner(System.in);
        System.out.println("How many car you want to Input: ");
        int number = ent.nextInt();
        JSONArray jArr = new JSONArray();
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Car :" + (i + 1) + ":");
            System.out.print("ID: ");
            id = ent.nextInt();
            ent.nextLine(); // Consume newline character

            System.out.print("Make: ");
            make = ent.nextLine();

            System.out.print("Model: ");
            model = ent.nextLine();

            System.out.print("Year: ");
            year = ent.nextInt();

            System.out.print("Mileage: ");
            mileage = ent.nextInt();
            ent.nextLine(); // Consume newline character

            System.out.print("Maintenance Status: ");
            maintenace_stat = ent.nextLine();

            System.out.print("Price: ");
            price = ent.nextInt();

            JSONObject carJson = new JSONObject();
            carJson.put("Id", id);
            carJson.put("Make", make);
            carJson.put("Model", model);
            carJson.put("Year", year);
            carJson.put("Mileage", mileage);
            carJson.put("Maintenance Status", maintenace_stat);
            carJson.put("Price", price);
            jArr.add(carJson);

        }
        JSONObject mainObj = new JSONObject();
        mainObj.put("Cars", jArr);

        String fileStore = "Car_DataStorage.json";

        try (Writer writeData = new FileWriter(fileStore)) {
            writeData.write(mainObj.toJSONString());
            System.out.println("Successfully wrote to JSON: " + fileStore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
