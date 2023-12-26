import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/dbmarket";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deleteKaryawanById() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM karyawan WHERE NoId = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.println("----MENGHAPUS DATA LOGIN KARYAWAN----");
                System.out.print("Masukkan Id karyawan untuk dihapus: ");
                int idKaryawan = del.nextInt();
                preparedStatement.setInt(1, idKaryawan);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("data pegawai berhasil dihapus!");
                } else {
                    System.out.println("tidak ditemukan data pegawai dengan id tersebut.");
                }
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

