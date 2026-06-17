/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Muat data dari file serial saat startup (diimplementasikan di ManajemenBuku)
        ManajemenBuku.muatDataSerial(); 

        while (true) {
            System.out.println("\n===== SISTEM MANAJEMEN BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Simpan ke File Teks (buku.txt)");
            System.out.println("3. Simpan Objek ke File Serial (buku.ser)");
            System.out.println("4. Tampilkan dari File Teks");
            System.out.println("5. Tampilkan dari File Serial");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            
            switch (pilihan) {
                case 1 -> ManajemenBuku.tambahBuku(scanner);
                case 2 -> ManajemenBuku.simpanKeFileTeks();
                case 3 -> ManajemenBuku.simpanKeFileSerial();
                case 4 -> ManajemenBuku.tampilkanDariFileTeks();
                case 5 -> ManajemenBuku.tampilkanDariFileSerial();
                case 6 -> {
                    System.out.println("Terima kasih, keluar dari sistem.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}