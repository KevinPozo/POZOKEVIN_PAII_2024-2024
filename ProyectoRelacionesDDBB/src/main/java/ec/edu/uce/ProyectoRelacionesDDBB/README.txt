# Proyecto Relaciones DDBB en Spring Boot (SISTEMA DE SALUD)

Este proyecto utiliza Spring Boot para desarrollar
ejemplos prácticos con el propósito de entender y
aplicar relaciones como OneToOne, OneToMany, ManyToOne y
ManyToMany en aplicaciones Java utilizando JPA y MySQL.

## Dependencias

- Spring Boot
- Spring Data JPA
- MySQL Connector

## Estructura del Proyecto

El proyecto está organizado en dos capas principales:
**Model** y **Controller**.

### Model

En la capa **Model** se encuentran las siguientes carpetas:

- **Interfaces**: Define interfaces que abstraen los
métodos relacionales al CRUD o DAO (Data Access Object)
utilizando el patrón de diseño DAO.

- **Repository**: Repositorios que implementan interfaces JPA
para acceder a métodos CRUD, aplicando inversión de control y
el principio de responsabilidad única.

- **Service**: Accede a los métodos definidos en las
interfaces DAO para interactuar con la base de datos.
Esta capa encapsula la lógica de negocio y orquesta
las operaciones CRUD.

### Entidades

Las entidades se encuentran en la carpeta **Model** y
están mapeadas con las anotaciones de JPA para definir
las relaciones del modelo relacional.
Las relaciones incluyen OneToOne, OneToMany, ManyToOne y
ManyToMany, modeladas en la base de datos MySQL denominada
`persistencedb`.

### Ejemplos Implementados

Se han implementado ejemplos para cada tipo de relación:

- **OneToOne**: Relación donde una entidad se relaciona con
exactamente una entidad en otra tabla.
- **OneToMany**: Relación donde una entidad se relaciona con
múltiples entidades en otra tabla.
- **ManyToOne**: Relación donde múltiples entidades se
relacionan con una sola entidad en otra tabla.
- **ManyToMany**: Relación compleja donde múltiples entidades se
relacionan con múltiples entidades en otra tabla,
utilizando una tabla intermedia.

## Funcionamiento

El proyecto se ejecuta como una aplicación
Spring Boot Application que corre en consola,
permitiendo interactuar con las operaciones CRUD
mediante menús interactivos.

### Ejecución

Para ejecutar el proyecto, asegúrese de tener
configurada una base de datos
MySQL llamada `persistencedb` y configurar
correctamente las credenciales en `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/persistencedb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

Luego, puede ejecutar la aplicación desde su IDE o con
el siguiente comando Maven:
- mvn spring-boot