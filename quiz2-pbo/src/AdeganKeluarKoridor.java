public class AdeganKeluarKoridor extends Adegan{

    String narasiBebas = "Rudi Sudah berada diluar kamar ! Game Selesai";

    //constructor
    public AdeganKeluarKoridor () {
        narasi = narasiBebas;
        System.out.println(narasiBebas);
        oPlayer.isSelesai = true;
    }
}
