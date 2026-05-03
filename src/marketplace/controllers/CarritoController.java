package marketplace.controllers;

import javafx.concurrent.Task;
import marketplace.models.*;
import java.util.List;

public class CarritoController {
    private Carrito carrito;
    
    public CarritoController(Usuario usuario) {
        this.carrito = new Carrito(usuario);
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            carrito.agregarProducto(producto, cantidad);
        }
    }
    
    public void eliminarProducto(Producto producto) {
        carrito.eliminarProducto(producto);
    }
    
    public double getTotal() {
        return carrito.getTotal();
    }
    
    public int getCantidadItems() {
        return carrito.getCantidadItems();
    }
    
    public List<ItemCarrito> getItems() {
        return carrito.getItems();
    }
    
    public void vaciarCarrito() {
        carrito.vaciar();
    }
    
    public Carrito getCarrito() {
        return carrito;
    }
}
