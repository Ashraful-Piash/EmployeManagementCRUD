package com.piash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection connection;

    @Override
    public void createEmployee(Employee employee) {
        connection = DBconnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getAge());
            int count = preparedStatement.executeUpdate();
            if (count != 0)
                System.out.println("Employee : " + employee.getName() + " Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void showAllEmployee() {
        connection = DBconnection.createDBConnection();
        String query = "select * from employee";
        System.out.println("Employee Details: ");
        System.out.format("%s\t%s\t%s\t%s\n", "Id", "Name", "Salaray", "Age");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        connection = DBconnection.createDBConnection();
        String query = "select * from employee where id=" + id;
        System.out.println("Employee Details: ");
        System.out.format("%s\t%s\t%s\t%s\n", "Id", "Name", "Salaray", "Age");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                System.out.println("No such Id Found In the Database");
                return;
            }


            do {
                System.out.format("%d\t%s\t%f\t%d\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4)
                );
            } while (resultSet.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        connection = DBconnection.createDBConnection();
        String query = "update employee set name = ? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int count = preparedStatement.executeUpdate();
            if (count != 0)
                System.out.println("Employee details updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        connection = DBconnection.createDBConnection();
        String query = "delete from employee where id=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int count = preparedStatement.executeUpdate();
            if(count!=0)
                System.out.println("Employe with id: "+id +" deleted Successfully");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
