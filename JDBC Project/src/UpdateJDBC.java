import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateJDBC {
     //Driver
     private static final String URL = "jdbc:mysql://localhost:3306/dbmarket";
     private static final String USER = "root";
     private static final String PASSWORD = "";
 
     
     public static void updateKaryawanCredentials(Scanner scanner) {
         try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
             String sql = "UPDATE karyawan SET Username = ?, Password = ? WHERE NoId = ?";
             try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                 System.out.println("----UPDATE DATA LOGIN PEGAWAI----");
                 System.out.print("No. ID karyawan: ");
                 int noId = scanner.nextInt();
                 
                 System.out.print("new username: ");
                 String newUsername = scanner.next();
 
                 System.out.print("new password: ");
                 String newPassword = scanner.next();
 
                 preparedStatement.setString(1, newUsername);
                 preparedStatement.setString(2, newPassword);
                 preparedStatement.setInt(3, noId);
 
                 int rowsAffected = preparedStatement.executeUpdate();
 
                 if (rowsAffected > 0) {
                     System.out.println("Data login karyawan diupdate!");
                 } else {
                     System.out.println("tidak ditemukan data karyawan dengan no. id tersebut");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }

