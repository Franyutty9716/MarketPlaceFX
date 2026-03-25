# 🛍️ MarketPlaceFX

**MarketPlaceFX** es una aplicación de comercio electrónico desarrollada con JavaFX que simula una tienda virtual completa. Cuenta con sistema de autenticación, catálogo de productos, carrito de compras y panel de administración.

---

## 📋 Tabla de Contenidos
- [Características](#-características)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Ejecución](#-ejecución)
- [Credenciales de Acceso](#-credenciales-de-acceso)
- [Funcionalidades](#-funcionalidades)
- [Interfaz Gráfica](#-interfaz-gráfica)
- [Arquitectura](#-arquitectura)
- [Datos de Ejemplo](#-datos-de-ejemplo)
- [Roadmap](#-roadmap)
- [Contribución](#-contribución)
- [Licencia](#-licencia)

---

## ✨ Características

| Característica | Descripción |
|----------------|-------------|
| 🔐 **Sistema de Autenticación** | Login seguro para clientes y administradores |
| 🛒 **Catálogo de Productos** | Visualización con diseño de tarjetas moderno |
| 🛍️ **Carrito de Compras** | Gestión completa de productos seleccionados |
| 👑 **Panel de Administración** | Gestión de productos (CRUD completo) |
| 🎨 **Interfaz Moderna** | Diseño responsive con CSS personalizado |
| 📦 **Gestión de Stock** | Control automático de inventario |
| 💰 **Cálculo de Totales** | Subtotal y total con formato de moneda |

---

## 🚀 Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| **Java** | 17+ | Lenguaje de programación principal |
| **JavaFX** | 21 | Framework para interfaz gráfica |
| **JDK** | 17+ | Java Development Kit |
| **Git** | - | Control de versiones |
| **CSS** | 3 | Estilos personalizados |

---

## 📁 Estructura del Proyecto

```
MarketPlaceFX/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── marketplace/
│       │       │
│       │       ├── Main.java                          # Punto de entrada principal
│       │       │
│       │       ├── models/                            # MODELOS DE DATOS
│       │       │   ├── Producto.java                  # Entidad Producto
│       │       │   ├── Usuario.java                   # Entidad Usuario
│       │       │   ├── Carrito.java                   # Entidad Carrito
│       │       │   └── ItemCarrito.java               # Ítem del carrito
│       │       │
│       │       ├── controllers/                       # CONTROLADORES
│       │       │   ├── UsuarioController.java         # Lógica de login/usuarios
│       │       │   ├── ProductoController.java        # Lógica de productos
│       │       │   └── CarritoController.java         # Lógica del carrito
│       │       │
│       │       ├── views/                             # VISTAS JAVAFX
│       │       │   ├── LoginView.java                 # Pantalla de login
│       │       │   ├── CatalogoView.java              # Catálogo de productos
│       │       │   ├── CarritoView.java               # Carrito de compras
│       │       │   └── AdminView.java                 # Panel administrador
│       │       │
│       │       └── utils/                             # UTILIDADES
│       │           └── DataStore.java                 # Almacenamiento en memoria
│       │
│       └── resources/
│           └── css/
│               └── style.css                          # Estilos CSS
│
├── .gitignore                                          # Archivos ignorados por Git
└── README.md                                           # Documentación
```

---

## 🔧 Instalación y Configuración

### 1. Prerrequisitos

#### Java JDK 17 o superior
```bash

```

### 3. Configurar en IntelliJ IDEA

| Paso | Acción |
|------|--------|
| 1 | File → Open → Seleccionar `MarketPlaceFX` |
| 2 | File → Project Structure → Project → SDK: JDK 17+ |
| 3 | File → Project Structure → Libraries → + → Java → `C:\javafx-sdk-21\lib` |
| 4 | Run → Edit Configurations → + → Application |
| 5 | Main class: `marketplace.Main` |
| 6 | VM options: `--module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml` |

---

## ▶️ Ejecución

### Opción 1: IntelliJ IDEA
Hacer clic en el botón verde ▶️ Run

---

## 🔑 Credenciales de Acceso

### 👑 Administrador
| Campo          | Valor      |
|----------------|------------|
| **Usuario**    | `admin`    |
| **Contraseña** | `admin123` |

### 👤 Clientes de Prueba
| Usuario  | Contraseña  | Nombre       |
|----------|-------------|--------------|
| `juan`   | `juan123`   | Juan Pérez   |
| `maria`  | `maria123`  | María López  |
| `carlos` | `carlos123` | Carlos Ruiz  |

---

## 🎯 Funcionalidades

### 🔐 Módulo de Autenticación
- Login seguro con validación de credenciales
- Redirección automática según rol (Admin/Cliente)

### 🛒 Módulo Cliente
- **Catálogo**: Visualización de productos en tarjetas con imagen, precio, stock y selector de cantidad
- **Carrito**: Agregar productos, modificar cantidades, eliminar items, ver total
- **Compra**: Proceso de finalización con confirmación

### 👑 Módulo Administrador
- **Ver productos**: Listado completo
- **Agregar producto**: Formulario para nuevos productos
- **Eliminar producto**: Remover productos del catálogo
- **Ver usuarios**: Lista de usuarios registrados

---

## 🎨 Interfaz Gráfica

### Estilos CSS Implementados
- Gradiente morado (#667eea → #764ba2) en pantalla de login
- Tarjetas de productos con sombra y efecto hover
- Botones con colores diferenciados (primario, éxito, peligro)
- Bordes redondeados y tipografía moderna

---

## 🏗️ Arquitectura

### Patrón (Model-View-Controller)

```
Vista (View) → Controlador (Controller) → Modelo (Model)
      ↑                                            ↓
      └────────────────────────────────────────────┘
```

- **Modelos**: Producto, Usuario, Carrito, ItemCarrito
- **Controladores**: UsuarioController, ProductoController, CarritoController
- **Vistas**: LoginView, CatalogoView, CarritoView, AdminView
- **Utils**: DataStore (almacenamiento en memoria)

---

## 📊 Datos de Ejemplo

### Productos Precargados

| ID | Nombre              | Precio    | Stock | Categoría   |
|----|---------------------|-----------|-------|-------------|
| 1  | Laptop Gaming       | $1,299.99 | 10    | Electrónica |
| 2  | Mouse Gaming        | $59.99    | 50    | Electrónica |
| 3  | Teclado Mecánico    | $89.99    | 30    | Electrónica |
| 4  | Monitor 27"         | $249.99   | 15    | Electrónica |
| 5  | Audífonos Bluetooth | $349.99   | 20    | Audio       |

### Usuarios Precargados

| Usuario | Nombre        | Rol     |
|---------|---------------|---------|
| admin   | Administrador | Admin   |
| juan    | Juan Pérez    | Cliente |
| maria   | María López   | Cliente |

---

<div align="center">

**Hecho con ❤️ para el curso de Tópicos Avanzados de Programación**

</div>