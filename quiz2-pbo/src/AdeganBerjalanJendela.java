public class AdeganBerjalanJendela extends Adegan{
    boolean isTerkunci = true;
    String narasiTerkunci = "Rudi mendekati jendela. Jendela tersebut terkunci tapi sepertinya bisa dicungkil";
    String narasiTerbuka  = "Rudi mencoba mencungkil jendela dan terbuka!";

    //constructor
    public AdeganBerjalanJendela () {
        narasi = narasiTerkunci;
    }
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent
        isTerkunci = false;
        narasi = narasiTerbuka;

        //karena kunci sudah terbuka ada pilihan baru keluar dari kamar
        Adegan adegandiJendela = new AdeganBerjalanJendela();
//        Adegan  adeganKoridor = new AdeganKeluarKoridor();
//        adegandipintu.narasi = "Rudi pelan-pelan membuka pintu dan keluar dari kamar. Rudi sekarang berada di koridor " +
//                "yang sangat panjang";
//        System.out.println(adegandipintu.narasi);
        Pilihan pilihanMenujuKoridor = new PilihanGantiAdegan(adegandiJendela,"Lompat keluar jendela");
        tambahPilihan(pilihanMenujuKoridor);
    }
}
