/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum;

public class Perpustakaan {
    private Buku[] daftarBuku; // Komposisi: Perpustakaan memiliki array Buku
    private int jumlahBuku;

    public Perpustakaan(int kapasitas) {
        // Komposisi: Array dibuat di dalam konstruktor Perpustakaan
        this.daftarBuku = new Buku[kapasitas]; 
        this.jumlahBuku = 0;
    }

    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku] = buku;
            jumlahBuku++;
            System.out.println("Buku '" + buku.judul + "' berhasil ditambahkan.");
        } else {
            System.out.println("Perpustakaan penuh! Tidak dapat menambahkan buku.");
        }
    }
    
    public void tampilkanBuku() {
        if (jumlahBuku == 0) {
            System.out.println("\nPerpustakaan masih kosong.");
            return;
        }

        System.out.println("\n==== Daftar Buku di Perpustakaan (" + jumlahBuku + " item) ====");
        for (int i = 0; i < jumlahBuku; i++) {
            daftarBuku[i].infoBuku();
            System.out.println("----------------------------------");
        }
    }
}