/*
    inisialisasi adegan dsb, jalankan adegan sampai permainan selesai.

 */

public class GameEngine {
    Player oPlayer;

    public GameEngine() {
        Barang koin = new Barang("koin","uang koin");
        oPlayer = new Player();
        oPlayer.tambahBarang(koin);  //dummy saja
        //perhatikan Adegan  disini adalah class, oPlayer adalah static atribut sehingga berlaku untuk semua objek
        //artinya semua objek adegan punya objek player yang sama
        Adegan.oPlayer = oPlayer;
    }

    public void mulai() {
        oPlayer.printIdentitas();
        do {
            System.out.println("Kesehatan player = "+oPlayer.kesehatan);
            oPlayer.adeganAktif.mainkan();
            oPlayer.kesehatan = oPlayer.kesehatan - 5;
        } while (!oPlayer.isSelesai && oPlayer.kesehatan!=0); // berubah akan selesai ketika kesehatan 0 atau berhasil selamat
        if (oPlayer.kesehatan == 0 ){
            System.out.println("Permainan Selesai karena player mati");
        }
    }

    public static void main(String[] args) {

        Barang kunci = new Barang("kunci_besar","Kunci Besar");


        Adegan adeganPintu = new AdeganPintu();
        Adegan adeganBerjalanJendela = new AdeganBerjalanJendela();
        Adegan adeganMeja  = new Adegan();
//        Adegan adeganVsZombie  = new Adegan();
//        Adegan adegankoridor = new AdeganKeluarKoridor();



        Pilihan pilihanMenujuPintu = new PilihanGantiAdegan(adeganPintu,"Menuju pintu");
        Pilihan pilihanMenujuMeja  = new PilihanGantiAdegan(adeganMeja,"Menuju meja");
        Pilihan pilihanMenujuJendela = new PilihanGantiAdegan(adeganBerjalanJendela,"Menuju jendela");
//        Pilihan pilihankeluar = new PilihanGantiAdegan(adegankoridor,"Keluar Koridor");
        //init data cerita
        // == adegan awal
        Adegan  adeganAwal = new Adegan();
        adeganAwal.narasi =
                "Rudi terbangun disebuah ruangan yang tidak dikenal. Dia melihat sekeliling, \n" +
                "terlihat jendela, pintu dan sebuah meja kecil";
        adeganAwal.tambahPilihan(pilihanMenujuPintu);
        adeganAwal.tambahPilihan(pilihanMenujuMeja);
        adeganAwal.tambahPilihan(pilihanMenujuJendela);


        // == adegan di depan pintu
        adeganPintu.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja direuse
        adeganPintu.tambahPilihan(pilihanMenujuJendela); //pilihan ke meja direuse
        adeganPintu.idBarangBisaDigunakan = "kunci_besar"; //kunci_besar bisa digunakan di adegan ini
        adeganPintu.tambahBarang(new Barang("Obeng", "Obeng untuk mencukil"));
        // == adegan di depan meja
        adeganMeja.narasi = "Rudi mendekati meja. Ada beberapa barang di atas meja";
        adeganMeja.tambahBarang(new Barang("kunci_besar", "Kunci berukuran besar"));
        adeganMeja.tambahBarang(new Barang("senter", "Senter kecil"));
        adeganMeja.tambahBarang(new Barang("nasi", "nasi"));
        adeganMeja.tambahBarang(new Barang("shotgun", "shotgun")); // untuk perang melawan zombie
        adeganMeja.idBarangBisaDigunakan = "nasi"; //nasi bisa digunakan di adegan (hanya di meja)
        adeganMeja.tambahPilihan(pilihanMenujuPintu); //dari meja bisa ke pintu
        adeganMeja.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke pintu

        // == adegan di depan jendela
        adeganBerjalanJendela.idBarangBisaDigunakan = "Obeng"; // untuk mencungkil
        adeganBerjalanJendela.tambahPilihan(pilihanMenujuMeja);
        adeganBerjalanJendela.tambahPilihan(pilihanMenujuPintu);
        // == adegan koridor
//        adegankoridor.tambahPilihan(pilihankeluar);
//        adeganVsZombie.idBarangBisaDigunakan = "shotgun"; // untuk bertarung


        //== init game engine
        GameEngine ge = new GameEngine();
        //ge.tambahAdegan(adeganMeja);
        ge.oPlayer.adeganAktif = adeganAwal; //start dari adegan awal
        ge.mulai();
    }
}
