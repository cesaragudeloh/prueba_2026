Feature: Flujo CRUD completo de usuario en Petstore

Background:
  * url baseUrl
  * configure retry = { count: 15, interval: 1000 }
  * def UUID = Java.type('java.util.UUID')
  * def System = Java.type('java.lang.System')

Scenario: Flujo completo: Crear, Buscar, Actualizar, Buscar Actualizado, Eliminar
  # Preparar datos iniciales
  * def userId = System.currentTimeMillis()
  * def username = 'qa-flow-' + UUID.randomUUID()
  * def user = read('classpath:features/users/data/users/user.json')
  * set user.id = userId
  * set user.username = username
  * set user.firstName = 'Original'
  * set user.lastName = 'User'
  * set user.email = username + '@example.com'
  * set user.password = 'P@ssw0rd123'
  * set user.phone = '5551234567'

  # ========== PASO 1: Crear un usuario ==========
  Given path 'user'
  And request user
  When method post
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }

  # ========== PASO 2: Buscar el usuario creado ==========
  Given path 'user', username
  And retry until responseStatus == 200
  When method get
  Then status 200
  And match response.id == userId
  And match response.username == username
  And match response.firstName == 'Original'
  And match response.lastName == 'User'
  And match response.email == username + '@example.com'

  # ========== PASO 3: Actualizar nombre y correo del usuario ==========
  * def updatedUser = read('classpath:features/users/data/users/user.json')
  * set updatedUser.id = userId
  * set updatedUser.username = username
  * set updatedUser.firstName = 'Modified'
  * set updatedUser.lastName = 'Updated'
  * set updatedUser.email = username + '-updated@example.com'
  * set updatedUser.password = 'P@ssw0rd123'
  * set updatedUser.phone = '5551234567'

  Given path 'user', username
  And request updatedUser
  When method put
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }

  # ========== PASO 4: Buscar el usuario actualizado ==========
  Given path 'user', username
  And retry until responseStatus == 200
  When method get
  Then status 200
  And match response.id == userId
  And match response.username == username
  And match response.firstName == 'Modified'
  And match response.lastName == 'Updated'
  And match response.email == username + '-updated@example.com'

  # ========== PASO 5: Eliminar el usuario ==========
  Given path 'user', username
  And retry until responseStatus == 200
  When method delete
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }
  And match response.message == username

  # Validación final: verificar que el usuario fue eliminado
  Given path 'user', username
  And retry until responseStatus == 404
  When method get
  Then status 404
  And match response == { code: 1, type: 'error', message: 'User not found' }

