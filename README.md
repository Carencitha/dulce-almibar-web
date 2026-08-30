# Dulce de Almíbar Web

Sistema web para apoyar la **producción, inventario, pedidos, ventas y facturación**
de productos de dulce de almíbar.

## Descripción

Proyecto académico desarrollado de forma individual. La aplicación cuenta con
funcionalidades para clientes y administración, permitiendo gestionar productos,
insumos, proveedores, pedidos, pagos y facturas.

## Tecnologías

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Thymeleaf
- HTML
- CSS
- Maven

## Funcionalidades principales

- Registro e inicio de sesión de usuarios.
- Catálogo de productos.
- Gestión de productos e inventario.
- Gestión de insumos y proveedores.
- Registro y seguimiento de pedidos.
- Registro de pagos.
- Generación y consulta de facturas.
- Panel administrativo.
- Consulta de pedidos y facturas por parte del cliente.

## Mi participación

Proyecto desarrollado de manera individual. Se trabajó en el backend, modelado
y conexión con la base de datos, lógica del sistema, controladores, servicios,
repositorios e interfaces web.

## Configuración de base de datos

La aplicación admite variables de entorno:

```text
DB_URL=jdbc:postgresql://localhost:5432/dulce_almibar
DB_USER=postgres
DB_PASSWORD=tu_contraseña
```

Nunca publiques contraseñas reales dentro del repositorio.

## Ejecución

1. Crear una base de datos PostgreSQL llamada `dulce_almibar`.
2. Configurar las variables de entorno indicadas arriba.
3. Ejecutar:

   ```bash
   ./mvnw spring-boot:run
   ```

   En Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

4. Abrir `http://localhost:8081`.

## Autora

**Caren Garcia**  
Estudiante de Ingeniería de Sistemas.
