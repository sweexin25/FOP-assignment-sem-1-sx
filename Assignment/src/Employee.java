/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sweex
 */
public class Employee{
    private String employeeID;
    private String employeeName;
    private String role;
    private String password;


    public Employee(String inEmployeeID, String inEmployeeName, String inRole, String inPassword ){
        employeeID = inEmployeeID;
        employeeName =inEmployeeName;
        role = inRole;
        password = inPassword;

    }
    public String getEmployeeID(){
        return employeeID;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public String getRole(){
        return role;
    }
    public String getPassword(){
        return password;
    }
}
