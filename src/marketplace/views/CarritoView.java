package marketplace.views;

import javafx.concurrent.Task;
import javafx.scene.control.Dialog;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import marketplace.controllers.CarritoController;
import marketplace.models.ItemCarrito;
import marketplace.models.Producto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CarritoView {
    
    public void start(Stage stage, CarritoController carritoController, CatalogoView catalogoView) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f5f5f5;");
        
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(15, 30, 15, 30));
        header.setStyle("-fx-background-color: white;");
        
        Button backBtn = new Button("← Volver");
        backBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #667eea;");
        backBtn.setOnAction(e -> catalogoView.start(stage, carritoController.getCarrito().getUsuario()));
        
        Label titleLabel = new Label("Mi Carrito");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        header.getChildren().addAll(backBtn, spacer, titleLabel);
        
        VBox content = new VBox(20);
        content.setPadding(new Insets(30));
        
        if (carritoController.getItems().isEmpty()) {
            Label emptyLabel = new Label("Tu carrito está vacío");
            emptyLabel.setStyle("-fx-font-size: 18px;");
            content.getChildren().add(emptyLabel);
        } else {
            VBox itemsBox = new VBox(10);
            for (ItemCarrito item : carritoController.getItems()) {
                itemsBox.getChildren().add(crearItemCarrito(item, carritoController, stage, catalogoView));
            }
            
            HBox totalBox = new HBox(20);
            totalBox.setAlignment(Pos.CENTER_RIGHT);
            totalBox.setPadding(new Insets(20));
            totalBox.setStyle("-fx-background-color: white; -fx-background-radius: 12;");
            
            Label totalLabel = new Label("Total:");
            totalLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            
            Label totalMonto = new Label(String.format("$%.2f", carritoController.getTotal()));
            totalMonto.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #667eea;");

Button comprarBtn = new Button("Finalizar Compra");
comprarBtn.setStyle("-fx-background-color: #48bb78; -fx-text-fill: white; -fx-padding: 12 30; -fx-background-radius: 30;");
comprarBtn.setOnAction(e -> {
    // Confirmación de compra (igual que antes)
    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmAlert.setContentText("Total: $" + String.format("%.2f", carritoController.getTotal()) + "\n¿Confirmar compra?");
    confirmAlert.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK) {
            // Obtener el Task de compra desde el controlador
            Task<Void> tareaCompra = carritoController.finalizarCompraAsync();
            
            // Crear diálogo de progreso
            Dialog<Void> dialog = new Dialog<>();
            dialog.setTitle("Procesando compra");
            dialog.setHeaderText("Por favor espere, estamos procesando su pedido");
            
            ProgressBar progressBar = new ProgressBar();
            progressBar.setPrefWidth(300);
            progressBar.progressProperty().bind(tareaCompra.progressProperty());
            
            Label lblEstado = new Label();
            lblEstado.textProperty().bind(tareaCompra.messageProperty());
            
            VBox vbox = new VBox(10, lblEstado, progressBar);
            dialog.getDialogPane().setContent(vbox);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            
            // Cancelar
            Button btnCancel = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            btnCancel.setOnAction(ev -> {
                tareaCompra.cancel();
                dialog.close();
                Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION, "Compra cancelada.");
                cancelAlert.show();
            });
            
            // Al terminar correctamente
            tareaCompra.setOnSucceeded(event -> {
                dialog.close();
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "¡Compra realizada con éxito!");
                successAlert.show();
                // Regresar al catálogo
                catalogoView.start(stage, carritoController.getCarrito().getUsuario());
            });
            
            // Si falla
            tareaCompra.setOnFailed(event -> {
                dialog.close();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Ocurrió un error durante la compra.");
                errorAlert.show();
            });
            
            // Iniciar hilo
            Thread hilo = new Thread(tareaCompra);
            hilo.setDaemon(true);
            hilo.start();
            dialog.show();
        }
    });
});

Region spacer2 = new Region();
HBox.setHgrow(spacer2, Priority.ALWAYS);

totalBox.getChildren().addAll(totalLabel, totalMonto, spacer2, comprarBtn);
           
