package com.piash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee Management Application");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee Based On Id\n" +
                    "4. Update Employee\n" +
                    "5. Delete Employee\n");
            System.out.println("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Employee employee = new Employee();
                    System.out.println("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Salary");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setAge(age);
                    dao.createEmployee(employee);
                    break;

                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter Employee Id To See Details: ");
                    int employeeId = scanner.nextInt();
                    dao.showEmployeeBasedOnId(employeeId);
                    break;
                case 4:
                    System.out.println("Enter Id to Update Name: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new Name: ");
                    String empName = scanner.nextLine();
                    dao.updateEmployee(empId,empName);
                    break;
                case 5:
                    System.out.println("Enter Id to Delete That employee: ");
                    int empId1 = scanner.nextInt();
                    dao.deleteEmployee(empId1);
                    break;

                case 6:
                    System.out.println("Thanks for using our app");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
            }

        } while (true);

    }
}
