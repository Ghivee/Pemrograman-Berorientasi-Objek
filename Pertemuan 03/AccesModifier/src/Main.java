/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmad Ghifari
 */
public class Main {

    public static void main(String[] args) {
        
        Kendaraan motor = new Kendaraan();

        System.out.println("--- Menguji Variabel Public ---");
        
        System.out.println("Jenis mesin awal: " + motor.jenisMesin);

        motor.jenisMesin = "Listrik";

        System.out.println("Jenis mesin baru: " + motor.jenisMesin);
        
        System.out.println("\n--- Menguji Variabel Private (Enkapsulasi) ---");

        motor.perlambat(100); 
        System.out.println("Kecepatan (privat): " + motor.getKecepatan());
        
    }
}