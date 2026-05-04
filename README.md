# Productos Service

![CI](https://github.com/yeremy0418/silva-post2-u9/actions/workflows/ci.yml/badge.svg)

## Descripción

Microservicio REST de gestión de productos desarrollado con **Spring Boot 3.4**, **Spring Data JPA** y **H2** (base de datos en memoria). Incluye una suite completa de pruebas unitarias y de integración, con reporte de cobertura generado automáticamente por **JaCoCo** en cada push mediante **GitHub Actions**.

## Estructura del Proyecto

```
productos-service/
├── .github/
│   └── workflows/
│       └── ci.yml                          # Pipeline de CI con GitHub Actions
├── src/
│   ├── main/java/com/universidad/productosservice/
│   │   ├── controller/
│   │   │   └── ProductoController.java     # Capa web REST
│   │   ├── domain/
│   │   │   └── Producto.java               # Entidad JPA
│   │   ├── repository/
│   │   │   └── ProductoRepository.java     # Repositorio Spring Data JPA
│   │   ├── service/
│   │   │   ├── ProductoService.java        # Interfaz del servicio
│   │   │   └── ProductoServiceImpl.java    # Implementación del servicio
│   │   └── ProductosServiceApplication.java
│   ├── main/resources/
│   │   └── application.properties
│   └── test/
│       ├── java/.../
│       │   ├── controller/
│       │   │   └── ProductoControllerTest.java   # @WebMvcTest
│       │   ├── repository/
│       │   │   └── ProductoRepositoryTest.java   # @DataJpaTest
│       │   └── service/
│       │       └── ProductoServiceImplTest.java  # Pruebas unitarias con Mockito
│       └── resources/
│           └── application-test.properties
└── pom.xml
```

## Endpoints REST

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| POST | `/api/productos` | Crear un nuevo producto |
| GET | `/api/productos/{id}` | Buscar producto por ID |
| PUT | `/api/productos/{id}/stock/{nuevoStock}` | Actualizar stock |
| DELETE | `/api/productos/{id}` | Eliminar producto |

## Ejecutar las pruebas

```bash
# Solo pruebas unitarias
mvn test

# Pruebas + reporte JaCoCo
mvn verify
```

El reporte de cobertura se genera en `target/site/jacoco/index.html`.

## Suite de Pruebas

El proyecto cuenta con **≥14 pruebas** distribuidas en tres clases:

- **`ProductoServiceImplTest`** — Pruebas unitarias con Mockito (10 tests)
- **`ProductoRepositoryTest`** — Pruebas de integración con `@DataJpaTest` + H2 (4 tests)
- **`ProductoControllerTest`** — Pruebas de integración con `@WebMvcTest` + MockMvc (3 tests)

## Cobertura JaCoCo

La cobertura de `ProductoServiceImpl` supera el **70% en líneas**.


>
> `![Captura JaCoCo](docs/jacoco-report.png)`

## Pipeline de CI

El archivo `.github/workflows/ci.yml` ejecuta automáticamente en cada push o pull request a `main`:

1. Checkout del repositorio
2. Configuración de JDK 21 (Temurin)
3. `mvn verify` — compila y ejecuta todas las pruebas
4. Sube el reporte JaCoCo como artefacto (disponible 7 días)

## Prerrequisitos

- JDK 21
- Maven 3.9+
