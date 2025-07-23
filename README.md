# Spring JPA Relations & Spring Security Project

Este proyecto es una aplicación Spring Boot diseñada para explorar y practicar los conceptos de mapeo de relaciones con Spring Data JPA y la implementación de seguridad básica con Spring Security.

## 🚀 Tecnologías Utilizadas

* **Java 17 / 23.0.1**
* **Spring Boot 3.5.3 (Maven Project)**
* **Spring Data JPA:** Para la persistencia de datos y mapeo objeto-relacional.
* **Hibernate 6.x:** Implementación de JPA.
* **Spring Security:** Para autenticación y autorización.
* **MySQL Database:** Sistema de gestión de bases de datos relacionales.
* **MySQL Connector/J 9.2.0:** Driver JDBC para MySQL.
* **Lombok:** Para reducir el boilerplate code en las entidades.
* **Spring Boot DevTools:** Para un ciclo de desarrollo más rápido.
* **Maven:** Como herramienta de construcción y gestión de dependencias.

## 💡 Conceptos Clave Aprendidos/Reforzados

Durante el desarrollo de este proyecto, se han abordado y resuelto diversos desafíos relacionados con:

1.  **Mapeo de Entidades JPA:**
    * Uso de `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)` para definir tablas y claves primarias.
    * Gestión de nombres de columnas personalizados con `@Column(name = "...")`.
    * **Solución a "Entity has no identifier"**: Asegurar que toda entidad `@Entity` tenga una clave primaria definida.

2.  **Relaciones JPA:**
    * **Relación Uno a Uno (`@OneToOne`):** Mapeo entre `Club` y `Coach`.
        * Uso de `@JoinColumn` para especificar la columna de clave foránea en el lado propietario (ej., `fk_coach` en `Club`).
        * Importancia de `unique = true` en `@JoinColumn` para relaciones 1:1.
    * **Relación Uno a Muchos / Muchos a Uno (`@OneToMany` / `@ManyToOne`):** Mapeo entre `Club` y `Player`.
        * Configuración del lado "muchos" (`@ManyToOne` en `Player` con `@JoinColumn`).
        * Configuración del lado "uno" (`@OneToMany` en `Club` con `mappedBy`).
        * **Solución a "mappedBy property references wrong entity type"**: Asegurar que el tipo de la propiedad en el lado `@ManyToOne` (ej., `private Club club;` en `Player`) coincida con la entidad de la que se mapea (`Club`).
        * Uso de `cascade = CascadeType.ALL` y `orphanRemoval = true` para gestión de ciclo de vida de entidades relacionadas.
    * **Relación Muchos a Muchos (`@ManyToMany` a través de una tabla de unión):** Mapeo implícito entre `Club` y `FootballCompetition` a través de la tabla `club_competitions`.
        * Comprensión de las tablas de unión generadas automáticamente por Hibernate.

3.  **Configuración de Base de Datos con `application.properties`:**
    * Conexión a MySQL (`spring.datasource.url`, `username`, `password`).
    * **Gestión del DDL de Hibernate (`spring.jpa.hibernate.ddl-auto`):**
        * Uso de `update` para que Hibernate gestione los cambios de esquema en desarrollo.
        * **Solución a "Unrecognized 'hibernate.hbm2ddl.auto' setting"**: Errores comunes al incluir comentarios en la misma línea del valor de la propiedad.
    * Visualización de consultas SQL (`spring.jpa.show-sql=true`, `format_sql=true`).

4.  **Debugging de Errores Comunes de JPA/Hibernate:**
    * Identificación y resolución de errores de **dependencias faltantes** (`spring-boot-starter-data-jpa`).
    * **Manejo de inconsistencias en el esquema de la base de datos:** Resolución de problemas al eliminar columnas o claves foráneas (`Error Code: 1025: Cannot drop column...needed in a foreign key constraint`, `Error Code: 1091: Can't DROP FOREIGN KEY...check that key exists`, `ERROR 1553: Cannot drop index...needed in a foreign key constraint`).
        * Proceso manual de eliminación de claves foráneas y sus índices asociados en el orden correcto en MySQL Workbench.
        * Comprensión de la diferencia entre columnas, índices y claves foráneas.

5.  **Spring Security Básico:**
    * Auto-configuración de Spring Security con una contraseña generada automáticamente en desarrollo.
    * Nota sobre la necesidad de una configuración de seguridad más robusta para producción.

## ⚙️ Cómo Ejecutar el Proyecto

### 1. Requisitos Previos

* Java Development Kit (JDK) 17 o superior.
* Apache Maven.
* MySQL Server (versión 8.x o compatible).
* Un IDE como IntelliJ IDEA (recomendado).

### 2. Configuración de la Base de Datos MySQL

Asegúrate de que tu servidor MySQL esté en ejecución. El proyecto utilizará la base de datos `springjpa`. Si no existe, Spring Boot la creará automáticamente.

Configura las credenciales de tu base de datos en `src/main/resources/application.properties`:

```properties
spring.application.name=SpringJpaRelation
spring.datasource.url=jdbc:mysql://localhost:3306/springjpa?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root1234
spring.jpa.hibernate.ddl-auto=update # Permite a Hibernate gestionar el esquema de la base de datos.
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
