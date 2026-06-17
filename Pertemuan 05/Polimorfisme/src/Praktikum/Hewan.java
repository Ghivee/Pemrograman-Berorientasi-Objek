/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum;

/**
 *
 * @author Ahmad Ghifari
 */
class Hewan {

    // Metode umum yang akan di-override
    public void bersuara() {
        System.out.println("Hewan bersuara");
    }

    // 2. Metode makan() yang pertama (overloading)
    public void makan(String makanan) {
        System.out.println("Hewan makan " + makanan);
    }

    // 2. Metode makan() yang kedua (overloading)
    // Nama metodenya sama, tapi parameternya berbeda
    public void makan(String makanan, int jumlah) {
        System.out.println("Hewan makan " + jumlah + " porsi " + makanan);
    }
}