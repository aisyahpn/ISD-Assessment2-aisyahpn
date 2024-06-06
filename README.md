ASSESSMENT 2

NAMA: Aisyah Putri Nuraini

NIM: 607062300033

Kelas: 47-04

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Paket {
    int idPaket;
    String namaPelanggan;
    String alamatPengiriman;
    int tanggalPengiriman;
    String tipePengiriman;
    int waktuPengiriman;

    public Paket(int idPaket, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        this.idPaket = idPaket;
        this.namaPelanggan = namaPelanggan;
        this.tanggalPengiriman = tanggalPengiriman;
        this.tipePengiriman = tipePengiriman;
        this.alamatPengiriman = alamatPengiriman;
        this.waktuPengiriman = hitungWaktuPengiriman(tipePengiriman);
    }

    private int hitungWaktuPengiriman(String tipePengiriman) {
        switch (tipePengiriman.toLowerCase()) {
            case "biasa":
                return 3;
            case "express":
                return 2;
            case "kilat":
                return 1;
            case "same day":
                return 0;
            default:
                throw new IllegalArgumentException("Tipe pengiriman tidak valid: " + tipePengiriman);
        }
    }

    public int getTanggalSampai() {
        return tanggalPengiriman + waktuPengiriman;
    }

    @Override
    public String toString() {
        return "ID Paket: " + idPaket +
                ", Nama: " + namaPelanggan +
                ", Alamat: " + alamatPengiriman +
                ", Tanggal Pengiriman: " + tanggalPengiriman +
                ", Tipe Pengiriman: " + tipePengiriman +
                ", Tanggal Sampai: " + getTanggalSampai();
    }
}

class DaftarPaket {
    private ArrayList<Paket> paketList;

    public DaftarPaket() {
        paketList = new ArrayList<>();
    }

    public void terimaKiriman(int idPaket, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        Paket paket = new Paket(idPaket, namaPelanggan, tanggalPengiriman, tipePengiriman, alamatPengiriman);
        paketList.add(paket);
    }

    public void cetakDataPaket() {
        Collections.sort(paketList, Comparator.comparing(Paket::getTanggalSampai));
        for (Paket paket : paketList) {
            System.out.println(paket);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DaftarPaket daftarPaket = new DaftarPaket();
        daftarPaket.terimaKiriman(1, "Yuli", 5, "express", "Jl. Ciganitri no. 15");
        daftarPaket.terimaKiriman(2, "Kiki", 6, "kilat", "Jl. Pogor no. 11");
        daftarPaket.terimaKiriman(3, "Toto", 7, "biasa", "Jl. Sukabirus no. 15");
        daftarPaket.terimaKiriman(4, "Juni", 8, "express", "Jl Telekomunikasi no. 2");
        daftarPaket.terimaKiriman(5, "Julia", 8, "same day", "Jl. Ciganitri no. 13");
        daftarPaket.terimaKiriman(6, "Agus", 9, "biasa", "Jl. Ciganitri no. 23");

        daftarPaket.cetakDataPaket();
    }
}
