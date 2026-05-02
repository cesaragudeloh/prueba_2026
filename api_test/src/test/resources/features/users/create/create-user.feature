Feature: Crear usuario en Petstore

Background:
  * url baseUrl
  * def UUID = Java.type('java.util.UUID')
  * def System = Java.type('java.lang.System')

Scenario: crear un usuario nuevo
  * def userId = System.currentTimeMillis()
  * def username = 'qa-create-' + UUID.randomUUID()
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

