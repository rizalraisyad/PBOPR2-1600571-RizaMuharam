/*
    Adegan dipintu, ada state terkunci
 */

public class AdeganPintu extends  Adegan {
    boolean isTerkunci = true;
    String narasiTerkunci = "Rudi mendekati pintu. Rudi mencoba membuka pintu. \"Ah terkunci\"";
    String narasiTerbuka  = "Rudi mencoba membuka pintu dan terbuka!\n Rudi pelan-pelan membuka pintu dan keluar dari kamar. Rudi sekarang berada di koridor yang sangat panjang";

    //constructor
    public AdeganPintu () {
        narasi = narasiTerkunci;

    }

    /* user berhasil menggunakan kunci untuk membuka pintu */
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent
        isTerkunci = false;
        narasi = narasiTerbuka;

        //karena kunci sudah terbuka ada pilihan baru keluar dari kamar
        Adegan adegandipintu = new AdeganPintu();
//        Adegan  adeganKoridor = new AdeganKeluarKoridor();
//        adegandipintu.narasi = "Rudi pelan-pelan membuka pintu dan keluar dari kamar. Rudi sekarang berada di koridor " +
//                "yang sangat panjang";
//        System.out.println(adegandipintu.narasi);
        Pilihan pilihanMenujuKoridor = new PilihanGantiAdegan(adegandipintu,"Keluar kamar, ke koridor");
        tambahPilihan(pilihanMenujuKoridor);
    }

}
