/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum;

/**
 *
 * @author Ahmad Ghifari
 */
public class Main {
    public static void main(String[] args) {
        
        // 1. Inisialisasi Objek Pengarang (Independen)
        // Objek Pengarang dapat dibuat tanpa harus terikat pada Buku tertentu.
        Pengarang pengarangA = new Pengarang("Andrea Hirata");
        Pengarang pengarangB = new Pengarang("Tere Liye");
        
        // 2. Inisialisasi Objek Buku (Agregasi)
        // Objek Buku dibuat dengan menyuntikkan objek Pengarang yang sudah ada.
        Buku buku1 = new Buku("Laskar Pelangi", pengarangA);
        Buku buku2 = new Buku("Ayah", pengarangA); // Pengarang yang sama bisa menulis buku yang berbeda
        Buku buku3 = new Buku("Hujan", pengarangB);
        
        // 3. Inisialisasi Objek Perpustakaan (Komposisi)
        // Membuat Perpustakaan dengan kapasitas 5
        Perpustakaan perpusKota = new Perpustakaan(5); 
        
        // 4. Tambahkan Buku ke Perpustakaan
        perpusKota.tambahBuku(buku1);
        perpusKota.tambahBuku(buku2);
        perpusKota.tambahBuku(buku3);
        
        // 5. Tampilkan semua Buku di Perpustakaan
        perpusKota.tampilkanBuku();

        // 6. Contoh Pengujian: Pengarang tetap ada meskipun buku di perpustakaan berbeda
        System.out.println("\n--- Info Pengarang Independen ---");
        pengarangB.infoPengarang();
    }
}