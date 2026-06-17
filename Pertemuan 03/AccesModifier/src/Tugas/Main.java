/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author Ahmad Ghifari
 */
public class Main {
    public static void main(String[] args) {
        
        Pekerja p1 = new Pekerja("Ahmad", 30, "Programmer", 10000.0);

        System.out.println("--- Data Awal ---");
        System.out.println(p1.toString());
        
        p1.setNama("Ghifar");
        
        System.out.println("\n--- Setelah Ubah Nama ---");
        System.out.println(p1.toString());
        
        System.out.println("\n--- Tes Akses Langsung ---");
        System.out.println("Akses usia (protected): " + p1.usia);

    }
}