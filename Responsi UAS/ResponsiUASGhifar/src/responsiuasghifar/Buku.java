/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsiuasghifar;

public class Buku extends ItemKoleksi implements OperasiPeminjaman {
    private String penulis;
    private boolean tersedia;

    public Buku(String id, String judul, String penulis) {
        super(id, judul);
        this.penulis = penulis;
        this.tersedia = true;
    }

    @Override
    public void pinjam() {
        if (tersedia) {
            tersedia = false;
        }
    }

    @Override
    public void kembalikan() {
        tersedia = true;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    @Override
    public void tampilkanInfo() {
        String status = tersedia ? "[Tersedia]" : "[Dipinjam]";
        System.out.printf("%-5s | %-20s | %-15s | %s%n", id, judul, penulis, status);
    }
    
    @Override
    public String toString() {
        return judul + " (" + penulis + ")";
    }
}