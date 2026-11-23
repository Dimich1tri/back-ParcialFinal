# Bodegas y Productos — Backend (`bodegas-backend`)

Backend REST desarrollado en **Java 17** con **Spring Boot 3.3.2**, **Spring Data JPA** y base de datos en memoria **H2** para la gestión de bodegas y consulta de sus productos asociados (relación `1:N`).

## Arquitectura por capas

- `model/`: Entidades JPA `Bodega` (`1 -> N`) y `Producto` (`@ManyToOne` obligatorio hacia `Bodega`).
- `repository/`: `BodegaRepository` y `ProductoRepository`.
- `services/`: `BodegaService` (registro y consulta de bodegas con sus productos).
- `controllers/`: `BodegaController` (`POST /bodegas` y `GET /bodegas`) y `GlobalExceptionHandler`.
- `dto/`: `BodegaDTO`, `BodegaRespuestaDTO` y `ProductoRespuestaDTO` (respuesta JSON anidada sin referencias circulares).
- `config/`: `DataInitializer` (`CommandLineRunner` que persiste las bodegas y productos iniciales usando ambos repositorios).

## Requisitos

- **Java 17** o superior.
- Maven (incluido mediante el wrapper `./mvnw`).

## Ejecución

Desde la carpeta `bodegas-backend/`:

```bash
./mvnw spring-boot:run
```

El servidor queda disponible en `http://localhost:8080`.

### Endpoints disponibles

| Método | Ruta | Acción |
| --- | --- | --- |
| `POST` | `/bodegas` | Registrar una nueva bodega (`{"nombre": "...", "ubicacion": "..."}`) |
| `GET` | `/bodegas` | Consultar todas las bodegas incluyendo su lista de productos asociados |
