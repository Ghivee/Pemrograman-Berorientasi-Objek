/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsiuasghifar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idTransaksi;
    private Anggota peminjam; 
    private List<Buku> daftarBukuPinjaman; 
    
    private Date tanggalPinjam;

    public Transaksi(String idTransaksi, Anggota peminjam) {
        this.idTransaksi = idTransaksi;
        this.peminjam = peminjam;
        this.daftarBukuPinjaman = new ArrayList<>(); // Inisialisasi list
        this.tanggalPinjam = new Date();
    }

    public void tambahBuku(Buku buku) {
        daftarBukuPinjaman.add(buku);
    }

    public void cetakStruk() {
        System.out.println("\n=== STRUK PEMINJAMAN ===");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Peminjam     : " + peminjam.getNama());
        System.out.println("Tanggal      : " + tanggalPinjam);
        System.out.println("Buku Dipinjam:");
        for (Buku b : daftarBukuPinjaman) {
            System.out.println("- " + b.toString());
        }
        System.out.println("========================");
    }
    
    public List<Buku> getDaftarBuku() {
        return daftarBukuPinjaman;
    }
}