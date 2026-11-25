public class Produk {
    private String barang;
    private String ID;
    private int stock; 
    private double harga;

    public Produk(String ID, String barang, double harga, int stock){
        this.barang = barang;
        this.ID = ID;
        this.stock = stock;
        this.harga = harga; 
    }
    public String getId() {
        return ID;
    }

    public String getBarang() {
        return barang;
    }

    public double getPrice() {
        return harga;
    }

    public int getStock() {
        return stock;
    }
    
    public void kurangiStock(int qty) {
        if (qty <= this.stock) {
            this.stock -= qty;
        }
    }
    public void display(){
        System.out.println("[" + ID + "] " + barang + " - Rp" + harga + " (Stok: " + stock + ")");
    }
}
