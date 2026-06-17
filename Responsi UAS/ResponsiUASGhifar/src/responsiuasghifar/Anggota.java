/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsiuasghifar;

import java.io.Serializable;

public class Anggota implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idAnggota;
    private String nama;

    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
    }

    public String getIdAnggota() { return idAnggota; }
    public String getNama() { return nama; }

    public void tampilkanInfo() {
        System.out.printf("%-5s | %-20s%n", idAnggota, nama);
    }
}