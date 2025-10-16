package DAY2;

import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    void getDetails(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        salary = sc.nextDouble();
    }

    void displayDetails()
    {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);

    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println(" Enter details for Employee " + (i + 1) + ":");
            emp[i] = new Employee();
            emp[i].getDetails(sc);
        }
        System.out.println(" Employee Details ");
        for (int i = 0; i < n; i++) {
            emp[i].displayDetails();
        }
        sc.close();
    }
}