
# 🍬 Dulce de Almíbar Web

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Templates-green)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Estado](https://img.shields.io/badge/Estado-Proyecto%20académico-yellow)

Sistema web orientado a apoyar la **producción, inventario, comercialización, pedidos, pagos y facturación** de productos de dulce de almíbar.

Este proyecto fue desarrollado de forma **individual** como parte de mi formación en Ingeniería de Sistemas y busca integrar en una sola aplicación diferentes procesos administrativos y funcionalidades orientadas al cliente.

---

## 📌 Descripción del proyecto

**Dulce de Almíbar Web** es una aplicación desarrollada con Java y Spring Boot que permite centralizar diferentes procesos de un emprendimiento dedicado a la producción y comercialización de productos de dulce de almíbar.

El sistema cuenta con funcionalidades tanto para clientes como para administración y permite gestionar información relacionada con:

- Usuarios.
- Productos.
- Inventario.
- Insumos.
- Proveedores.
- Pedidos.
- Detalles de pedidos.
- Pagos.
- Facturas.

La información se almacena principalmente en una base de datos **PostgreSQL**, utilizando Spring Data JPA e Hibernate para la persistencia y gestión de los datos.

Adicionalmente, el proyecto cuenta con un perfil de demostración utilizando **H2 en memoria**, que permite ejecutar la aplicación para realizar pruebas sin necesidad de instalar PostgreSQL.

---

## 🎯 Objetivo del proyecto

Desarrollar una aplicación web que permita apoyar la gestión de los procesos de producción y comercialización de dulce de almíbar, centralizando la información del negocio y facilitando la administración de productos, inventario, insumos, proveedores, pedidos, pagos y facturación.

### Objetivos funcionales

- Facilitar el registro y consulta de productos.
- Gestionar la disponibilidad y el stock.
- Administrar los insumos utilizados en el proceso productivo.
- Registrar y consultar proveedores.
- Permitir el registro de clientes.
- Gestionar pedidos realizados por los clientes.
- Registrar pagos asociados a los pedidos.
- Generar y consultar facturas.
- Organizar las funcionalidades de acuerdo con el tipo de usuario.

---

## 👥 Tipos de usuario

El sistema contempla dos tipos principales de usuario.

### 👤 Cliente

El cliente puede:

- Registrarse en la plataforma.
- Iniciar sesión.
- Consultar el catálogo.
- Visualizar productos disponibles.
- Realizar pedidos.
- Registrar pagos.
- Consultar sus pedidos.
- Consultar sus facturas.

### ⚙️ Administrador

El administrador puede acceder al panel administrativo y gestionar:

- Productos.
- Inventario.
- Insumos.
- Proveedores.
- Pedidos.
- Facturas.

Los tipos de usuario se encuentran asociados a los roles definidos dentro de la aplicación.

---

## ✨ Funcionalidades principales

### 👤 Registro e inicio de sesión

El sistema permite registrar nuevos clientes y validar que el correo electrónico ingresado no se encuentre previamente registrado.

Los usuarios pueden iniciar sesión utilizando su correo electrónico y contraseña.

Después de validar los datos, el sistema identifica el rol correspondiente y dirige al usuario hacia la sección adecuada.

- Si el usuario tiene rol de **administrador**, accede al panel administrativo.
- Si el usuario tiene rol de **cliente**, accede a las funcionalidades correspondientes al cliente.

El sistema también permite mantener la sesión durante la navegación y cerrarla cuando el usuario lo desee.

---

### 🍯 Gestión de productos

Desde el módulo administrativo es posible:

- Consultar productos.
- Registrar nuevos productos.
- Modificar información de productos existentes.
- Eliminar productos.
- Registrar nombre y descripción.
- Definir categorías.
- Establecer precios.
- Controlar el stock.
- Gestionar la disponibilidad de los productos.

Los clientes pueden visualizar los productos disponibles desde el catálogo.

---

### 📦 Gestión de inventario e insumos

El sistema permite administrar los insumos utilizados dentro del proceso de producción.

Para cada insumo se puede almacenar información relacionada con:

- Nombre.
- Cantidad.
- Unidad de medida.
- Stock mínimo.
- Proveedor asociado.
- Estado.

Desde el área administrativa es posible consultar, registrar, modificar y eliminar esta información.

---

### 🚚 Gestión de proveedores

El módulo de proveedores permite registrar y administrar información relacionada con las personas o empresas encargadas de suministrar los insumos.

Entre los datos gestionados se encuentran:

- Nombre.
- Información de contacto.
- Teléfono.
- Correo electrónico.
- Dirección.
- Tipo de insumo suministrado.
- Estado del proveedor.

---

### 🛒 Gestión de pedidos

Los clientes pueden realizar pedidos utilizando los productos disponibles en el sistema.

Cada pedido puede contener información relacionada con:

- Cliente.
- Correo electrónico.
- Teléfono.
- Dirección.
- Observaciones.
- Valor total.
- Estado del pedido.
- Fecha de creación.

También se registra el detalle de los productos seleccionados, incluyendo:

- Producto.
- Cantidad.
- Precio unitario.
- Subtotal.

El administrador puede consultar los pedidos realizados y gestionar su estado.

---

### 💳 Gestión de pagos

El sistema permite registrar información relacionada con los pagos de los pedidos.

Cada pago puede incluir:

- Pedido asociado.
- Método de pago.
- Valor pagado.
- Estado del pago.
- Referencia.
- Fecha del pago.

---

### 🧾 Facturación

El sistema permite generar y consultar facturas relacionadas con los pedidos.

Cada factura puede almacenar:

- Número de factura.
- Pedido asociado.
- Información del cliente.
- Subtotal.
- IVA.
- Total.
- Estado.
- Fecha de emisión.

Los clientes pueden consultar sus facturas y el administrador puede revisar la información asociada a la facturación.

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso dentro del proyecto |
|---|---|
| **Java 21** | Lenguaje principal de programación |
| **Spring Boot** | Desarrollo y configuración de la aplicación |
| **Spring Web MVC** | Gestión de controladores y navegación |
| **Spring Data JPA** | Persistencia y acceso a datos |
| **Hibernate** | Mapeo objeto-relacional |
| **PostgreSQL** | Base de datos principal |
| **H2** | Base de datos temporal para demostración |
| **Thymeleaf** | Generación de vistas dinámicas |
| **Spring Security** | Dependencia relacionada con seguridad |
| **Jakarta Validation** | Validación de información |
| **Lombok** | Simplificación de código |
| **HTML** | Estructura de las interfaces |
| **CSS** | Diseño y presentación visual |
| **Maven** | Gestión de dependencias |
| **Git** | Control de versiones |
| **GitHub** | Publicación y almacenamiento del proyecto |

---

## 🧩 Arquitectura del sistema

El proyecto se encuentra organizado mediante una arquitectura por capas.

### Vista

Las interfaces que utiliza el usuario están desarrolladas principalmente con:

- Thymeleaf.
- HTML.
- CSS.

### Controller

Los controladores reciben las solicitudes realizadas desde las interfaces y gestionan la navegación entre las diferentes funcionalidades.

### Service

Los servicios contienen la lógica asociada con las operaciones principales del sistema.

### Repository

Los repositorios permiten realizar operaciones de consulta, almacenamiento, actualización y eliminación de información mediante Spring Data JPA.

### Entity

Las entidades representan la información almacenada en la base de datos y las relaciones existentes entre los diferentes elementos del sistema.

### Base de datos

PostgreSQL es utilizado como sistema principal de persistencia de información.

Para pruebas se cuenta además con una configuración alternativa utilizando H2.

---

## 📂 Estructura general del proyecto

La aplicación se encuentra organizada principalmente en las siguientes carpetas:

- `config`: configuración de la aplicación.
- `controller`: controladores.
- `entity`: entidades del sistema.
- `repository`: acceso a datos.
- `service`: lógica de negocio.
- `templates`: vistas desarrolladas con Thymeleaf.
- `static`: archivos estáticos como CSS.
- `resources`: archivos de configuración.

La clase principal del proyecto es:

`DulceAlmibarApplication.java`

---

## 🗄️ Modelo de datos

El sistema trabaja con diferentes entidades relacionadas con los procesos del negocio.

### Usuario

Almacena la información relacionada con clientes y administradores.

### Producto

Representa los productos disponibles para la venta e incluye información relacionada con precios, descripción y stock.

### Insumo

Representa los elementos utilizados dentro del proceso de producción.

### Proveedor

Almacena la información relacionada con los proveedores de insumos.

### Pedido

Representa una compra realizada por un cliente.

### DetallePedido

Permite relacionar un pedido con los diferentes productos, cantidades y precios correspondientes.

### Pago

Almacena información relacionada con los pagos asociados a los pedidos.

### Factura

Representa la información correspondiente a la facturación de una compra.

---

## 🔗 Relaciones principales

### Pedido y detalle del pedido

Un pedido puede contener diferentes productos, por lo que se relaciona con uno o varios detalles de pedido.

Cada detalle registra información como producto, cantidad, precio unitario y subtotal.

### Pedido y pago

Los pagos se encuentran asociados a los pedidos realizados por los clientes.

### Pedido y factura

Las facturas se generan a partir de la información correspondiente a los pedidos.

---

## 🔄 Flujo general del cliente

El funcionamiento general para un cliente sigue el siguiente proceso:

1. El usuario accede a la aplicación.
2. Puede registrarse si todavía no posee una cuenta.
3. Inicia sesión utilizando correo electrónico y contraseña.
4. Accede al catálogo.
5. Consulta los productos disponibles.
6. Selecciona los productos que desea adquirir.
7. Realiza un pedido.
8. Registra el pago correspondiente.
9. Consulta sus pedidos.
10. Consulta la información relacionada con sus facturas.

---

## ⚙️ Flujo administrativo

El administrador puede ingresar al panel administrativo y acceder a diferentes módulos.

Desde allí puede:

1. Gestionar productos.
2. Administrar el inventario.
3. Gestionar insumos.
4. Administrar proveedores.
5. Consultar pedidos.
6. Gestionar el estado de los pedidos.
7. Consultar información relacionada con las facturas.

---

## 🌐 Rutas principales

### Autenticación

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/` | Página principal |
| GET | `/login` | Inicio de sesión |
| POST | `/login` | Procesamiento del inicio de sesión |
| GET | `/registro` | Formulario de registro |
| POST | `/registro` | Registro de cliente |
| GET | `/logout` | Cierre de sesión |

### Cliente

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/cliente/inicio` | Página principal del cliente |
| GET | `/cliente/catalogo` | Catálogo de productos |
| GET | `/cliente/pedido` | Formulario de pedido |
| POST | `/cliente/pedido/guardar` | Registro del pedido |
| GET | `/cliente/mis-pedidos` | Consulta de pedidos |
| GET | `/cliente/pago/{pedidoId}` | Formulario de pago |
| POST | `/cliente/pago/guardar` | Registro del pago |
| GET | `/cliente/mis-facturas` | Consulta de facturas |

### Administración

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/admin/dashboard` | Panel administrativo |
| GET | `/admin/productos` | Gestión de productos |
| POST | `/admin/productos/guardar` | Registro de productos |
| GET | `/admin/insumos` | Gestión de insumos |
| POST | `/admin/insumos/guardar` | Registro de insumos |
| GET | `/admin/proveedores` | Gestión de proveedores |
| POST | `/admin/proveedores/guardar` | Registro de proveedores |
| GET | `/admin/pedidos` | Consulta de pedidos |
| GET | `/admin/facturas` | Consulta de facturas |

---

## 💾 Configuración de PostgreSQL

La configuración principal del proyecto se encuentra en:

`src/main/resources/application.properties`

Se recomienda utilizar variables de entorno para evitar publicar credenciales directamente en GitHub.

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

## 🐘 Creación de la base de datos

Crear una base de datos en PostgreSQL:

```sql
CREATE DATABASE dulce_almibar;
```

Después se deben definir los datos necesarios para realizar la conexión.

Ejemplo:

```text
DB_URL=jdbc:postgresql://localhost:5432/dulce_almibar
DB_USER=postgres
DB_PASSWORD=TU_CONTRASEÑA
```

> ⚠️ No se deben publicar contraseñas reales dentro de un repositorio público.

---

## 📋 Requisitos

Para ejecutar la aplicación con PostgreSQL se recomienda contar con:

- Git.
- Java JDK 21.
- PostgreSQL.
- Maven o Maven Wrapper.
- Navegador web.

También puede utilizarse un entorno de desarrollo como:

- IntelliJ IDEA.
- Visual Studio Code.
- Eclipse.

El uso de un IDE no es obligatorio para ejecutar la aplicación.

---

## 📥 Clonar el proyecto

```bash
git clone https://github.com/Carencitha/dulce-almibar-web.git
```

Ingresar a la carpeta:

```bash
cd dulce-almibar-web
```

---

## ▶️ Ejecutar con PostgreSQL

### Windows

Utilizando Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Si Maven está instalado:

```powershell
mvn spring-boot:run
```

### Linux o macOS

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

También puede utilizarse:

```bash
mvn spring-boot:run
```

Cuando la aplicación esté funcionando, acceder a:

`http://localhost:8081`

---

## 🧪 Modo demo con H2

El proyecto cuenta con una configuración alternativa utilizando una base de datos **H2 en memoria**.

Este modo permite ejecutar la aplicación sin necesidad de instalar PostgreSQL.

La configuración se encuentra en:

`src/main/resources/application-demo.properties`

Para iniciar el perfil de demostración:

```bash
SPRING_PROFILES_ACTIVE=demo mvn spring-boot:run
```

---

## ⚠️ Funcionamiento de H2

H2 se utiliza únicamente como alternativa para pruebas y demostraciones.

Debido a que trabaja en memoria:

- La base de datos se crea cuando se inicia la aplicación.
- Los datos almacenados originalmente en PostgreSQL no aparecen automáticamente.
- Los datos de prueba pueden perderse cuando la aplicación se detiene.
- No se recomienda utilizar esta configuración como almacenamiento permanente.

---

## ☁️ Ejecución con GitHub Codespaces

El proyecto también puede ejecutarse directamente desde el navegador utilizando GitHub Codespaces.

### Crear el Codespace

Desde el repositorio:

**Code → Codespaces → Create codespace on main**

### Verificar Java

```bash
java -version
```

```bash
javac -version
```

El proyecto requiere **Java 21**.

### Ejecutar el proyecto

```bash
SPRING_PROFILES_ACTIVE=demo mvn spring-boot:run
```

Cuando la aplicación se encuentre activa, GitHub Codespaces detectará el puerto `8081`.

Desde la sección **Ports / Puertos** se puede abrir la aplicación directamente en el navegador.

---

## 🔐 Consideraciones de seguridad

Debido a que se trata de un proyecto académico, existen diferentes aspectos de seguridad que pueden fortalecerse antes de utilizar la aplicación en un entorno productivo.

Entre las posibles mejoras se encuentran:

- Implementar BCrypt para proteger las contraseñas.
- Fortalecer el control de acceso según los roles.
- Mejorar la configuración de Spring Security.
- Implementar recuperación segura de contraseña.
- Utilizar variables de entorno para información sensible.
- Agregar validaciones adicionales del lado del servidor.
- Fortalecer la protección CSRF.

---

## 📈 Mejoras futuras

El proyecto puede continuar evolucionando mediante la implementación de:

- Dashboard con estadísticas de ventas.
- Reportes de productos más vendidos.
- Alertas de bajo inventario.
- Historial de movimientos de inventario.
- Gestión más detallada del proceso de producción.
- Notificaciones por correo electrónico.
- Recuperación de contraseña.
- Mejoras en roles y permisos.
- Integración con pasarelas de pago.
- Generación de facturas en PDF.
- Exportación de reportes a Excel.
- Pruebas automatizadas.
- Diseño adaptable a dispositivos móviles.
- Despliegue en la nube.
- Desarrollo de una API REST.

---

## 🎓 Competencias aplicadas

El desarrollo de este proyecto permitió aplicar y fortalecer conocimientos relacionados con:

- Java.
- Spring Boot.
- Desarrollo de software.
- Desarrollo backend.
- Desarrollo web.
- PostgreSQL.
- SQL.
- Spring Data JPA.
- Hibernate.
- HTML.
- CSS.
- Thymeleaf.
- Maven.
- Modelado de bases de datos.
- Arquitectura por capas.
- Git.
- GitHub.

---

## 👩‍💻 Mi participación

Este proyecto fue desarrollado **de manera individual**.

Durante su desarrollo estuve a cargo de:

- Análisis de las funcionalidades necesarias.
- Diseño de la estructura general del sistema.
- Desarrollo del backend.
- Creación de entidades.
- Creación de repositorios.
- Implementación de servicios.
- Desarrollo de controladores.
- Modelado de la base de datos.
- Integración con PostgreSQL.
- Desarrollo de interfaces web.
- Gestión de productos.
- Gestión de inventario.
- Gestión de insumos.
- Gestión de proveedores.
- Gestión de pedidos.
- Registro de pagos.
- Facturación.
- Pruebas y ajustes funcionales.

---

## 📚 Aprendizajes obtenidos

El desarrollo de este proyecto me permitió comprender de manera práctica cómo se relacionan los diferentes componentes de una aplicación web.

También me permitió fortalecer conocimientos relacionados con:

- Organización de proyectos de software.
- Desarrollo backend.
- Integración entre interfaces y lógica de negocio.
- Manejo de bases de datos relacionales.
- Arquitectura por capas.
- Persistencia de información.
- Resolución de errores durante el desarrollo.
- Construcción de funcionalidades completas.
- Control de versiones.
- Uso de GitHub para publicación de proyectos.

---

## 📌 Estado del proyecto

🟡 **Proyecto académico funcional en proceso de mejora.**

La versión principal utiliza PostgreSQL como base de datos.

Adicionalmente, el proyecto cuenta con un perfil de demostración utilizando H2 para facilitar su ejecución y realización de pruebas.

---

## 👩‍🎓 Autora

**Caren Garcia**

Estudiante de Ingeniería de Sistemas  
Fundación Universitaria Juan de Castellanos

### Áreas de interés profesional

- 💻 Desarrollo de software
- 📊 Análisis de datos
- 🔐 Ciberseguridad
- 📋 Liderazgo y gestión de proyectos tecnológicos

---

## 📄 Uso del proyecto

Este repositorio se publica con fines **académicos y de portafolio profesional**.

El proyecto representa parte de los conocimientos y competencias adquiridas durante mi formación en Ingeniería de Sistemas.
