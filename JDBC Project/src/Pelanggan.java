public class Pelanggan implements aciakMart {
     public String nama;
    public String noHp;
    public String noFaktur;
    public String namaBarang;
    public double hargaBarang;
    public int jumlahBeli;
    public String kasir;

    public Pelanggan(String nama, String noHp, String kasir) {
        this.nama = nama;
        this.noHp = noHp;
        this.kasir = kasir;
    }

    @Override
    public void namaPelanggan(String nama) {
        this.nama = nama;
    }

    @Override
    public void noHp(String noHp) {
        this.noHp = noHp;
    }

   @Override
   public void namaKasir(String kasir){
        this.kasir = kasir;
   }

    @Override
    public void namaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    @Override
    public void hargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    @Override
    public void jumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    @Override
    public double totalBayar() {
        return hargaBarang * jumlahBeli;
    }
}
