# QA Automation Portfolio - API & E2E Testing

Repositorio que contiene dos proyectos de automatización desarrollados como solución a ejercicios de pruebas:

- **API Testing** con Karate
- **E2E Web Testing** con Serenity BDD (Screenplay)

---

## Autor

**César Agudelo**
QA Automation Engineer | SDET

---

## 📂 Estructura del repositorio
```
prueba_2026/
  ├── api_test/ → Proyecto de automatización API (Karate)
  └── e2e_test/ → Proyecto de automatización E2E Web (Serenity BDD)
```

## Enfoque de la solución

- Separación clara entre pruebas API y E2E
- Uso de datos dinámicos para evitar colisiones
- Validación de flujos completos (no solo endpoints aislados)
- Implementación de patrones de diseño (Screenplay)
- Generación de reportes automáticos

---

## Proyecto 1: API Testing (Karate)

### Descripción
Automatización de pruebas sobre la API pública de Petstore:

https://petstore.swagger.io/

Se implementa un flujo completo CRUD de usuario validando el comportamiento del sistema.

---

### Flujo cubierto

1. Crear usuario
2. Buscar usuario creado
3. Actualizar nombre y correo
4. Buscar usuario actualizado
5. Eliminar usuario
6. Verificar eliminación (404)

---

### Tecnologías

- Karate 2.0.6
- Java 21+
- Gradle 9

---

### Ejecución

```bash
cd api_test
./gradlew clean test
```

### Reportes

- `build/karate-reports/index.html`
- `build/reports/tests/test/index.html`

---

## Proyecto 2: E2E Testing (SauceDemo)

### Descripción

Este proyecto implementa una prueba automatizada End-to-End (E2E) del flujo de compra en la aplicación web:

https://www.saucedemo.com/

La automatización valida el comportamiento completo del usuario desde la autenticación hasta la confirmación final de la compra, asegurando la integridad del flujo y la correcta interacción entre los diferentes componentes de la aplicación.

El proyecto está desarrollado utilizando **Serenity BDD** con el patrón **Screenplay**, lo que permite una arquitectura altamente mantenible, reusable y alineada con buenas prácticas de automatización.

---

### Objetivo

Validar funcionalmente un flujo de compra real simulando el comportamiento de un usuario final, asegurando:

- Correcta autenticación
- Gestión de productos en el carrito
- Proceso de checkout
- Confirmación exitosa de la orden

---

### Flujo cubierto

El escenario automatizado incluye:

1. Autenticación en la plataforma
   - Usuario: `standard_user`
   - Password: `secret_sauce`

2. Navegación en el catálogo de productos

3. Agregar dos productos al carrito

4. Visualización del carrito de compras

5. Completar el formulario de checkout

6. Finalización de la compra

7. Validación del mensaje de confirmación:
   - **"THANK YOU FOR YOUR ORDER"**

---
### Tecnologías utilizadas

- Java 21+
- Gradle 9
- Serenity BDD 
- Cucumber (BDD)
- Screenplay Pattern


---

### Enfoque técnico

El proyecto sigue el patrón **Screenplay**, separando responsabilidades en:

- **Actors**: Representan usuarios del sistema
- **Tasks**: Acciones ejecutadas por el usuario
- **Page Objects (UI)**: Mapeo de elementos de la interfaz
- **Step Definitions**: Orquestación del flujo en lenguaje Gherkin

Esto permite:

- Alta reutilización de código
- Mejor mantenibilidad
- Mayor legibilidad de los escenarios

---

### Ejecución

Desde la carpeta del proyecto:

```bash
cd e2e_test
./gradlew clean test aggregate
```

### Reportes

Serenity genera un reporte HTML en: `target/site/serenity/index.html`

---

## Nota

Cada proyecto dentro de este repositorio incluye su propio archivo `README`, donde se detallan:

- Instrucciones de configuración
- Ejecución paso a paso
- Consideraciones técnicas específicas
