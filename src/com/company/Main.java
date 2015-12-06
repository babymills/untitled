package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
private Connection con;
    public Main(){
        String url = "jdbc:mysql://localhost/tt";
        String name = "Max";
        String password = "11111";
        try {
            con = DriverManager.getConnection(url,name,password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String query = "SELECT * FROM `c` WHERE 1";
            ResultSet rs = st.executeQuery(query);
            printResults(rs);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResults(ResultSet rs) throws SQLException {
        String CNum, CName, City;
        int Ratting,SNum;
        while (rs.next()) {
            CNum = rs.getString("CNum");
            CName = rs.getString("CName");
            City = rs.getString("City");
            Ratting = rs.getInt("Rating");
            SNum = rs.getInt("SNum");
            System.out.println("******************************");
            System.out.println("CNum: " + CNum);
            System.out.println("CName: " + CName);
            System.out.println("Ratting: " + Ratting);
            System.out.println("SNum: " + SNum);
            System.out.println("comment: " + City);
            System.out.println("******************************");
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      Main a = new Main();
    }
}



