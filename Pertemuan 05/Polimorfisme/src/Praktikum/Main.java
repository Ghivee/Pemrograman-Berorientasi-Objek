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
        // Membuat objek 'kucing' dari kelas 'Hewan'
        Hewan kucing = new Hewan();

        // Memanggil metode bersuara()
        kucing.bersuara();
        
        // Memanggil metode makan(String)
        kucing.makan("ikan"); 
        
        // Memanggil metode makan(String, int) yang overloaded
        kucing.makan("ikan", 2); 
    }
}