Feature: Eliminar usuario en Petstore

Background:
  * url baseUrl
  * configure retry = { count: 5, interval: 1000 }
  * def UUID = Java.type('java.util.UUID')
  * def System = Java.type('java.lang.System')

Scenario: crear y eliminar un usuario, validando que ya no exista
  * def userId = System.currentTimeMillis()
  * def username = 'qa' + (System.currentTimeMillis() % 100000)
  * def user = read('classpath:features/users/data/users/user.json')
  * set user.id = userId
  * set user.username = username
  * set user.firstName = 'Alex'
  * set user.lastName = 'Johnson'
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
  When method delete
  Then status 200
  And match response == { code: 200, type: 'unknown', message: '#string' }
  And match response.message == username

  Given path 'user', username
  And retry until responseStatus == 404
  When method get
  Then status 404
  And match response == { code: 1, type: 'error', message: 'User not found' }

