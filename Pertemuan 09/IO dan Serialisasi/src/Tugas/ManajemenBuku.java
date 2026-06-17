/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManajemenBuku {
    private static final String TEXT_FILE = "buku.txt";
    private static final String SERIAL_FILE = "buku.ser";
    private static List<Buku> daftarBuku = new ArrayList<>();
    
    // --- UTILITY I/O ---

    @SuppressWarnings("unchecked")
    public static void muatDataSerial() {
        File file = new File(SERIAL_FILE);
        if (!file.exists()) {
            System.out.println("File serial tidak ditemukan. Memulai dengan daftar kosong.");
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                daftarBuku = (List<Buku>) obj;
                System.out.println("Data berhasil dimuat dari file serial. Jumlah buku: " + daftarBuku.size());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error saat memuat file serial: " + e.getMessage());
        }
    }

    // --- FITUR 1: TAMBAH BUKU ---

    public static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Nama Pengarang: ");
        String pengarang = scanner.nextLine();
        
        System.out.print("Masukkan Tahun Terbit: ");
        int tahunTerbit = 0;
        try {
            tahunTerbit = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Tahun terbit tidak valid. Pembatalan.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine(); // Konsumsi newline

        Buku newBuku = new Buku(judul, pengarang, tahunTerbit);
        daftarBuku.add(newBuku);
        System.out.println("Buku '" + judul + "' berhasil ditambahkan ke memori.");
    }
    
    // --- FITUR 2: SIMPAN KE FILE TEKS (buku.txt) ---

    public static void simpanKeFileTeks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEXT_FILE))) {
            for (Buku buku : daftarBuku) {
                // Menggunakan toString() yang mengembalikan format CSV
                writer.println(buku.toString());
            }
            System.out.println("Data berhasil disimpan ke file teks: " + TEXT_FILE);
        } catch (IOException e) {
            System.err.println("Error menyimpan ke file teks: " + e.getMessage());
        }
    }

    // --- FITUR 3: SIMPAN OBJEK KE FILE (buku.ser) ---

    public static void simpanKeFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            // Menyimpan seluruh List<Buku> sebagai satu objek
            oos.writeObject(daftarBuku);
            System.out.println("Objek berhasil diserialisasi dan disimpan ke: " + SERIAL_FILE);
        } catch (IOException e) {
            System.err.println("Error serialisasi: " + e.getMessage());
        }
    }

    // --- FITUR 4: TAMPILKAN DATA DARI FILE TEKS ---

    public static void tampilkanDariFileTeks() {
        System.out.println("\n--- Data dari FILE TEKS: " + TEXT_FILE + " ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                // Asumsi data disimpan dalam format CSV: Judul,Pengarang,Tahun
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    System.out.printf("%d. Judul: %s, Pengarang: %s, Tahun: %s\n", 
                                      counter++, parts[0], parts[1], parts[2]);
                } else {
                     System.out.println("Format baris tidak valid: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File teks belum ditemukan. Harap simpan data terlebih dahulu.");
        } catch (IOException e) {
            System.err.println("Error saat membaca file teks: " + e.getMessage());
        }
    }
    
    // --- FITUR 4: TAMPILKAN DATA DARI FILE SERIAL (Deserialisasi) ---

    @SuppressWarnings("unchecked")
    public static void tampilkanDariFileSerial() {
        System.out.println("\n--- Data dari FILE SERIAL: " + SERIAL_FILE + " ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<Buku> loadedList = (List<Buku>) obj;
                if (loadedList.isEmpty()) {
                    System.out.println("File serial ditemukan, tetapi kosong.");
                    return;
                }
                
                int counter = 1;
                for (Buku buku : loadedList) {
                    System.out.printf("%d. Judul: %s, Pengarang: %s, Tahun: %d\n", 
                                      counter++, buku.getJudul(), buku.getPengarang(), buku.getTahunTerbit());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File serial belum ditemukan. Harap simpan objek terlebih dahulu.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error saat membaca atau memproses file serial: " + e.getMessage());
        }
    }
}