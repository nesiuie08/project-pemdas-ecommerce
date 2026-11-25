import java.util.Scanner;
public class MainComer {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       CatalogStore katalog = new CatalogStore();
       Keranjang keranjang = new Keranjang();
       katalog.addProduk(new Produk("235LK", "Laptop Anes", 20000000, 11));
       katalog.addProduk(new Produk("346BV", "Samsung Elka", 7000000, 15));
       katalog.addProduk(new Produk("568KH", "Desktop Nana", 30000000, 16));
       katalog.addProduk(new Produk("769SH", "Ipad Tesha", 7000000, 10));

       System.out.print("Masukkan nama Anda: ");
       String nama = in.nextLine();
       System.out.println(" ");

       int menu;
       do{
        System.out.println("=============== " + "SELAMAT DATANG " + nama + " " + "===============");
        System.out.println(" Berikut Pilihan Menu Yang Bisa Anda Pilih ");
        System.out.println("1. Lihat Katalog                ");
        System.out.println("2. Tambah Keranjang               ");
        System.out.println("3. Lihat Keranjang               ");
        System.out.println("4. Checkout                  ");
        System.out.println("0. Keluar                   ");
        System.out.println(" ");
        System.out.print("Pilih menu: ");
        menu = in.nextInt();

         switch (menu) {
            case 1:
                katalog.showAllProduk();
                System.out.println(" ");
                break;
            case 2:
                katalog.showAllProduk();
                System.out.print("Masukkan ID produk: ");
                Produk p = katalog.CariProdukID(in.next());
                if (p == null) {
                    System.out.println("ID produk tidak ditemukan.");
                } else if (keranjang.jumlahDi(p) >= p.getStock()) {
                    System.out.println("Stok tidak cukup.");
                } else {
                    keranjang.tambah(p);
                    System.out.println(p.getBarang() + " masuk keranjang.");
                }
                System.out.println(" ");
                break;
            case 3:
                LihatKeranjang lihat = new LihatKeranjang(keranjang.getDaftarProduk(), keranjang.getJumlahBeli());
                System.out.println("\n ============ KERANJANG BELANJA ============");
                if (lihat.kosong()) {
                    System.out.println("Keranjang masih kosong.");
                } else {
                    for (int i = 0; i < lihat.jumlahItem(); i++) {
                        Produk item = lihat.getProduk(i);
                        int qty = lihat.getQty(i);
                        System.out.println((i + 1) + ". [" + item.getId() + "] " + item.getBarang());
                        System.out.println("   " + qty + " x Rp" + String.format("%,.0f", item.getPrice())
                                + " = Rp" + String.format("%,.0f", lihat.hitungSubtotal(i)));
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("TOTAL: Rp " + String.format("%,.0f", lihat.hitungTotal()));
                }
                System.out.println(" ");
                break;
            case 4:
                checkout checkout = new checkout(nama, keranjang.getDaftarProduk(), keranjang.getJumlahBeli());
                    checkout.prosesCheckout(in);
                break;
            case 0:
                System.out.println("========= Terima Kasih Sudah Berbelanja ========");
                break;
            default:
                System.out.println("Pilihan Tidak Valid!");
                break;
        }
       } while (menu != 0);
    in.close();
    }
}