/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum;

public class Main {
    
    public static void main(String[] args) {
        
        double hargaTV = 5000000.0;
        double hargaRoti = 20000.0;
        
        // Objek Elektronik
        Pembayaran tv = new Elektronik();
        double pajakTV = tv.hitungPajak(hargaTV);
        
        // Objek Makanan
        Pembayaran roti = new Makanan();
        double pajakRoti = roti.hitungPajak(hargaRoti);
        
        // Menampilkan Hasil
        System.out.println("====== Sistem Pembayaran Toko ======");
        System.out.println("Produk: TV (Elektronik)");
        System.out.println("Harga Dasar : Rp " + String.format("%,.2f", hargaTV));
        System.out.println("Pajak (10%) : Rp " + String.format("%,.2f", pajakTV));
        System.out.println("Total Bayar : Rp " + String.format("%,.2f", (hargaTV + pajakTV)));
        
        System.out.println("\n------------------------------------");
        
        System.out.println("Produk: Roti (Makanan)");
        System.out.println("Harga Dasar : Rp " + String.format("%,.2f", hargaRoti));
        System.out.println("Pajak (5%)  : Rp " + String.format("%,.2f", pajakRoti));
        System.out.println("Total Bayar : Rp " + String.format("%,.2f", (hargaRoti + pajakRoti)));
        System.out.println("====================================");
    }
}