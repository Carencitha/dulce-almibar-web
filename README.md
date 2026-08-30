
````markdown
# 🍬 Dulce de Almíbar Web



Sistema web para apoyar la **producción, inventario, comercialización, pedidos, pagos y facturación** de productos de dulce de almíbar.

El proyecto fue desarrollado de forma **individual** como parte de mi formación en Ingeniería de Sistemas y busca integrar en una sola aplicación procesos administrativos y funcionalidades orientadas al cliente.

---

## 📌 Descripción del proyecto

**Dulce de Almíbar Web** es una aplicación construida con Java y Spring Boot que permite centralizar diferentes procesos de un emprendimiento dedicado a la producción y venta de productos de dulce de almíbar.

El sistema cuenta con vistas para clientes y administración, y permite trabajar con información relacionada con:

- Usuarios.
- Productos.
- Insumos.
- Proveedores.
- Pedidos.
- Detalles de pedidos.
- Pagos.
- Facturas.
- Inventario y disponibilidad de productos.

La información se almacena principalmente en **PostgreSQL** mediante Spring Data JPA e Hibernate. Para demostraciones o pruebas rápidas también puede utilizarse un perfil con **H2 en memoria**.

---

# 🎯 Objetivo del proyecto

Desarrollar una aplicación web que permita apoyar la gestión de los procesos de producción y comercialización de dulce de almíbar, centralizando la información del negocio y facilitando la administración de productos, insumos, proveedores, pedidos, pagos y facturación.

El sistema busca:

- Facilitar el registro y consulta de productos.
- Llevar control del stock disponible.
- Gestionar insumos utilizados dentro del proceso productivo.
- Registrar y consultar proveedores.
- Permitir el registro de clientes.
- Gestionar pedidos realizados por los clientes.
- Registrar pagos asociados a los pedidos.
- Generar y consultar facturas.
- Separar las funcionalidades administrativas de las funcionalidades del cliente.

---

# 👥 Tipos de usuario

El sistema contempla dos roles principales:

| Rol | Funciones principales |
|---|---|
| **CLIENTE** | Registro, inicio de sesión, consulta del catálogo, realización de pedidos, registro de pagos y consulta de pedidos y facturas |
| **ADMIN** | Acceso al panel administrativo y gestión de productos, insumos, proveedores, pedidos y facturas |

Los roles están definidos mediante el enum `Rol` y se almacenan dentro de la entidad `Usuario`.

---

# ✨ Funcionalidades principales

## 👤 Registro e inicio de sesión

El sistema permite:

- Registrar nuevos clientes.
- Validar que el correo no se encuentre registrado previamente.
- Iniciar sesión mediante correo y contraseña.
- Guardar el usuario autenticado en sesión.
- Redirigir al usuario según su rol.
- Cerrar sesión.

Flujo general:

```text
Usuario
   ↓
Registro / Inicio de sesión
   ↓
Validación
   ↓
┌─────────────────┬─────────────────┐
│      ADMIN      │     CLIENTE     │
│        ↓        │        ↓        │
│   Dashboard     │    Catálogo     │
└─────────────────┴─────────────────┘
````

---

## 🍯 Gestión de productos

Desde el módulo administrativo es posible:

* Consultar productos.
* Registrar nuevos productos.
* Editar información existente.
* Eliminar productos.
* Definir nombre, descripción y categoría.
* Registrar precio.
* Controlar stock.
* Definir si un producto está activo.
* Asociar un elemento visual mediante emoji.

Los clientes pueden visualizar los productos disponibles desde el catálogo.

---

## 📦 Gestión de insumos

El sistema permite administrar información relacionada con los insumos utilizados dentro del proceso productivo.

Cada insumo puede contener:

* Nombre.
* Cantidad.
* Unidad de medida.
* Stock mínimo.
* Proveedor.
* Estado activo/inactivo.

Desde el panel administrativo se pueden crear, editar, consultar y eliminar registros de insumos.

---

## 🚚 Gestión de proveedores

El módulo de proveedores permite almacenar información como:

* Nombre.
* Contacto.
* Teléfono.
* Correo electrónico.
* Dirección.
* Tipo de insumo suministrado.
* Estado del proveedor.

La administración puede registrar, editar y eliminar proveedores.

---

## 🛒 Gestión de pedidos

Los clientes pueden realizar pedidos seleccionando productos disponibles.

Cada pedido almacena información como:

* Nombre del cliente.
* Correo.
* Teléfono.
* Dirección.
* Observaciones.
* Total.
* Estado del pedido.
* Fecha de creación.
* Detalle de los productos solicitados.

Los detalles del pedido contienen:

* Producto.
* Cantidad.
* Precio unitario.
* Subtotal.

El administrador puede consultar los pedidos y actualizar su estado.

---

## 💳 Gestión de pagos

El sistema incluye un módulo para asociar pagos con pedidos.

Cada pago puede registrar:

* Pedido relacionado.
* Método de pago.
* Valor pagado.
* Estado del pago.
* Referencia.
* Fecha del pago.

---

## 🧾 Facturación

El sistema permite generar y consultar facturas relacionadas con los pedidos.

Una factura almacena:

* Número de factura.
* Pedido asociado.
* Información del cliente.
* Subtotal.
* IVA.
* Total.
* Estado de la factura.
* Fecha de emisión.

Los clientes pueden consultar sus facturas y el administrador puede revisar las facturas generadas.

---

# 🛠️ Tecnologías utilizadas

| Tecnología             | Uso dentro del proyecto                            |
| ---------------------- | -------------------------------------------------- |
| **Java 21**            | Lenguaje principal                                 |
| **Spring Boot 4.0.6**  | Desarrollo y configuración de la aplicación        |
| **Spring Web MVC**     | Controladores y navegación web                     |
| **Spring Data JPA**    | Persistencia y acceso a datos                      |
| **Hibernate**          | Mapeo objeto-relacional                            |
| **PostgreSQL**         | Base de datos principal                            |
| **H2**                 | Base de datos temporal para demostración           |
| **Thymeleaf**          | Renderizado dinámico de vistas HTML                |
| **Spring Security**    | Infraestructura de seguridad integrada al proyecto |
| **Jakarta Validation** | Validación de datos                                |
| **Lombok**             | Reducción de código repetitivo en entidades        |
| **HTML**               | Estructura de las interfaces                       |
| **CSS**                | Diseño visual                                      |
| **Maven**              | Gestión de dependencias y ejecución                |
| **Git / GitHub**       | Control de versiones y publicación del proyecto    |

---

# 🧩 Arquitectura del sistema

El proyecto sigue una organización por capas:

```text
┌───────────────────────────────────┐
│           VISTAS WEB              │
│      Thymeleaf + HTML + CSS       │
└────────────────┬──────────────────┘
                 │
                 ↓
┌───────────────────────────────────┐
│          CONTROLLERS              │
│  Reciben solicitudes del usuario │
└────────────────┬──────────────────┘
                 │
                 ↓
┌───────────────────────────────────┐
│            SERVICES               │
│       Lógica de negocio           │
└────────────────┬──────────────────┘
                 │
                 ↓
┌───────────────────────────────────┐
│          REPOSITORIES             │
│       Spring Data JPA             │
└────────────────┬──────────────────┘
                 │
                 ↓
┌───────────────────────────────────┐
│          BASE DE DATOS            │
│      PostgreSQL / H2 demo         │
└───────────────────────────────────┘
```

Esta separación facilita el mantenimiento del proyecto y evita concentrar toda la lógica dentro de una sola clase.

---

# 📂 Estructura del proyecto

```text
dulce-almibar-web/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jdc/dulcealmibar/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── DulceAlmibarApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       ├── application.properties
│   │       └── application-demo.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# 🗄️ Modelo de datos

El sistema trabaja con las siguientes entidades principales:

| Entidad         | Propósito                                 |
| --------------- | ----------------------------------------- |
| `Usuario`       | Información de clientes y administradores |
| `Producto`      | Catálogo, precio y stock                  |
| `Insumo`        | Insumos utilizados en producción          |
| `Proveedor`     | Información de proveedores                |
| `Pedido`        | Información general de una compra         |
| `DetallePedido` | Productos y cantidades de cada pedido     |
| `Pago`          | Información del pago de un pedido         |
| `Factura`       | Facturación asociada a pedidos            |

---

# 🔗 Relaciones principales

## Pedido → DetallePedido

```text
PEDIDO
  │
  │ 1
  │
  └──────────── N
          DETALLE_PEDIDO
```

## Pedido → Pago

```text
PEDIDO ─────── PAGO
        1 : 1
```

## Pedido → Factura

```text
PEDIDO ─────── FACTURA
        1 : 1
```

---

# 🔄 Flujo general del sistema

```text
Cliente
   ↓
Registro / Login
   ↓
Catálogo de productos
   ↓
Selección de productos
   ↓
Creación del pedido
   ↓
Detalle del pedido
   ↓
Registro del pago
   ↓
Generación / consulta de factura
```

Desde la administración:

```text
Administrador
      ↓
Dashboard
      ↓
┌────────────┬────────────┬──────────────┐
│ Productos  │  Insumos   │ Proveedores │
└────────────┴────────────┴──────────────┘
      ↓
Pedidos
      ↓
Facturas
```

---

# 🌐 Rutas principales

## Rutas públicas y autenticación

| Método | Ruta        | Descripción                    |
| ------ | ----------- | ------------------------------ |
| GET    | `/`         | Página principal               |
| GET    | `/login`    | Formulario de inicio de sesión |
| POST   | `/login`    | Procesa el inicio de sesión    |
| GET    | `/registro` | Formulario de registro         |
| POST   | `/registro` | Registra un cliente            |
| GET    | `/logout`   | Cierra la sesión               |

## Rutas de cliente

| Método | Ruta                       | Descripción                      |
| ------ | -------------------------- | -------------------------------- |
| GET    | `/cliente/inicio`          | Inicio del cliente               |
| GET    | `/cliente/catalogo`        | Catálogo de productos            |
| GET    | `/cliente/pedido`          | Formulario de pedido             |
| POST   | `/cliente/pedido/guardar`  | Guarda un pedido                 |
| GET    | `/cliente/mis-pedidos`     | Consulta los pedidos del cliente |
| GET    | `/cliente/pago/{pedidoId}` | Formulario de pago               |
| POST   | `/cliente/pago/guardar`    | Registra el pago                 |
| GET    | `/cliente/mis-facturas`    | Consulta facturas                |

## Rutas administrativas

| Método | Ruta                             | Descripción            |
| ------ | -------------------------------- | ---------------------- |
| GET    | `/admin/dashboard`               | Panel administrativo   |
| GET    | `/admin/productos`               | Gestión de productos   |
| POST   | `/admin/productos/guardar`       | Guarda un producto     |
| GET    | `/admin/productos/editar/{id}`   | Edita un producto      |
| GET    | `/admin/productos/eliminar/{id}` | Elimina un producto    |
| GET    | `/admin/insumos`                 | Gestión de insumos     |
| POST   | `/admin/insumos/guardar`         | Guarda un insumo       |
| GET    | `/admin/proveedores`             | Gestión de proveedores |
| POST   | `/admin/proveedores/guardar`     | Guarda un proveedor    |
| GET    | `/admin/pedidos`                 | Consulta pedidos       |
| GET    | `/admin/facturas`                | Consulta facturas      |

---

# 💾 Configuración con PostgreSQL

El archivo principal de configuración se encuentra en:

```text
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/dulce_almibar}
spring.datasource.username=${DB_USER:postgres}
spring.datasource.password=${DB_PASSWORD:}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

---

# 🐘 Crear la base de datos

```sql
CREATE DATABASE dulce_almibar;
```

Luego configurar:

```text
DB_URL=jdbc:postgresql://localhost:5432/dulce_almibar
DB_USER=postgres
DB_PASSWORD=TU_CONTRASEÑA
```

> ⚠️ No publiques contraseñas reales dentro del repositorio.

---

# 📋 Requisitos

* Java JDK 21
* PostgreSQL
* Maven o Maven Wrapper
* Git
* Navegador web
* IDE opcional: IntelliJ IDEA, VS Code o Eclipse

---

# 📥 Clonar el repositorio

```bash
git clone https://github.com/Carencitha/dulce-almibar-web.git
cd dulce-almibar-web
```

---

# ▶️ Ejecutar con PostgreSQL

## Windows

```powershell
.\mvnw.cmd spring-boot:run
```

o:

```powershell
mvn spring-boot:run
```

## Linux / macOS

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

o:

```bash
mvn spring-boot:run
```

Después abrir:

```text
http://localhost:8081
```

---

# 🧪 Modo demo con H2

El proyecto incluye una configuración alternativa para ejecutarse sin PostgreSQL.

Archivo:

```text
src/main/resources/application-demo.properties
```

Ejecutar con:

```bash
SPRING_PROFILES_ACTIVE=demo mvn spring-boot:run
```

Este modo utiliza una base de datos H2 en memoria.

---

# ☁️ GitHub Codespaces

También puede ejecutarse directamente desde GitHub Codespaces.

Ruta:

```text
Code
   ↓
Codespaces
   ↓
Create codespace on main
```

Verificar Java:

```bash
java -version
javac -version
```

Luego ejecutar:

```bash
SPRING_PROFILES_ACTIVE=demo mvn spring-boot:run
```

Cuando aparezca:

```text
Tomcat started on port 8081
Started DulceAlmibarApplication
```

abrir la pestaña **Ports / Puertos** y seleccionar el puerto `8081`.

---

# ⚠️ Funcionamiento de H2

La base de datos de demostración utiliza memoria temporal.

Esto significa que:

* Se crea al iniciar la aplicación.
* Los datos originales de PostgreSQL no aparecen automáticamente.
* Los datos temporales pueden perderse al detener la aplicación.
* Se utiliza únicamente para demostraciones y pruebas rápidas.

---

# 🔐 Consideraciones de seguridad

Al tratarse de un proyecto académico, existen aspectos que pueden fortalecerse:

* Implementar BCrypt para almacenamiento seguro de contraseñas.
* Mejorar el control de acceso por roles.
* Fortalecer la configuración de Spring Security.
* Implementar recuperación segura de contraseña.
* Utilizar secretos y variables de entorno en producción.
* Agregar validaciones adicionales.
* Fortalecer la protección CSRF.

---

# 📈 Mejoras futuras

* Dashboard de ventas.
* Reportes de productos más vendidos.
* Alertas de inventario.
* Historial de movimientos.
* Notificaciones.
* Recuperación de contraseña.
* Pasarela de pagos.
* Facturas PDF.
* Exportación a Excel.
* Pruebas automatizadas.
* Diseño responsive.
* Despliegue en la nube.
* API REST.

---

# 🎓 Competencias aplicadas

* Java.
* Spring Boot.
* Desarrollo backend.
* Desarrollo web.
* PostgreSQL.
* SQL.
* Spring Data JPA.
* Hibernate.
* HTML.
* CSS.
* Thymeleaf.
* Maven.
* Arquitectura por capas.
* Modelado de bases de datos.
* Git y GitHub.

---

# 👩‍💻 Mi participación

Este proyecto fue desarrollado **de manera individual**.

Estuve a cargo de:

* Análisis de funcionalidades.
* Diseño de la estructura del sistema.
* Desarrollo del backend.
* Creación de entidades.
* Creación de repositorios.
* Implementación de servicios.
* Desarrollo de controladores.
* Modelado de la base de datos.
* Integración con PostgreSQL.
* Desarrollo de vistas web.
* Gestión de productos.
* Gestión de insumos.
* Gestión de proveedores.
* Gestión de pedidos.
* Registro de pagos.
* Facturación.
* Pruebas y ajustes funcionales.

---

# 📚 Aprendizajes obtenidos

El desarrollo del proyecto permitió comprender de forma práctica la relación entre:

```text
Interfaz
   ↓
Controlador
   ↓
Servicio
   ↓
Repositorio
   ↓
Base de datos
```

También permitió fortalecer conocimientos en:

* Organización de proyectos de software.
* Integración frontend/backend.
* Bases de datos relacionales.
* Resolución de errores.
* Arquitectura por capas.
* Desarrollo de funcionalidades completas.
* Control de versiones.

---

# 📌 Estado actual

🟡 **Proyecto académico funcional en proceso de mejora.**

La versión principal utiliza PostgreSQL y el perfil `demo` permite realizar pruebas rápidas utilizando H2.

---

# 👩‍🎓 Autora

**Caren Garcia**
Estudiante de Ingeniería de Sistemas
Fundación Universitaria Juan de Castellanos

### Áreas de interés

* 💻 Desarrollo de software
* 📊 Análisis de datos
* 🔐 Ciberseguridad
* 📋 Liderazgo y gestión de proyectos tecnológicos

---

# 📄 Uso

Este repositorio se publica con fines **académicos y de portafolio profesional**.

El código puede utilizarse como referencia educativa respetando la autoría del proyecto.

```

Ese reemplaza completamente el README viejo que pegaste.
```
