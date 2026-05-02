# API Test - Karate - Petstore CRUD Flow

Proyecto de pruebas API con Karate `2.0.6` y Gradle para el servicio público de Petstore.

## Estructura principal

- `src/test/java/users/UsersRunner.java`: runner JUnit 5 que ejecuta el flujo CRUD completo.
- `src/test/resources/karate-config.js`: configuración global (baseUrl: Petstore).
- `src/test/resources/features/users/crud-flow.feature`: **flujo completo CRUD en un solo scenario** (5 pasos en orden estricto).
- `src/test/resources/features/users/create/create-user.feature`: escenario individual de creación.
- `src/test/resources/features/users/read/get-user.feature`: escenario individual de lectura.
- `src/test/resources/features/users/update/update-user.feature`: escenario individual de actualización.
- `src/test/resources/features/users/delete/delete-user.feature`: escenario individual de eliminación.
- `src/test/resources/features/users/data/users/user.json`: plantilla base de usuario (datos sintéticos).

## Flujo CRUD principal

El archivo `crud-flow.feature` ejecuta los **5 pasos en orden estricto** con el mismo usuario:

1. **Crear un usuario** → POST /user (status 200)
2. **Buscar el usuario creado** → GET /user/{username} (validar datos originales)
3. **Actualizar** nombre y correo → PUT /user/{username} (status 200)
4. **Buscar el usuario actualizado** → GET /user/{username} (validar cambios)
5. **Eliminar el usuario** → DELETE /user/{username} (status 200)
6. **Validar eliminación** → GET /user/{username} (status 404 - "User not found")

## Ejecutar pruebas

```bash
./gradlew test
```

## Ejecutar el flujo CRUD principal solamente

```bash
./gradlew clean test
```

## Reportes generados

- `build/karate-reports/index.html`
- `build/reports/tests/test/index.html`

## Notas de implementación

- Los pasos del flujo CRUD usan el **mismo usuario** desde creación hasta eliminación, garantizando orden estricto.
- Cada ejecución genera un username único (`qa-flow-{UUID}`) para evitar colisiones.
- La plantilla `user.json` contiene datos sintéticos y se sobrescribe en cada paso del flujo.
- El entorno apunta a `https://petstore.swagger.io/v2` (API pública, sin persistencia real).
- Los escenarios individuales (create, read, update, delete) se ejecutan internamente también, cada uno con su propio usuario único.
