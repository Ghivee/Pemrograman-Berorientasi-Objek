/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmad Ghifari
 */
public class Mobil extends Kendaraan {

    protected String warna;

    public Mobil(String warna) {
        super(); 
        
        this.warna = warna;
    }

    public void tampilkanWarna() {
        System.out.println("Warna mobil: " + this.warna);
    }
}
