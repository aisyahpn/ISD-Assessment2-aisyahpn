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
                " namaPelanggan: " + namaPelanggan +
                " alamatPelanggan: " + alamatPengiriman;
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