package marketplace.views;

import marketplace.controllers.ProductoController;
import marketplace.models.Producto;
import marketplace.models.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminView {
    private ProductoController productoController = new ProductoController();
    
    public void start(Stage primaryStage, Usuario usuario) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f5f5f5;");
        
        HBox topBar = new HBox(20);
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(15, 30, 15, 30));
        topBar.setStyle("-fx-background-color: white;");
        
        Label welcomeLabel = new Label("Admin: " + usuario.getNombre());
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Button logoutBtn = new Button("Salir");
        logoutBtn.setStyle("-fx-background-color: #e53e3e; -fx-text-fill: white; -fx-padding: 8 20; -fx-background-radius: 20;");
        logoutBtn.setOnAction(e -> {
            LoginView loginView = new LoginView();
            loginView.start(primaryStage);
        });
        
        topBar.getChildren().addAll(welcomeLabel, spacer, logoutBtn);
        
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(30, 20, 30, 20));
        sidebar.setStyle("-fx-background-color: white;");
        sidebar.setPrefWidth(250);
        
        Label menuLabel = new Label("Panel Admin");
        menuLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #667eea;");
        
        Button productosBtn = new Button("Ver Productos");
        productosBtn.setOnAction(e -> mostrarProductos(root));
        
        Button agregarBtn = new Button("Agregar Producto");
        agregarBtn.setOnAction(e -> mostrarFormularioAgregar(root));
        
        Button usuariosBtn = new Button("Ver Usuarios");
        usuariosBtn.setOnAction(e -> mostrarUsuarios(root));
        
        sidebar.getChildren().addAll(menuLabel, new Separator(), productosBtn, agregarBtn, usuariosBtn);
        
        VBox defaultContent = new VBox();
        defaultContent.setAlignment(Pos.CENTER);
        defaultContent.setPadding(new Insets(50));
        Label defaultLabel = new Label("Seleccione una opcion");
        defaultContent.getChildren().add(defaultLabel);
        
        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(defaultContent);
        
        Scene scene = new Scene(root, 1100, 700);
        primaryStage.setTitle("MarketPlace FX - Admin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void mostrarProductos(BorderPane root) {
        VBox content = new VBox(15);
        content.setPadding(new Insets(30));
        
        Label title = new Label("Lista de Productos");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        ListView<String> listView = new ListView<>();
        for (Producto p : productoController.getAllProductos()) {
            listView.getItems().add(p.getId() + " | " + p.getNombre() + " | " + p.getPrecioFormateado());
        }
        
        content.getChildren().addAll(title, listView);
        root.setCenter(content);
    }
    
    private void mostrarFormularioAgregar(BorderPane root) {
        VBox content = new VBox(15);
        content.setPadding(new Insets(30));
        content.setMaxWidth(400);
        
        Label title = new Label("Agregar Producto");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");
        
        TextField precioField = new TextField();
        precioField.setPromptText("Precio");
        
        TextField stockField = new TextField();
        stockField.setPromptText("Stock");
        
        TextField categoriaField = new TextField();
        categoriaField.setPromptText("Categoria");
        
        Button guardarBtn = new Button("Guardar");
        guardarBtn.setOnAction(e -> {
            int id = productoController.getAllProductos().size() + 1;
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());
            String categoria = categoriaField.getText();
            
            Producto nuevo = new Producto(id, nombre, precio, stock, categoria);
            productoController.getAllProductos().add(nuevo);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Producto agregado");
            alert.show();
            
            mostrarProductos(root);
        });
        
        content.getChildren().addAll(title, nombreField, precioField, stockField, categoriaField, guardarBtn);
        root.setCenter(content);
    }
    
    private void mostrarUsuarios(BorderPane root) {
        VBox content = new VBox(15);
        content.setPadding(new Insets(30));
        
        Label title = new Label("Usuarios");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        ListView<String> listView = new ListView<>();
        listView.getItems().add("admin | Administrador");
        listView.getItems().add("juan | Cliente");
        listView.getItems().add("maria | Cliente");
        
        content.getChildren().addAll(title, listView);
        root.setCenter(content);
    }
}