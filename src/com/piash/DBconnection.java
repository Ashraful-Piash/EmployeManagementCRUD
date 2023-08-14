package com.piash;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    static Connection con;

    public static Connection createDBConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/employeeDB";
            String userName = "root";
            String passWord ="Piash328911*#*";
            con = DriverManager.getConnection(url,userName,passWord);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("not established");
        }
        return con;

    }
}
