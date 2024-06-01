package TUBES;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List listPerbankan = new List();
        Scanner scanner = new Scanner(System.in);
        int Opsi = 0;

        while (Opsi != 5) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Cari Nasabah");
            System.out.println("3. Hapus Nasabah");
            System.out.println("4. Tampilkan Daftar Nasabah");
            System.out.println("5. Keluar");
            System.out.print("\nPilihan Anda: ");
            Opsi = scanner.nextInt();

            switch (Opsi) {
                // Opsi Tambah Nasabah
                case 1:
                    System.out.println("\n===== TAMBAH NASABAH =====");
                    System.out.print("Nama Nasabah : ");
                    String nama = scanner.next();
                    System.out.print("No Rekening : ");
                    int noRekening = scanner.nextInt();
                    System.out.print("saldo : ");
                    double saldo = scanner.nextDouble();

                    // Data List
                    System.out.println("===== LIST DATA NASABAH =====");
                    System.out.println("1. Add Nasabah Awal");
                    System.out.println("2. Add Nasabah Tengah");
                    System.out.println("3. Add Nasabah Akhir");
                    System.out.print("Pilihan Anda : ");
                    Opsi = scanner.nextInt();

                    switch (Opsi) {
                        case 1:
                            listPerbankan.addNasabahHead(nama, noRekening, saldo);
                            break;
                        case 2:
                            if (listPerbankan.isEmpty()) {
                                listPerbankan.addNasabahHead(nama, noRekening, saldo);
                            } else {
                                System.out.print("Nasabah akan ditempatkan: ");
                                int noRekeningNasabah = scanner.nextInt();
                                listPerbankan.addNasabahMid(nama, noRekening, saldo, noRekeningNasabah);
                            }
                            break;
                        case 3:
                            listPerbankan.addNasabahTail(nama, noRekening, saldo);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                            break;
                    }
                    break;

                // Opsi Cari Nasabah
                case 2:
                    System.out.println("\n===== CARI NASABAH =====");
                    System.out.print("Masukkan Nasabah yang ingin dicari : ");
                    String cariNasabah = scanner.next();
                    Nasabah hasilPencarian = listPerbankan.cariNasabah(cariNasabah);
                    if (hasilPencarian != null) {
                        System.out.println("Nasabah ditemukan: Nama: " + hasilPencarian.getNama() + ", No Rekening: " + hasilPencarian.getNoRekening() + ", Saldo: " + hasilPencarian.getSaldo());
                    } else {
                        System.out.println("Nasabah tidak ditemukan.");
                    }
                    break;
                // Opsi Hapus Nasabah
                case 3:
                    System.out.println("\n===== HAPUS NASABAH =====");
                    if (listPerbankan.isEmpty()) {
                        System.out.println("Tidak ada nasabah yang bisa dihapus");
                    } else {
                        System.out.print("Masukkan Nasabah yang ingin dihapus: ");
                        String hapusNasabah = scanner.next();
                        listPerbankan.hapusNasabah(hapusNasabah);
                    }
                    break;
                case 4:
                    // Opsi Daftar Nasabah
                    System.out.println("\n===== DAFTAR NASABAH =====");
                    listPerbankan.tampilkanSemua();
                    break;
                case 5:
                    // Opsi Keluar
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}

