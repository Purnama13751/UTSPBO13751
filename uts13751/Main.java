package uts13751;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Mahasiswa m = new Mahasiswa();
        
        // input data mahasiswa
        System.out.print("Jumlah mahasiswa: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        for (int i = 0; i < jumlah; i++) {
            System.out.println("Mahasiswa ke-" + (i+1));
            
            // input data umum
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            
            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            System.out.print("Usia: ");
            int usia = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            System.out.print("Jumlah mata kuliah: ");
            int jumlahMatkul = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            String[] krs = new String[jumlahMatkul];
            int[] nilai = new int[jumlahMatkul];

            for (int j = 0; j < jumlahMatkul; j++) {
                System.out.print("Mata kuliah " + (j+1) + ": ");
                krs[j] = scanner.nextLine();

                System.out.print("Nilai mata kuliah " + (j+1) + ": ");
                //nilai[j] = scanner.nextInt();
                int nilaiMataKuliah = scanner.nextInt();
                scanner.nextLine();
                m.addNilai(nilaiMataKuliah);
            }

            // input data khusus mahasiswa baru
            System.out.print("Apakah mahasiswa baru (y/n)? ");
            String jawaban = scanner.nextLine();
            
            if (jawaban.equalsIgnoreCase("y")) {
                MahasiswaBaru mBaru = new MahasiswaBaru();
                mBaru.setNim(nim);
                mBaru.setNama(nama);
                mBaru.setSemester(semester);
                mBaru.setUsia(usia);
                mBaru.setKrs(krs);
                
                System.out.print("Asal Sekolah: ");
                String asalSekolah = scanner.nextLine();
                mBaru.setAsalSekolah(asalSekolah);

                System.out.print("Ikut OSPEK: ");
                String ikutOSPEK = scanner.nextLine();
                mBaru.setIkutOSPEK(ikutOSPEK);

                daftarMahasiswa.add(mBaru);
            }
            
            // input data khusus mahasiswa transfer
            System.out.print("Apakah mahasiswa transfer (y/n)? ");
            jawaban = scanner.nextLine();
            
            if (jawaban.equalsIgnoreCase("y")) {
                MahasiswaTransfer mTransfer = new MahasiswaTransfer();
                mTransfer.setNim(nim);
                mTransfer.setNama(nama);
                mTransfer.setSemester(semester);
                mTransfer.setUsia(usia);
                mTransfer.setKrs(krs);
                
                System.out.print("Asal Universitas: ");
                String asalUniversitas = scanner.nextLine();
                mTransfer.setAsalUniversitas(asalUniversitas);
                
                daftarMahasiswa.add(mTransfer);
            }
            
            // input data khusus mahasiswa lulus
            System.out.print("Apakah mahasiswa lulus (y/n)? ");
            jawaban = scanner.nextLine();
            
            if (jawaban.equalsIgnoreCase("y")) {
                MahasiswaLulus mLulus = new MahasiswaLulus();
                mLulus.setNim(nim);
                mLulus.setNama(nama);
                mLulus.setSemester(semester);
                mLulus.setUsia(usia);
                mLulus.setKrs(krs);
                System.out.println("Tahun Wisuda: ");
                int tahunWisuda = scanner.nextInt();
                mLulus.setTahunWisuda(tahunWisuda);// contoh tahun wisuda
                scanner.nextLine();

                System.out.print("IPK: ");
                float ipk = scanner.nextFloat();
                mLulus.setIpk(ipk);
                scanner.nextLine(); // consume newline
                
                daftarMahasiswa.add(mLulus);
            }

            
            
            // input data khusus mahasiswa yang bukan baru, transfer, atau lulus
            if (!jawaban.equalsIgnoreCase("y")) {
                //Mahasiswa m = new Mahasiswa();
                m.setNim(nim);
                m.setNama(nama);
                m.setSemester(semester);
                m.setUsia(usia);
                m.setKrs(krs);
                
                daftarMahasiswa.add(m);
            }
        }
        
        // Output informasi mahasiswa
        System.out.println("\nInformasi mahasiswa:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            mahasiswa.infoMahasiswa();
            mahasiswa.infoKrsMahasiswa();
            ArrayList<Float> nilai = m.getNilai(); // Update the variable type to ArrayList<Float>
            double rataRataNilai = 0.0;

            System.out.print("Nilai: ");
            for (int i = 0; i < nilai.size(); i++) {
                float nilaiMataKuliah = nilai.get(i); // Change int to float here
                System.out.print(nilaiMataKuliah + " ");
                rataRataNilai += nilaiMataKuliah;
            }

            if (nilai.size() > 0) {
                rataRataNilai /= nilai.size(); // Divide the sum by the number of grades
            }
            System.out.println("\nRata-rata Nilai: " + rataRataNilai);
                    System.out.println();
        }

    }
}
