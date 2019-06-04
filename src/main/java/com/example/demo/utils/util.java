package com.example.demo.utils;

import com.example.demo.entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class util {
    public List<UserInfo> reader(){
        List<UserInfo> list = new ArrayList<UserInfo>();
        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Step 1: Loading or registering Oracle JDBC driver class
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {
            String msAccDB = "F:/Database11.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB;

            // Step 2.A: Create and get connection using DriverManager Class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // step 2.C: Executing SQL &retrieve data into ResultSet
            resultSet = statement.executeQuery("select * from userinfo");

            //processing returned data and printing into console
          /*  while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" +
                        resultSet.getString(2) + "\t" +
                        resultSet.getString(3));
            }*/
            while(resultSet.next()) {
                UserInfo uf = new UserInfo();
                uf.setId(resultSet.getInt(1));
                uf.setUsername(resultSet.getString(2));
                uf.setUserphone(resultSet.getString(3));
                list.add(uf);
                //uf = null;
                System.out.println(uf);
            }
           // System.out.print(list.get(1).getUsername());


        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        finally {
            // Step 3: Closing database connection
            try {
                if(null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }

        return list;
    }
}
