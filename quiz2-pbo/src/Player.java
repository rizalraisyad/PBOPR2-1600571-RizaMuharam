/*
    Menyimpan informasi tentang player seperti
    - barang yang dibawa
    - kesehatan

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    int kesehatan = 100;
    boolean isSelesai = false;
    Adegan adeganAktif; //adegan tempat player berada

    /* barang yang dimiliki player*/
    ArrayList<Barang> myArrBarang = new ArrayList<>();
    Barang[] arrBarang = new Barang[10];
    int jumBarang  = 0;


    //jika dipanggil akan lengkapi dengan nim, nama dan tulisan saya berjanji tdk akan dst..
    public void printIdentitas() {
        System.out.println("Identitas");
        System.out.println("1600571,Rizal Muharam anda dan pernjanjian \n Saya bernjanji tidak berlaku curang dan/atau membantu orang lain berbuat curang");
    }


    public void tambahBarang(Barang oBarang) {
//        arrBarang[jumBarang] = oBarang;
//        jumBarang++;
        myArrBarang.add(oBarang);
    }

    /*
        cetak isi barang yang dimiliki player
        return adalah objek barang yang dipilih user untuk digunakan
        jika user tidak jadi memilih maka akan return null
        hati-hati dapat menyebabkan NullPointer exception jadi selalu cek return
     */

    public Barang pilihBarang() {
        System.out.println("Barang yang berada di dalam kantong");
//        for (int i=0;i<jumBarang;i++) {
//            System.out.println(String.format("%d. %s",i+1,arrBarang[i].deskripsi));
//        }
        int i = 0;
        for (Barang obr : myArrBarang){
            System.out.println(String.format("%d. %s",i+1,obr.deskripsi));
            i++;
        }
        System.out.println(String.format("99. %s","Hanya lihat, tidak menggunakan barang"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilihan anda?");
        int pilihan = sc.nextInt();
        if (pilihan!=99)
            return(myArrBarang.get(pilihan-1));
        else
            return null;
    }

    public static void main(String[] args) {
        //untuk test
        Barang permen = new Barang("p_kopiko","Permen Kopiko");
        Barang bolpen = new Barang("bolpen","Bolpen");
        Player p = new Player();
        p.tambahBarang(permen);
        p.tambahBarang(bolpen);
        Barang barangPilih = p.pilihBarang(); //
        if (barangPilih!=null) {
            System.out.println(barangPilih.deskripsi);

        }
    }



}
