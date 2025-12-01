/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sweex
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class Login {
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);

    ArrayList <Employee> staffList = new ArrayList<>();
    // 2. LOAD DATA FROM FILE (The New Part)
    try {
        Scanner fileScanner = new Scanner(new File("employee.csv"));

        // Skip the header line if your CSV has one (e.g., "ID,Name,Role,Pass")
        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine(); 
        }

        // Loop through the whole file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine(); // Read one line: "C6001,Tan,Manager,a2b1c0"
            String[] details = line.split(",");   // Cut it into pieces at every comma

            // Ensure the line has enough data before trying to use it
            if (details.length == 4) {
                String id = details[0].trim();       // .trim() removes accidental spaces
                String name = details[1].trim();
                String role = details[2].trim();
                String password = details[3].trim();

                // Create the object and add to list
                Employee newStaff = new Employee(id, name, role, password);
                staffList.add(newStaff);
            }
        }
        fileScanner.close();
        System.out.println("System loaded. " + staffList.size() + " employees found.");

    } catch (FileNotFoundException e) {
        System.out.println("Error: 'employees.csv' file not found.");
        // We exit the program because we can't login without data!
        return; 
    }
    System.out.println("=== Employee Login ===");
    System.out.print("Enter User ID: ");
    String inputID = sc.nextLine();

    System.out.print("Enter Password: ");
    String inputPassword = sc.nextLine();

    System.out.println("\n");

    boolean isEmployee = false;
    for (int i = 0; i< staffList.size(); i++){
      Employee currentStaff = staffList.get(i);

      if (inputID.equals(currentStaff.getEmployeeID()) && inputPassword.equals(currentStaff.getPassword())){
        System.out.println("Login Sucessful!");
        System.out.println("Welcome, "+ currentStaff.getEmployeeName() + " ("+  currentStaff.getEmployeeID()+ ")");
        isEmployee =true;
      break;
    } 
  }
    if (!isEmployee){
      System.out.println("Login Failed: Invalid User ID or Password.");
    }

}
}
