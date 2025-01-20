# LiterALURA

**LiterALURA** es un proyecto en Java que permite buscar libros a través de la API Gutendex, almacenarlos en una base de datos PostgreSQL y consultar sus detalles mediante una interfaz de texto interactiva en la consola.

## Características

- Búsqueda de libros por término utilizando la [API Gutendex](https://gutendex.com/).
- Análisis de la respuesta JSON para extraer título y autor de los libros.
- Almacenamiento de los libros encontrados en una base de datos PostgreSQL.
- Consulta de libros almacenados directamente desde la base de datos.
- Interfaz textual interactiva para una experiencia sencilla.

## Requisitos

Antes de ejecutar el proyecto, asegúrate de cumplir con los siguientes requisitos:

- Java 17 o superior
- PostgreSQL instalado y en ejecución
- IntelliJ IDEA (opcional, pero recomendado para desarrollo)

## Configuración

### Base de datos PostgreSQL

1. Crea una base de datos llamada `literalura`:
   ```sql
   CREATE DATABASE literalura;
   ```

2. Configura un usuario con permisos para acceder a esta base de datos y anota sus credenciales.

3. La tabla de libros se creará automáticamente al ejecutar el programa.

### Configuración del Proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Ssjeison/LiterALURA.git
   ```

2. Abre el proyecto en IntelliJ IDEA.

3. Configura las credenciales de tu base de datos en el archivo `DatabaseConfig.java`:
   ```java
   public class DatabaseConfig {
       public static final String DB_URL = "jdbc:postgresql://localhost:5432/literalura";
       public static final String DB_USER = "tu_usuario";
       public static final String DB_PASSWORD = "tu_contraseña";
   }
   ```

4. Asegúrate de que las dependencias en `pom.xml` están actualizadas:
   ```xml
   <dependency>
       <groupId>org.postgresql</groupId>
       <artifactId>postgresql</artifactId>
       <version>42.6.0</version>
   </dependency>
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>
   ```

5. Construye el proyecto y ejecuta el archivo `Main.java`.

## Uso

1. Al ejecutar el programa, verás un menú interactivo:

   ```
   === Menú ===
   1. Buscar libros
   2. Ver libros en la base de datos
   3. Salir
   ```

2. Selecciona la opción 1 para buscar libros e ingresa un término de búsqueda (por ejemplo: `adventure`). Los resultados se mostrarán en la consola y se almacenarán en la base de datos.

3. Selecciona la opción 2 para ver los libros almacenados en la base de datos.

4. Selecciona la opción 3 para salir del programa.

## Contribución

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu feature o corrección de bugs:
   ```bash
   git checkout -b feature/nueva-feature
   ```
3. Realiza tus cambios y realiza un commit:
   ```bash
   git commit -m "Descripción de los cambios"
   ```
4. Haz un push de tus cambios a tu rama:
   ```bash
   git push origin feature/nueva-feature
   ```
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Autor

**Ssjeison**  
[GitHub - Ssjeison](https://github.com/Ssjeison)

