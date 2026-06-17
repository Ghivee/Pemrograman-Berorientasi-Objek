/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import java.io.Serializable;

public class Buku implements Serializable {
    private static final long serialVersionUID = 2L; 

    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Metode Getter
    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Override toString untuk format penyimpanan file teks (CSV)
    @Override
    public String toString() {
        return judul + "," + pengarang + "," + tahunTerbit;
    }
}