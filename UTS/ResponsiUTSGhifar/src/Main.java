public class Main {
    public static void main(String[] args) {
        // Produk
        Produk p1 = new Elektronik("Laptop", 15000000, 2);
        Produk p2 = new Makanan("Snack", 15000, "2023-12-30");

        // Pegawai
        Pegawai peg1 = new PegawaiTetap("Ghifari", 5000000, 1000000);
        Pegawai peg2 = new PegawaiKontrak("Andi", 3000000, 12);

        // Output Produk
        System.out.println("=== Output Produk ===");
        p1.tampilkanInfo();
        System.out.println();
        p2.tampilkanInfo();

        // Output Pegawai
        System.out.println("\n=== Output Pegawai ===");
        peg1.tampilkanInfo();
        System.out.println();
        peg2.tampilkanInfo();
    }
}