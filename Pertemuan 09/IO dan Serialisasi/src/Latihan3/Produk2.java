package Latihan3;

import java.io.Serializable;

// Kelas Produk untuk Serialisasi
class Produk2 implements Serializable {
    // Memberikan serialVersionUID adalah praktik yang baik, meskipun opsional
    private static final long serialVersionUID = 1L; 

    private String namaProduk;
    private double harga;
    private int stok;
    
    public Produk2(String namaProduk, double harga, int stok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + namaProduk + ", Harga: " + harga + ", Stok: " + stok);
    }
    
    // Override toString() untuk membantu simpanKeFileTeks
    @Override
    public String toString() {
        // Format yang mudah diparsing: CSV
        return namaProduk + "," + harga + "," + stok;
    }
}