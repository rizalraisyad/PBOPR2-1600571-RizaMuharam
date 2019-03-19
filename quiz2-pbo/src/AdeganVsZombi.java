import java.util.Scanner;

public class AdeganVsZombi extends Adegan {
    String narasiBebas = "Rudi kaget melihat zombie muncul dan akan memangsanya dia harus bertahan hidup!";
    int darahzombie = 100;
    //constructor
    public AdeganVsZombi () {
        boolean adasenjata = false;
        narasi = narasiBebas;
        System.out.println("Rudi terlibat perkelahian");
        System.out.println(narasiBebas);
        System.out.println("Pertarungan Dimulai");
        while(darahzombie>0 && oPlayer.kesehatan >0){
            System.out.println("Darah Zombie = "+darahzombie);
            System.out.println("Darah Player = "+oPlayer.kesehatan);
            System.out.println("Pilih Senjata yang akan digunakan untuk membunuh zombie");
            System.out.println("1. Pukulan");
            for (Barang obr : oPlayer.myArrBarang){
                if((obr.deskripsi).equals("shotgun")){
                    System.out.println("2. Shotgun");  //untuk cek apakah shotgun sudah dibawa
                    adasenjata = true;
                }
            }
            System.out.println("Pilih senjata");  // pemilihan
            Scanner in = new Scanner(System.in);
            int pill = in.nextInt(); // scanner pemilihan snejata
            if (pill == 1){
                darahzombie = darahzombie-50; // pukulan tidak akan langsung membunuh zombie
            }else if (pill == 2 && adasenjata == true){
                darahzombie = darahzombie-100; // senjata yang ditembakan pada zombie akan langusng membunuh zombie
            }else {
                System.out.println("Anda tidak menyerang sehingga zombie membunuh anda permainan selesai"); //jika player tidak menyerang zombie akan memakan player tersebut
                System.exit(0);
            }
            if(darahzombie!=0){
                oPlayer.kesehatan = oPlayer.kesehatan-25;  // jika zobie belum mati darah player akan berkurang 25 %
            }
        }
        System.out.println("Rudi Sudah mengalahkan Zombie ia sekarang sudah berada diluar , Rudi sudah bebas! Game Selesai"); // jika ia berhasil membunuh maka game selesai arena ia sudah berada di luar
        oPlayer.isSelesai = true;
    }
}
