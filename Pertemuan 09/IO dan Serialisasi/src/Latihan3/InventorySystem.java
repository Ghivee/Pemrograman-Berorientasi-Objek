package Latihan3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventorySystem {
    private static final String TEXT_FILE = "produk.txt";
    private static final String SERIAL_FILE = "produk.ser";
    private static List<Produk2> produkList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Muat data serial saat startup
        muatDariFileSerial(); 
        
        while (true) {
            System.out.println("\nMenu Inventory:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Simpan ke File Teks");
            System.out.println("3. Simpan Objek ke File (Serialisasi)");
            System.out.println("4. Tampilkan Semua Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            
            switch (pilihan) {
                case 1 -> tambahProduk(scanner);
                case 2 -> simpanKeFileTeks();
                case 3 -> simpanKeFileSerial();
                case 4 -> tampilkanProduk();
                case 5 -> {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // --- IMPLEMENTASI METODE HILANG: TAMBAH PRODUK ---
    private static void tambahProduk(Scanner scanner) {
        System.out.print("Masukkan Nama Produk: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Harga Produk: ");
        double harga = scanner.nextDouble();
        
        System.out.print("Masukkan Stok Produk: ");
        int stok = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        Produk2 newProduk = new Produk2(nama, harga, stok);
        produkList.add(newProduk);
        System.out.println("Produk '" + nama + "' berhasil ditambahkan.");
    }
    
    // --- METODE YANG DIBERIKAN: SIMPAN KE FILE TEKS ---
    private static void simpanKeFileTeks() {
        try (FileWriter writer = new FileWriter(TEXT_FILE)) {
            for (Produk2 produk : produkList) {
                // Menggunakan toString() yang telah di-override untuk format CSV
                writer.write(produk.toString() + "\n");
            }
            System.out.println("Data produk berhasil disimpan ke file teks: " + TEXT_FILE);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file teks.");
            e.printStackTrace();
        }
    }

    // --- METODE YANG DIBERIKAN: SIMPAN KE FILE SERIAL ---
     private static void simpanKeFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            // Serialisasi seluruh List<Produk2>
            oos.writeObject(produkList);
            System.out.println("Objek produk berhasil disimpan ke file serial: " + SERIAL_FILE);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file serial.");
            e.printStackTrace();
        }
    }

    // --- METODE YANG DIBERIKAN: TAMPILKAN PRODUK ---
    private static void tampilkanProduk() {
        if (produkList.isEmpty()) {
             System.out.println("Daftar Produk: (Kosong)");
             return;
        }
        System.out.println("\n--- Daftar Produk (" + produkList.size() + " item) ---");
        for (Produk2 produk : produkList) {
            produk.tampilkanInfo();
        }
        System.out.println("----------------------------------------");
    }
    
    // --- METODE TAMBAHAN: MUAT DARI FILE SERIAL (UNTUK INTEGRASI) ---
    private static void muatDariFileSerial() {
        File file = new File(SERIAL_FILE);
        if (!file.exists()) {
            System.out.println("File serial tidak ditemukan. Memulai dengan daftar kosong.");
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            // Deserialisasi objek dan casting
            Object obj = ois.readObject();
            if (obj instanceof List) {
                produkList = (List<Produk2>) obj;
                System.out.println("Data berhasil dimuat dari file serial.");
            }
        } catch (IOException e) {
            System.out.println("Error saat membaca file serial (Mungkin file rusak).");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Kelas Produk2 tidak ditemukan saat memuat data.");
        }
    }
}