
import java.util.Scanner;
import java.util.ArrayList;

class updateCar {
    private String id;
    private String model;
    private int year;
    private String make;
    private double price;
    private boolean maintenanceStatus;

    public Car(String id, String model, int year, String make, double price, boolean maintenanceStatus) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.make = make;
        this.price = price;
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    public boolean getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaintenanceStatus(boolean maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }
}

class CarManagementSystem {
    private ArrayList<Car> cars;

    public CarManagementSystem() {
        this.cars = new ArrayList<>();
    }

    public void updateCar(String id, String newModel, int newYear, String newMake, double newPrice, boolean newMaintenanceStatus) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.setModel(newModel);
                car.setYear(newYear);
                car.setMake(newMake);
                car.setPrice(newPrice);
                car.setMaintenanceStatus(newMaintenanceStatus);
                System.out.println("Car updated successfully.");
                return;
            }
        }
        System.out.println("Car not found with ID: " + id);
    }
}

public class UpdateCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarManagementSystem cms = new CarManagementSystem();

        System.out.print("Enter car ID to update: ");
        String updateId = scanner.nextLine();
        System.out.print("Enter new model: ");
        String newModel = scanner.nextLine();
        System.out.print("Enter new year: ");
        int newYear = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new make: ");
        String newMake = scanner.nextLine();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new maintenance status (true/false): ");
        boolean newMaintenanceStatus = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        cms.updateCar(updateId, newModel, newYear, newMake, newPrice, newMaintenanceStatus);
    }
}
