Feature: This feature is to test get requests

  Scenario Outline: This test will get details of page 2
    Given An authorized user
    When want details of page "<page>"
    Examples:
      | page |
      | 2    |

  @Get_Test
  Scenario Outline: Get user details of page 2
    Given I set a GET details service endpoint with header and "<resource>"
      | key          | value            |
      | Content-Type | application/json |
    When I send a GET request to the server
    Then I recieve a "<status_code>"
    And body for the request

    Examples:
      | status_code |resource|
      | 201         | abc       |