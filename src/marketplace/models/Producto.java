package marketplace.models;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    
    public Producto(int id, String nombre, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getCategoria() { return categoria; }
    public void setStock(int stock) { this.stock = stock; }
    
    public String getPrecioFormateado() {
        return String.format("$%.2f", precio);
    }
}