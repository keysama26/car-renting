# CARRENTING 🚗

## Sistema de alquiler de vehículos

CarRenting es una aplicación web desarrollada con Java y Spring Boot que permite consultar vehículos disponibles y registrar reservas de alquiler.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- HTML5
- CSS3
- JavaScript
- Base de datos H2

## Funcionalidades

- Visualización del catálogo de vehículos.
- Consulta de precios por día.
- Selección de vehículos.
- Registro de reservas.
- Cálculo automático del precio total.
- Almacenamiento de información de reservas.

## Arquitectura

El proyecto utiliza una arquitectura basada en puertos y adaptadores (arquitectura hexagonal), organizada en:

- **Domain:** modelos y reglas del negocio.
- **Application:** servicios y casos de uso.
- **Infrastructure:** repositorios, adaptadores y controladores.

## Ejecución del proyecto

1. Tener instalado Java 21.
2. Abrir una terminal en la carpeta del proyecto.
3. Ejecutar:

```powershell
.\mvnw.cmd spring-boot:run
```

4. Abrir en el navegador:

```text
http://localhost:8080
```

## Autor

Proyecto académico desarrollado como práctica de programación con Java y Spring Boot.
