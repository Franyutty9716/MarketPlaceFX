package marketplace.controllers;

import marketplace.models.Producto;
import marketplace.utils.DataStore;
import java.util.List;

public class ProductoController {
    private DataStore dataStore;
    
    public ProductoController() {
        this.dataStore = DataStore.getInstance();
    }
    
    public List<Producto> getAllProductos() {
        return dataStore.getAllProductos();
    }
    
    public Producto getProducto(int id) {
        return dataStore.getProducto(id);
    }
}