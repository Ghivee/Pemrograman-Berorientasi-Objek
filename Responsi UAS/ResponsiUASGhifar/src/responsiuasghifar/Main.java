/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsiuasghifar;

import java.io.*;
import java.util.*;

public class Main {
    private static List<Buku> daftarBuku = new ArrayList<>();
    private static List<Anggota> daftarAnggota = new ArrayList<>();
    private static List<Transaksi> riwayatTransaksi = new ArrayList<>();
    
    private static final String FILE_DATA = "perpustakaan.ser";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData(); // Memuat data saat program mulai

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Lihat Buku");
            System.out.println("4. Lihat Anggota");
            System.out.println("5. Peminjaman");
            System.out.println("6. Pengembalian");
            System.out.println("7. Simpan & Keluar");
            System.out.print("Pilih: ");

            try {
                String input = scanner.nextLine();
                int pilihan = Integer.parseInt(input);

                switch (pilihan) {
                    case 1: tambahBuku(); break;
                    case 2: tambahAnggota(); break;
                    case 3: lihatBuku(); break;
                    case 4: lihatAnggota(); break;
                    case 5: transaksiPeminjaman(); break;
                    case 6: transaksiPengembalian(); break;
                    case 7: 
                        simpanData(); 
                        running = false; 
                        break;
                    default: System.out.println("Pilihan salah!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Masukkan angka, bukan huruf!");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
            }
        }
    }

    // --- LOGIC METHODS ---

    private static void tambahBuku() {
        System.out.print("ID Buku: "); String id = scanner.nextLine();
        System.out.print("Judul: "); String judul = scanner.nextLine();
        System.out.print("Penulis: "); String penulis = scanner.nextLine();
        daftarBuku.add(new Buku(id, judul, penulis));
        System.out.println("Sukses tambah buku.");
    }

    private static void tambahAnggota() {
        System.out.print("ID Anggota: "); String id = scanner.nextLine();
        System.out.print("Nama: "); String nama = scanner.nextLine();
        daftarAnggota.add(new Anggota(id, nama));
        System.out.println("Sukses tambah anggota.");
    }

    private static void lihatBuku() {
        if(daftarBuku.isEmpty()) { System.out.println("Data kosong."); return; }
        System.out.println("--- DAFTAR BUKU ---");
        for (Buku b : daftarBuku) b.tampilkanInfo();
    }

    private static void lihatAnggota() {
        if(daftarAnggota.isEmpty()) { System.out.println("Data kosong."); return; }
        System.out.println("--- DAFTAR ANGGOTA ---");
        for (Anggota a : daftarAnggota) a.tampilkanInfo();
    }

    private static void transaksiPeminjaman() {
        System.out.print("ID Anggota: ");
        Anggota a = cariAnggota(scanner.nextLine());
        if (a == null) { System.out.println("Anggota tidak ditemukan."); return; }

        Transaksi trx = new Transaksi("TRX-" + System.currentTimeMillis(), a);
        
        while(true) {
            System.out.print("ID Buku dipinjam (ketik 'stop' untuk selesai): ");
            String idBuku = scanner.nextLine();
            if(idBuku.equalsIgnoreCase("stop")) break;

            Buku b = cariBuku(idBuku);
            if (b != null && b.isTersedia()) {
                b.pinjam();
                trx.tambahBuku(b);
                System.out.println("Buku masuk keranjang.");
            } else {
                System.out.println("Buku tidak ada atau sedang dipinjam.");
            }
        }
        riwayatTransaksi.add(trx);
        trx.cetakStruk();
    }

    private static void transaksiPengembalian() {
        System.out.print("Masukkan ID Buku yang dikembalikan: ");
        Buku b = cariBuku(scanner.nextLine());
        if (b != null) {
            b.kembalikan();
            System.out.println("Buku berhasil dikembalikan.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private static Buku cariBuku(String id) {
        for (Buku b : daftarBuku) if (b.getId().equals(id)) return b;
        return null;
    }

    private static Anggota cariAnggota(String id) {
        for (Anggota a : daftarAnggota) if (a.getIdAnggota().equals(id)) return a;
        return null;
    }

    @SuppressWarnings("unchecked")
    private static void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_DATA))) {
            daftarBuku = (List<Buku>) in.readObject();
            daftarAnggota = (List<Anggota>) in.readObject();
            riwayatTransaksi = (List<Transaksi>) in.readObject();
            System.out.println("Data berhasil dimuat.");
        } catch (FileNotFoundException e) {
            System.out.println("Database baru dibuat.");
        } catch (Exception e) {
            System.out.println("Gagal load data: " + e.getMessage());
        }
    }

    private static void simpanData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_DATA))) {
            out.writeObject(daftarBuku);
            out.writeObject(daftarAnggota);
            out.writeObject(riwayatTransaksi);
            System.out.println("Data disimpan. Sampai jumpa!");
        } catch (IOException e) {
            System.out.println("Gagal simpan data: " + e.getMessage());
        }
    }
}