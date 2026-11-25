import java.util.ArrayList;
public class CatalogStore {
    private ArrayList<Produk> barang;

    public CatalogStore(){
        this.barang = new ArrayList<>();
    }
    public void addProduk(Produk produk){
        barang.add(produk); 
    }
    
    public Produk CariProdukID(String id) {
        for (Produk p : barang) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void showAllProduk() {
        System.out.println("\n=============== KATALOG TOKO ===============");
        if (barang.isEmpty()) {
            System.out.println("Belum ada produk.");
        }
        for (Produk p : barang ) {
            p.display();
        }
    }
    
}
