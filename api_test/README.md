# API Test - Karate

Proyecto base con Karate `2.0.6` sobre Gradle.

## Estructura de pruebas

- `src/test/java/UsersCrudRunnerTest.java`: runner JUnit 5 para ejecutar los features de users.
- `src/test/resources/karate-config.js`: configuracion global (`baseUrl`, `env`).
- `src/test/resources/features/users/`: estructura CRUD.
  - `create/create-user.feature`
  - `read/get-user.feature`
  - `update/update-user.feature`
  - `delete/delete-user.feature`
  - `data/users/john.json`

## Ejecutar pruebas

```bash
./gradlew test
```

## Ejecutar solo users (opcional)

```bash
./gradlew test --tests UsersCrudRunnerTest
```

