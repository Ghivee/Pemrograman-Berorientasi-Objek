/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author Ahmad Ghifari
 */
public class Main {

    public static void main(String[] args) {
        
        KeranjangBelanja keranjang = new KeranjangBelanja();

        Produk buku = new Buku("Buku", 100000);
        Produk elektronik = new Elektronik("Headphone", 500000);
        Produk pakaian = new Pakaian("Kemeja", 200000);

        keranjang.tambahProduk(buku);
        keranjang.tambahProduk(elektronik);
        keranjang.tambahProduk(pakaian);

        double totalBayar = keranjang.hitungDanTampilkanTotal();
        
        System.out.println("\n*** TOTAL HARGA SETELAH DISKON: Rp" + totalBayar + " ***");
    }
}