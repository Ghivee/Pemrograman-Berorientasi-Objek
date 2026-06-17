/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum;

public class Makanan implements Pembayaran {
    
    private static final double TARIF_PAJAK = 0.05; 
    
    @Override
    public double hitungPajak(double harga) {
        return harga * TARIF_PAJAK;
    }
}