Feature: Search prices api

  Background:
    Given url baseUrl
    Given path '/api/search/prices'

  Scenario: Search prices 1
    And param dateToTest = '2020-06-14-10.00.00'
    And param idProduct = 35455
    And param brandId = 1
    When  method get
    Then  status 200
    And match response == { data: { productId: 35455, brandId: 1, priceList: 1, dateStart: '2020-06-14-00.00.00', dateEnd: '2020-12-31-23.59.59',price: 35.5}}

  Scenario: Search prices 2
    And param dateToTest = '2020-06-14-16.00.00'
    And param idProduct = 35455
    And param brandId = 1
    When  method get
    Then  status 200
    And match response == { data: { productId: 35455, brandId: 1, priceList: 2, dateStart: '2020-06-14-15.00.00', dateEnd: '2020-06-14-18.30.00',price: 25.45}}

  Scenario: Search prices 3
    And param dateToTest = '2020-06-14-21.00.00'
    And param idProduct = 35455
    And param brandId = 1
    When  method get
    Then  status 200
    And match response == { data: { productId: 35455, brandId: 1, priceList: 1, dateStart: '2020-06-14-00.00.00', dateEnd: '2020-12-31-23.59.59',price: 35.5}}

  Scenario: Search prices 4
    And param dateToTest = '2020-06-15-10.00.00'
    And param idProduct = 35455
    And param brandId = 1
    When  method get
    Then  status 200
    And match response == { data: { productId: 35455, brandId: 1, priceList: 3, dateStart: '2020-06-15-00.00.00', dateEnd: '2020-06-15-11.00.00',price: 30.5}}

  Scenario: Search prices 5
    And param dateToTest = '2020-06-16-21.00.00'
    And param idProduct = 35455
    And param brandId = 1
    When  method get
    Then  status 200
    And match response == { data: { productId: 35455, brandId: 1, priceList: 4, dateStart: '2020-06-15-16.00.00', dateEnd: '2020-12-31-23.59.59',price: 38.95}}

#  Scenario: search prices1
#    And path '/api/search/prices'
#    And param dateToTest = '2020-06-16-21.00.00'
#    And param idProduct = 35455
#    And param brandId = 1
#    When method get
#    Then  status 200




