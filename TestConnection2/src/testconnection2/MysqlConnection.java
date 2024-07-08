/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ajays
 */
package testconnection2;

import java.sql.*;

public class MysqlConnection {

    public static void main(String[] args) {
        Connection con = null;
        try {
            //loading the driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            //When the connection is established the driver manager return the instance of connection
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "Mayank@123");
            System.out.println("Connection established");
            //Query which we want to execute
            String query = "SELECT * FROM students where id=?";
            PreparedStatement prepare = con.prepareStatement(query);
            //now set values one by one. 1 for 1st ,2 for 2nd ...
            //fetching the data with id 1
            prepare.setInt(1, 1);

            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                double marks = result.getDouble("marks");

                System.out.println("name is:" + name);
                System.out.println("Age is:" + age);
                System.out.println("Marks:" + marks);

            } else {
                System.out.println("Not found");

            }
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Exception is:" + e.getMessage());
        } 
        catch (SQLException e) {
            System.out.println("SQL Exception is:" + e.getMessage());
        }
        try {
            con.close();
        } 
        catch (SQLException e) {
            System.out.println("Exception is:" + e.getMessage());
        }
    }
}
