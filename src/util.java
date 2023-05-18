import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Util {
    private static final String DATABASE_FILE = "database.txt";
    
    public void addEmployee() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Employee Birthdate (yyyy-MM-dd): ");
            String birthdate = scanner.nextLine();
            
            System.out.print("Enter Employee Hourly Wage: ");
            String wage = scanner.nextLine();

            Properties properties = new Properties();
            Path dbPath = Paths.get(DATABASE_FILE);

            if (Files.exists(dbPath)) {
                properties.load(new FileInputStream(DATABASE_FILE));
            }

            properties.setProperty(name, birthdate + "," + wage);

            properties.store(new FileOutputStream(DATABASE_FILE), null);

            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void removeEmployee() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Employee Name to remove: ");
            String name = scanner.nextLine();

            Properties properties = new Properties();
            properties.load(new FileInputStream(DATABASE_FILE));

            if (properties.remove(name) != null) {
                properties.store(new FileOutputStream(DATABASE_FILE), null);
                System.out.println("Employee removed successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (IOException e) {
            System.out.println("Error removing employee: " + e.getMessage());
        }
    }

    public void calculateTotalPayroll() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(DATABASE_FILE));

            double totalPayroll = 0.0;
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                String[] data = value.split(",");
                double wage = Double.parseDouble(data[1]);
                // Assuming each employee works 160 hours per month
                totalPayroll += wage * 160;
            }

            System.out.println("Total Payroll for this month: " + totalPayroll);

        } catch (IOException e) {
            System.out.println("Error calculating payroll: " + e.getMessage());
        }
    }

    public void displaySchedule() {
        // This method requires more specific requirements.
        // As an example, I'm just printing all the employee names.
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(DATABASE_FILE));

            System.out.println("Employee Schedule:");
            for (String key : properties.stringPropertyNames()) {
                System.out.println("Employee Name: " + key);
            }

        } catch (IOException e) {
            System.out.println("Error displaying schedule: " + e.getMessage());
        }
    }
}
