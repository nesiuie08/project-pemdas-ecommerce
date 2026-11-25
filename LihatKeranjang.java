import java.util.ArrayList;
public class LihatKeranjang {
    private ArrayList<Produk> keranjang;
    private ArrayList<Integer> jumlahBeli;
    public LihatKeranjang(ArrayList<Produk> keranjang, ArrayList<Integer> jumlahBeli) {
        this.keranjang = keranjang;
        this.jumlahBeli = jumlahBeli;
    }
    public boolean kosong() {
        return keranjang.isEmpty();
    }
    public int jumlahItem() {
        return keranjang.size();
    }
    public Produk getProduk(int i) {
        return keranjang.get(i);
    }
    public int getQty(int i) {
        return jumlahBeli.get(i);
    }
    public double hitungSubtotal(int i) {
        return keranjang.get(i).getPrice() * jumlahBeli.get(i);
    }
    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            total += hitungSubtotal(i);
        }
        return total;
    }
}