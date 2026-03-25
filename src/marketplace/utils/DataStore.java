package marketplace.utils;

import marketplace.models.Producto;
import marketplace.models.Usuario;
import java.util.*;

public class DataStore {
    private static DataStore instance;
    private Map<Integer, Producto> productos;
    private Map<String, Usuario> usuarios;
    
    private DataStore() {
        productos = new HashMap<>();
        usuarios = new HashMap<>();
        cargarDatosEjemplo();
    }
    
    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }
    
    private void cargarDatosEjemplo() {
        productos.put(1, new Producto(1, "Laptop Gaming", 1299.99, 10, "Electronica"));
        productos.put(2, new Producto(2, "Mouse Gaming", 59.99, 50, "Electronica"));
        productos.put(3, new Producto(3, "Teclado Mecanico", 89.99, 30, "Electronica"));
        productos.put(4, new Producto(4, "Monitor 27 pulgadas", 249.99, 15, "Electronica"));
        productos.put(5, new Producto(5, "Audifonos Bluetooth", 349.99, 20, "Audio"));
        
        usuarios.put("admin", new Usuario("admin", "admin123", "Administrador", "admin@marketplace.com", true));
        usuarios.put("juan", new Usuario("juan", "juan123", "Juan Perez", "juan@email.com", false));
        usuarios.put("maria", new Usuario("maria", "maria123", "Maria Lopez", "maria@email.com", false));
    }
    
    public Producto getProducto(int id) { return productos.get(id); }
    public List<Producto> getAllProductos() { return new ArrayList<>(productos.values()); }
    public Usuario getUsuario(String username) { return usuarios.get(username); }
    
    public boolean validarUsuario(String username, String password) {
        Usuario usuario = usuarios.get(username);
        return usuario != null && usuario.getPassword().equals(password);
    }
}