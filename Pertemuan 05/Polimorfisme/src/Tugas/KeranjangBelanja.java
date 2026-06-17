/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author Ahmad Ghifari
 */
import java.util.ArrayList;
import java.util.List;

public class KeranjangBelanja {

    private List<Produk> daftarProduk;

    public KeranjangBelanja() {
        this.daftarProduk = new ArrayList<>();
    }

    public void tambahProduk(Produk produk) {
        this.daftarProduk.add(produk);
    }
    
    public double hitungDanTampilkanTotal() {
        double totalBayar = 0;
        
        System.out.println("--- Detail Harga dan Diskon ---");
        
        for (Produk produk : daftarProduk) {
            double hargaAsli = produk.getHarga();
            double diskon = produk.hitungDiskon();
            double hargaFinal = hargaAsli - diskon;
            
            System.out.println("Produk: " + produk.getNama());
            System.out.println("  Harga Awal: Rp" + hargaAsli);
            System.out.println("  Diskon:     Rp" + diskon);
            System.out.println("  Harga Akhir:  Rp" + hargaFinal);
            System.out.println("---------------------------------");
            
            totalBayar += hargaFinal;
        }
        
        return totalBayar;
    }
}