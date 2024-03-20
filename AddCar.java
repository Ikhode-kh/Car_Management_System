import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class AddCar {
    private int id;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String maintenace_stat;
    private int price;

    public AddCar(int id, String make, String model, int year, int mileage, String maintenace_stat, int price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.maintenace_stat = maintenace_stat;
        this.price = price;
    }

    public static void main(String[] args) {
        ArrayList<AddCar> CarList = new ArrayList<AddCar>();
        AddCar car1 = new AddCar(1, "Toyota", "Camry", 2020, 25000, "Good", 25000);
        AddCar car2 = new AddCar(2, "Honda", "Civic", 2018, 30000, "Fair", 20000);
        AddCar car3 = new AddCar(3, "Ford", "Escape", 2022, 15000, "Excellent", 30000);
        AddCar car4 = new AddCar(4, "Tesla", "Y", 2023, 330, "Good", 54130);
        AddCar car5 = new AddCar(5, "Toyota", "Prius", 2024, 56000, "Good", 93800);
        AddCar car6 = new AddCar(6, "Byd", "Seal U", 2024, 500, "Good", 45000);
        AddCar car7 = new AddCar(7, "Lamborghini", "Aventador", 2022, 16000, "Excellent", 507353);
        AddCar car8 = new AddCar(8, "BMW", "X1 SUV", 2024, 20000, "Excellent", 40500);
        AddCar car9 = new AddCar(9, "Tesla", "Cyber Truck", 2023, 550000, "Excellent", 60990);
        AddCar car10 = new AddCar(10, "Lexus", "LX 570", 2022, 10000, "Good", 88245);
        CarList.add(car1);
        CarList.add(car2);
        CarList.add(car3);
        CarList.add(car4);
        CarList.add(car5);
        CarList.add(car6);
        CarList.add(car7);
        CarList.add(car8);
        CarList.add(car9);
        CarList.add(car10);

        // create object to put label (keys , value)
        JSONObject mainObj = new JSONObject();
        // json object will store value of json array
        JSONArray jArr = new JSONArray();
        mainObj.put("Cars", jArr);

        for (AddCar car : CarList) {
            // loop for store attribute to each car
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Price", car.price);
            jsonObj.put("Maintenace_stat", car.maintenace_stat);
            jsonObj.put("Mileage", car.mileage);
            jsonObj.put("Year", car.year);
            jsonObj.put("Model", car.model);
            jsonObj.put("Make", car.make);
            jsonObj.put("Id", car.id);
            jArr.add(jsonObj);
            // json array will store this array object
        }
        // //Map the Arraylist
        // Map<String , ArrayList<AddCar>> cars = new HashMap<>();
        // cars.put("Cars", CarList);
        // //output JSON that is nicely formatted
        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //
        // //converts a map of Car obj into its JSON
        // String json = gson.toJson(cars);

        // Declare file path
        String fileStore = "Car_DataStorage.json";

        // Write data to the existing JSON file
        try (Writer writeData = new FileWriter(fileStore)) {
            // write json object to json string to file
            writeData.write(mainObj.toJSONString());
            System.out.println("Succesfull write to Json" + fileStore);
            writeData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
