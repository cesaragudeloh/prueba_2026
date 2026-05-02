# API Test - Karate (Petstore)

Proyecto de pruebas API con Karate `2.0.6` y Gradle sobre el endpoint público `https://petstore.swagger.io/v2`.

## Objetivo

Validar un flujo CRUD de usuario en orden estricto:

1. Crear usuario
2. Buscar usuario creado
3. Actualizar nombre y correo
4. Buscar usuario actualizado
5. Eliminar usuario
6. Verificar eliminación (404)

## Estructura del proyecto

- `src/test/java/users/UsersRunner.java`: runner JUnit 5 para ejecutar la suite Karate de `features/users`.
- `src/test/resources/karate-config.js`: configuración global de entorno (`baseUrl`) y logging con salida formateada.
- `src/test/resources/features/users/crud-flow.feature`: flujo E2E principal en un solo escenario, con pasos en orden estricto.
- `src/test/resources/features/users/create/create-user.feature`: escenario individual de creación.
- `src/test/resources/features/users/read/get-user.feature`: escenario individual de lectura.
- `src/test/resources/features/users/update/update-user.feature`: escenario individual de actualización.
- `src/test/resources/features/users/delete/delete-user.feature`: escenario individual de eliminación.
- `src/test/resources/features/users/data/users/user.json`: plantilla base reutilizable para requests.

## Datos y trazabilidad

- Se usan nombres de prueba realistas (ej. `John Doe`, `Jane Smith`) en lugar de etiquetas genéricas.
- El `username` se genera corto para mejorar legibilidad en consola: `qa` + `(System.currentTimeMillis() % 100000)`.
- Los emails derivan del username (`<username>@example.com` y `<username>-updated@example.com`).
- En `crud-flow.feature` se imprime request/response por operación con `karate.pretty(...)`.

## Ejecución

Desde la raíz del proyecto:

```bash
./gradlew test
```

Ejecución limpia:

```bash
./gradlew clean test
```

## Reportes

- `build/karate-reports/index.html`
- `build/reports/tests/test/index.html`

## Notas de implementación

- La suite corre en secuencial (`parallel(1)`) para mayor estabilidad contra un servicio público.
- `crud-flow.feature` garantiza orden estricto con el mismo usuario durante todo el flujo.
- Además del flujo principal, se conservan features individuales para cobertura por operación.
- Los pasos del flujo CRUD usan el **mismo usuario** desde creación hasta eliminación, garantizando orden estricto.
- Cada ejecución genera un username único y corto basado en timestamp para evitar colisiones.
- La plantilla `user.json` contiene datos sintéticos y se sobrescribe en cada paso del flujo.
- El entorno apunta a `https://petstore.swagger.io/v2` (API pública).
- Los escenarios individuales (create, read, update, delete) se ejecutan internamente también, cada uno con su propio usuario único.
