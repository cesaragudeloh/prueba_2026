# Automatización E2E - Flujo de Compra SauceDemo

## Descripción
Este proyecto implementa una prueba automatizada End-to-End (E2E) para un flujo de compra en https://www.saucedemo.com/ utilizando Serenity BDD con el patrón Screenplay.

La prueba valida el flujo completo del usuario desde el login hasta la confirmación de la compra.

---

## Escenario Cubierto

- Autenticación con:
    - Usuario: `standard_user`
    - Password: `secret_sauce`
- Agregar dos productos al carrito
- Visualizar el carrito
- Completar el formulario de compra
- Finalizar la compra
- Validar el mensaje de confirmación:
    - **"THANK YOU FOR YOUR ORDER"**

---

## Tecnologías Utilizadas

- Java
- Serenity BDD
- Cucumber (BDD)
- Patrón Screenplay
- Gradle
- Selenium WebDriver

---

## Cómo Ejecutar las Pruebas

### 1. Clonar el repositorio
```
git clone <REPO_URL>
cd <PROJECT_NAME>
```
### 2. Ejecutar pruebas y generar reporte
```
./gradlew clean test aggregate
```

### 3. Abrir el reporte de Serenity
```
target/site/serenity/index.html
```

## Estructura del Proyecto
```
src
└── test
├── java
│    ├── runners
│    ├── stepdefinitions
│    ├── tasks
│    ├── interactions
│    └── questions
└── resources
└── features
```

## Reportes

Serenity genera un reporte HTML detallado que incluye:

- Resultados de ejecución
- Paso a paso de la prueba
- Evidencias (screenshots)
- Estado de cada escenario

### Ubicación:
```
target/site/serenity/index.html
```

## Notas Importantes

- Debe tener Google Chrome instalado.
- WebDriver es gestionado automáticamente por Serenity.
- Ejecutar el proyecto con Java 21 o superior.
- Asegúrese de tener conexión a internet al ejecutar la prueba.