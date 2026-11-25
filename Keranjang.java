import java.util.ArrayList;
public class Keranjang {
    private ArrayList<Produk> isi = new ArrayList<>();
    private ArrayList<Integer> jumlahBeli = new ArrayList<>();

    public void tambah(Produk p) {
        p.kurangiStock(1);
        int index = isi.indexOf(p);
        if (index != -1) {
            jumlahBeli.set(index, jumlahBeli.get(index) + 1);
        } else {
            isi.add(p);
            jumlahBeli.add(1);
        }
    }
    
    public int jumlahDi(Produk p) {
        int index = isi.indexOf(p);
        if (index != -1) {
            return jumlahBeli.get(index);
        }
        return 0;
    }

    public ArrayList<Produk> getDaftarProduk() {
        return isi;
    }

    public ArrayList<Integer> getJumlahBeli() {
        return jumlahBeli;
    }

}
