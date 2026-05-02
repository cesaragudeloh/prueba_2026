Feature: Buscar usuario creado en Petstore

Background:
  * url baseUrl
  * configure retry = { count: 15, interval: 1000 }
  * def UUID = Java.type('java.util.UUID')
  * def System = Java.type('java.lang.System')

Scenario: crear y buscar el usuario creado
  * def userId = System.currentTimeMillis()
  * def username = 'qa-read-' + UUID.randomUUID()
  * def user = read('classpath:features/users/data/users/user.json')
  * set user.id = userId
  * set user.username = username
  * set user.firstName = 'Leer'
  * set user.lastName = 'Usuario'
  * set user.email = username + '@example.com'
  * set user.password = 'P@ssw0rd123'
  * set user.phone = '5551234567'

  Given path 'user'
  And request user
  When method post
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }

  Given path 'user', username
  And retry until responseStatus == 200
  When method get
  Then status 200
  And match response.id == userId
  And match response.username == username
  And match response.firstName == 'Leer'
  And match response.lastName == 'Usuario'
  And match response.email == username + '@example.com'

