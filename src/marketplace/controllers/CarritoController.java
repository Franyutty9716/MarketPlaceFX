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

/**
* Ejecuta el proceso de compra en un hilo en segundo plano.
* @return un Task que realiza las operaciones de la compra.
*/
public Task<Void> finalizarCompraAsync() {
    return new Task<>() {
        @Override
        protected Void call() throws Exception {
            // 1. Validar stock (Simulado)
            updateMessage("Validando stock...");
            updateProgress(0, 100);
            Thread.sleep(1000); // Reemplaza esto con tu lógica de validación real

            // 2. Procesar pago (Simulado)
            updateMessage("Procesando pago...");
            updateProgress(30, 100);
            Thread.sleep(1500); // Aquí iría la lógica de pago

            // 3. Actualizar inventario (Simulado)
            updateMessage("Actualizando inventario...");
            updateProgress(70, 100);
            Thread.sleep(1000); // Aquí iría la lógica para reducir el stock

            // 4. Generar ticket (Simulado)
            updateMessage("Generando ticket...");
            updateProgress(90, 100);
            Thread.sleep(500); // Aquí iría la lógica para guardar la venta

            // 5. Si todo sale bien, vaciamos el carrito
            updateMessage("¡Compra completada!");
            updateProgress(100, 100);
            vaciarCarrito(); // Limpia el carrito en el modelo
            return null;
        }
    };
}
