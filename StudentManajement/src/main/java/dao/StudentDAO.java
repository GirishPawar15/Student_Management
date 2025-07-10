package dao;

import utils.JDBC_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.JDBC_RDBMS;


public class StudentDAO {

    public static void createTable(String tbl, String sql)  {
        try (Connection con = JDBC_RDBMS.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table created (if not exists).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(String tableName,int Ro_No, String Name, String Add,String Mo_No,String E_Mail,String std,Double Preveous_Year_marks) {
    	
    	
        String query = "INSERT INTO " + tableName + " (Ro_No, Name, Add, Mo_No, E_Mail, std, Preveous_Year_marks) VALUES (?,?, ?, ?, ?, ?, ?)";
        try (Connection con = JDBC_RDBMS.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
        	ps.setInt(1, Ro_No);
            ps.setString(2, Name);
            ps.setString(3, Add);
            ps.setString(4, Mo_No);
            ps.setString(5, E_Mail);
            ps.setString(6, std);
            ps.setDouble(7, Preveous_Year_marks);
            ps.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(String tableName,int Ro_No, String Name, String Add,String Mo_No,String E_Mail,String std,Double Preveous_Year_marks) {
        String query = "UPDATE " + tableName + " SET Name=?, Add=?, Mo_No=?, E_Mail=?, std=?, Preveous_Year_marks=? WHERE Ro_No=?";
        try (Connection con = JDBC_RDBMS.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
        	ps.setInt(1, Ro_No);
            ps.setString(2, Name);
            ps.setString(3, Add);
            ps.setString(4, Mo_No);
            ps.setString(5, E_Mail);
            ps.setString(6, std);
            ps.setDouble(7, Preveous_Year_marks);
            ps.setInt(8, Ro_No); // For WHERE clause

            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No matching record found to update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    
    public static void deleteStudent(String tableName,int Ro_No) {
        String query = "DELETE FROM students WHERE Ro_No = ?";
        try (Connection con = JDBC_RDBMS.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) 
        {
            ps.setInt(1, Ro_No);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("\n Student deleted successfully!");
            } else {
                System.out.println("\n No Student found ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
    public static void showTable(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try (Connection con = JDBC_RDBMS.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nData from " + tableName + ":");
            System.out.println(" Ro_No| Name | Add | Mo_No | E_Mail | std | Preveous_Year_marks ");
            while (rs.next()) {
                System.out.println(
                    rs.getString("Ro_No") + " | " +
                    rs.getInt("Name") + " | " +
                    rs.getString("Add") + " | " +
                    rs.getString("Mo_No") + " | " +
                    rs.getString("E_Mail") + " | " +
                    rs.getString("std") + " | " +
                    rs.getString("Preveous_Year_marks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
