import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

public class AddCar {
    int id;
    String Manufacture;
    String model;
    int year;
    int units;
    String Class;
    int price;

    public void addCar() {

        HashMap<String, Object> Carlist = new HashMap<String, Object>();
        Scanner ent = new Scanner(System.in);
        System.out.println("How many car you want to Input: ");
        int number = ent.nextInt();
        JSONArray jArr = new JSONArray();
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Car :" + (i + 1) + ":");
            System.out.print("ID: ");
            id = ent.nextInt();
            ent.nextLine(); // Consume newline character

            System.out.print("Manufacturer: ");
            Manufacture = ent.nextLine();

            System.out.print("Model: ");
            model = ent.nextLine();

            System.out.print("Year: ");
            year = ent.nextInt();

            System.out.print("Units: ");
            units = ent.nextInt();
            ent.nextLine(); // Consume newline character

            System.out.print("Class: ");
            Class = ent.nextLine();

            System.out.print("Price: ");
            price = ent.nextInt();

            // JSONObject carJson = new JSONObject();
            Carlist.put("Id", id);
            Carlist.put("Manufacturere", Manufacture);
            Carlist.put("Model", model);
            Carlist.put("Year", year);
            Carlist.put("Units", units);
            Carlist.put("Class", Class);
            Carlist.put("Price", price);
            jArr.add(Carlist);

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

        ent.close();
    }

}
