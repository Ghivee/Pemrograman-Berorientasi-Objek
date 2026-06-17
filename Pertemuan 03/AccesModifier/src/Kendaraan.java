/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmad Ghifari
 */
public class Kendaraan {

    private int kecepatan;

    public String jenisMesin;

    public Kendaraan() {
        this.kecepatan = 0;
        this.jenisMesin = "Bensin";
    }

    public int getKecepatan() {
        return this.kecepatan;
    }
    
    public void percepat(int tambah) {
        if (tambah > 0) {
            this.kecepatan += tambah;
        }
    }

    public void perlambat(int kurang) {
        if (kurang > 0) {
            this.kecepatan = Math.max(0, this.kecepatan - kurang); 
        }
    }
}