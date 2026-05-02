Instrucciones paso a paso para ejecutar el proyecto Karate

1. Abrir una terminal en la raíz del proyecto:
   /Users/cesar/Documents/CesarDocs/prueba_2026/api_test

2. Ejecutar la suite completa de pruebas:
   ./gradlew test

3. Si se desea ejecutar únicamente el runner de usuarios:
   ./gradlew test --tests users.UsersRunner

4. Revisar los reportes generados en:
   - build/karate-reports/index.html
   - build/reports/tests/test/index.html

5. Validar los escenarios implementados:
   - crear usuario
   - buscar usuario creado
   - actualizar nombre y correo
   - buscar usuario actualizado
   - eliminar usuario
   - verificar que el usuario eliminado ya no exista

6. Si se necesita empaquetar la entrega, incluir este archivo junto con el proyecto completo en un .zip o .rar.

