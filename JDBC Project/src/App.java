import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //update username dan password
        Scanner scan = new Scanner(System.in);
        UpdateJDBC.updateKaryawanCredentials(scan);
        System.out.println("");
 
        //membuat data pegawai baru
        Scanner scanner = new Scanner(System.in);
        CreateJDBC.insertDataKaryawan(scanner);
        System.out.println("");
         
        //hapus pegawai
        DeleteJDBC.deleteKaryawanById();
        System.out.println("");

        login login = new login();
        login.login();
        
        try {
            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scan.nextLine();
            
            System.out.print("Masukkan nomor HP: ");
            String noHp = scan.nextLine();

            System.out.print("Masukkan nama Kasir: ");
            String namaKasir = scan.nextLine();

            Penjualan penjualan = new Penjualan(namaPelanggan, noHp, namaKasir);

            System.out.print("Masukkan nama barang: ");
            penjualan.namaBarang(scan.nextLine());

            System.out.print("Masukkan harga barang: ");
            penjualan.hargaBarang(Double.parseDouble(scan.nextLine()));

            System.out.print("Masukkan jumlah beli: ");
            penjualan.jumlahBeli(Integer.parseInt(scan.nextLine()));

            // Menampilkan informasi
            System.out.println("\nACIAK MART");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
            System.out.println("Tanggal        : " + dtf.format(now));
                DateTimeFormatter jam = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("Waktu          : " + jam.format(now) + "WIB");
            System.out.println("================================");
            System.out.println("DATA PELANGGAN");
            System.out.println("----------------------");
            System.out.println("Nama Pelanggan: " + penjualan.nama);
            System.out.println("Nomor HP: " + penjualan.noHp);
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println("DATA PEMBELIAN BARANG");
            System.out.println("----------------------");
            System.out.println("Nama Barang: " + penjualan.namaBarang);
            System.out.println("Harga Barang: " + penjualan.hargaBarang);
            System.out.println("Jumlah Beli: " + penjualan.jumlahBeli);
            System.out.println("Total Bayar: " + penjualan.totalBayar());
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println("kasir: " + penjualan.kasir );

            scan.close();
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
