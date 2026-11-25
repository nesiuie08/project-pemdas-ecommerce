import java.util.ArrayList;
import java.util.Scanner;

public class checkout {
    private String nama;
    private ArrayList<Produk> keranjang;
    private ArrayList<Integer> jumlahBeli;

    public checkout(String nama, ArrayList<Produk> keranjang, ArrayList<Integer> jumlahBeli) {
        this.nama = nama;
        this.keranjang = keranjang;
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            total += keranjang.get(i).getPrice() * jumlahBeli.get(i);
        }
        return total;
    }

    public void tampilKeranjang() {
        System.out.println("\n ============ KERANJANG BELANJA ============");
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang masih kosong.");
            return;
        }
        for (int i = 0; i < keranjang.size(); i++) {
            Produk p = keranjang.get(i);
            int qty = jumlahBeli.get(i);
            System.out.println((i + 1) + ". [" + p.getId() + "] " + p.getBarang());
            System.out.println(" " + qty + " x Rp" + String.format("%,.0f", p.getPrice()) + " = Rp" + String.format("%,.0f", p.getPrice() * qty));
        }
        System.out.println("----------------------------------------------");
        System.out.println("TOTAL: Rp " + String.format("%,.0f", hitungTotal()));
    }

    public void prosesCheckout(Scanner in) {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong, tidak ada yang bisa di checkout. \n");
            return;
        }

        tampilKeranjang();
        double total = hitungTotal();

        System.out.println("\nLanjutkan checkout? (y/n): ");
        String konfirmasi = in.next();
        if(!konfirmasi.equalsIgnoreCase("y")) {
            System.out.println("Checkout dibatalkan.\n");
            return;
        }

        double bayar;
        do {
            System.out.println("Masukkan uang pembayaran (0 untuk batal): Rp ");
            bayar = in.nextDouble();
            if (bayar == 0) {
                System.out.println("Checkout dibatalkan.\n");
                return;
            }
            if (bayar < total) {
                System.out.println("Uang kurang Rp " + String.format("%.0f", total - bayar) + ". Coba lagi.");
            }
        } while (bayar < total);

        cetakStruk(total, bayar);

        keranjang.clear();
        jumlahBeli.clear();
    }

    private void cetakStruk(double total, double bayar) {
        System.out.println("\n ============ STRUK PEMBELIAN ============");
        System.out.println("Pembeli : " + nama);
        System.out.println("-------------------------------------------");
        for (int i = 0; i < keranjang.size(); i++) {
            Produk item = keranjang.get(i);
            int qty = jumlahBeli.get(i);
            System.out.println(item.getBarang() + " (" + item.getId() + ")");
            System.out.println(" " + qty + " x Rp" + String.format("%.0f", item.getPrice()) + " = Rp " + String.format("%.0f", item.getPrice() * qty));
            item.kurangiStock(qty);
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Total    : Rp " + String.format("%,.0f", total));
        System.out.println("Bayar    : Rp " + String.format("%,.0f", bayar));
        System.out.println("Kembalian: Rp " + String.format("%,.0f", bayar - total));
        System.out.println("=======================================================");
        System.out.println("Checkout berhasil! Terima kasih, " + nama + ".\n");
    }
}