package org.example;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        storedProcedureWithParam();
    }
    public static void readRecords()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        String query = "Select * From Employee";

        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Id is " + resultSet.getInt(1));
            System.out.println("Name is "+ resultSet.getString(2));
            System.out.println("Salary is "+ resultSet.getInt(3));
            System.out.println();
        }
        connection.close();
    }

    public static void insertRecords()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        String query = "insert into Employee values(2,'Pandeesh',20000)";

        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("Number of Rows Affected : " + rowsAffected);

        connection.close();
    }

    public static void insert()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        int id = 4;
        String name = "Viji";
        int salary = 25000;

        // one way of query construction

//        String query = "insert into Employee values("+id+",'"+name+"',"+salary+");";
//
//        Connection connection = DriverManager.getConnection(url,userName,password);
//        Statement statement = connection.createStatement();
//        int rowsAffected = statement.executeUpdate(query);
//        System.out.println("Number of Rows Affected : " + rowsAffected);

        // another way

        String query = "insert into Employee values(?,?,?)";

        Connection connection = DriverManager.getConnection(url,userName,password);

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,salary);

        int rowsAffected = statement.executeUpdate();
        System.out.println("Number of Rows Affected : " + rowsAffected);

        connection.close();
    }

    public static void delete()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        int id = 2;
        String query = "delete from Employee where id = "+id;

        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("Number of Rows Affected : " + rowsAffected);

        connection.close();
    }


    public static void update()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        String query = "update Employee set salary=23000 where id = 1";

        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("Number of Rows Affected : " + rowsAffected);

        connection.close();
    }

    // types of statement
    // normal statement
    // prepared statement
    // callable statement


    // calling simple stored procedure

    public static void storedProcedure()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        String query = "Select * From Employee";

        Connection connection = DriverManager.getConnection(url,userName,password);
        CallableStatement callableStatement = connection.prepareCall("{call GetEmployee()}");
        ResultSet resultSet = callableStatement.executeQuery();

        while (resultSet.next()){
            System.out.println("Id is " + resultSet.getInt(1));
            System.out.println("Name is "+ resultSet.getString(2));
            System.out.println("Salary is "+ resultSet.getInt(3));
            System.out.println();
        }

        connection.close();
    }


    public static void storedProcedureWithParam()throws Exception{
        String url = "jdbc:mysql://localhost:3306/JDBCDemo";
        String  userName = "root";
        String password = "Arun@123";

        String query = "Select * From Employee";

        Connection connection = DriverManager.getConnection(url,userName,password);
        CallableStatement callableStatement = connection.prepareCall("{call GetEmployeeById(?)}");
        callableStatement.setInt(1,1);
        ResultSet resultSet = callableStatement.executeQuery();

        while (resultSet.next()){
            System.out.println("Id is " + resultSet.getInt(1));
            System.out.println("Name is "+ resultSet.getString(2));
            System.out.println("Salary is "+ resultSet.getInt(3));
            System.out.println();
        }

        connection.close();
    }
}
