package com.piash;

public interface EmployeeDaoIntrf {
    //create employee
    public void createEmployee(Employee employee);
    //show all employees
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnId(int id);
    //update employee
    public void updateEmployee(int id, String name);
    //delete employee
    public void deleteEmployee(int id);
}
