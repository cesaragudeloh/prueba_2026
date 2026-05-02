Feature: Actualizar usuario en Petstore

Background:
  * url baseUrl
  * configure retry = { count: 5, interval: 1000 }
  * def UUID = Java.type('java.util.UUID')
  * def System = Java.type('java.lang.System')

Scenario: crear y actualizar el nombre y correo del usuario
  * def userId = System.currentTimeMillis()
  * def username = 'qa-update-' + UUID.randomUUID()
  * def user = read('classpath:features/users/data/users/user.json')
  * set user.id = userId
  * set user.username = username
  * set user.firstName = 'John'
  * set user.lastName = 'Doe'
  * set user.email = username + '@example.com'
  * set user.password = 'P@ssw0rd123'
  * set user.phone = '5551234567'

  Given path 'user'
  And request user
  When method post
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }

  * def updatedUser = read('classpath:features/users/data/users/user.json')
  * set updatedUser.id = userId
  * set updatedUser.username = username
  * set updatedUser.firstName = 'Jane'
  * set updatedUser.lastName = 'Smith'
  * set updatedUser.email = username + '.updated@example.com'
  * set updatedUser.password = 'P@ssw0rd123'
  * set updatedUser.phone = '5551234567'

  Given path 'user', username
  And request updatedUser
  When method put
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }

  Given path 'user', username
  And retry until responseStatus == 200
  When method get
  Then status 200
  And match response.id == userId
  And match response.username == username
  And match response.firstName == 'Jane'
  And match response.lastName == 'Smith'
  And match response.email == username + '.updated@example.com'

