# Secure Inventory App, Proyecto de Maven


Aplicación Java CLI (Command Line Interface) para la gestión de inventario siguiendo principios de Arquitectura Limpia y POO/SOLID.

Permite agregar, actualizar, eliminar y listar productos desde la consola, usando una implementación en memoria (sin base de datos).

---

## Prerrequisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado:

* Java 17 o superior  
  Verifica la versión:
  ```bash
  java -version
  ```

* Apache Maven 3.8 o superior
    Verifica la versión:

  ```bash
  mvn -v
  ```

---

## Instalación y compilación


1. Clona este repositorio en un folder local, ejecutando el siguiente comando:

   ```bash
   git clone https://github.com/tu-usuario/secure-inventory-app.git
   cd secure-inventory-app
   ```

2. Compila el proyecto, este deberia de mostar el compilado como funcional o correcto:

   ```bash
   mvn clean compile
   ```

   Este comando descargará las dependencias necesarias y generará las clases compiladas en la carpeta `target/`.

---

## Ejecución de la aplicación

Para iniciar la aplicación en modo consola, ejecuta el siguiente comando, este mostrara un printo con el funcionamiento del codigo:

```bash
mvn exec:java
```

Gracias a la configuración en el archivo `pom.xml`, no necesitas especificar la clase principal.

La aplicación mostrará un menú interactivo en la terminal, por ejemplo:

```
--- Sistema de Gestión de Inventario ---
1. Agregar Producto
2. Actualizar Producto
3. Eliminar Producto
4. Listar Todos los Productos
0. Salir
Seleccione una opción:
```

---

## Empaquetar en un JAR ejecutable

Si deseas crear un JAR para distribuirlo, este en dado caso que se requiera la distribucion privada o comercial de este, usa el siguiente comando:

```bash
mvn clean package
```

Esto generará un archivo en:

```
target/secure-inventory-app-1.0-SNAPSHOT.jar
```

Para ejecutarlo:

```bash
java -jar target/secure-inventory-app-1.0-SNAPSHOT.jar
```

---

## Estructura del proyecto


```
secure-inventory-app/
│
├─ src/
│  ├─ main/
│  │  ├─ java/com/inventory/                  
│  │  │  ├─ domain/                          
│  │  │  │  ├─ Product.java                  
│  │  │  │  └─ ProductRepository.java        
│  │  │  │
│  │  │  ├─ usecases/                         
│  │  │  │  ├─ AddProductUseCase.java        
│  │  │  │  ├─ UpdateProductUseCase.java    
│  │  │  │  ├─ DeleteProductUseCase.java      
│  │  │  │  └─ ListAllProductsUseCase.java    
│  │  │  │
│  │  │  ├─ adapters/                         
│  │  │  │  ├─ controller/
│  │  │  │  │  └─ ProductController.java      
│  │  │  │  └─ persistence/
│  │  │  │     └─ ProductRepositoryImpl.java  
│  │  │  │
│  │  │  └─ cli/
│  │  │     └─ Main.java                      
│  │  │
│  │  └─ resources/                           
│  │
│  └─ test/                                   
│     └─ java/com/inventory/
│        └─ AppTest.java                      
│
├─ target/                                    
│
├─ pom.xml                                    
└─ README.md                                  

```
---

