Feature: Tests for ATMs API
  Description : The purpose of this test is to cover all the scenarios for the atms endpoint.

  Scenario Outline: User is able to call the atms endpoint with valid identification and get correct response.
    Given User has ATMS endpoint "atms"
    And User has a QueryParameters "identification" with value "<queryParamValues>"
    When User calls api with "Get" Method
    Then User should get response status code as 200
    And User should get the valid atms response for identification as per file "<queryParamValues>"

    Examples:
      | queryParamValues |
      | LFFDHC11         |
      | LB9AAC11         |


  Scenario Outline: When atms endpoint is called with invalid identification then we get empty data in response.
    Given User has ATMS endpoint "atms"
    And User has a QueryParameters "identification" with value "<queryParamValues>"
    When User calls api with "Get" Method
    Then User should get response status code as 200
    And User should get the empty response

    Examples:
      | queryParamValues |
      | LFFdHC11         |
      | LB9A AC11        |
      |                  |
      | a's              |
      | LFFDHC111        |
      | LFFDHC1          |
      | 1234             |


  Scenario Outline: When atms endpoint is called with HTTP methods apart from GET we should get 405 error.
    Given User has ATMS endpoint "atms"
    And User has a QueryParameters "identification" with value "LFFDHC11"
    When User calls api with "<HttpMethod>" Method
    Then User should get response status code as 405
    And User should get the error as "Method Not Allowed"

    Examples:
      | HttpMethod |
      | POST       |
      | Put        |
      | Delete     |

  Scenario: When atms endpoint is called without any Parameters it should give 400 error
    Given User has ATMS endpoint "atms"
    When User calls api with "GET" Method
    Then User should get response status code as 400
    And User should get the error as "Bad Request"