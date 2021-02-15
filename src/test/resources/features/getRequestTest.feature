Feature: This feature is to test get requests

  @Get_Test
  Scenario Outline: Get user details of page 2
    Given I set a GET details service endpoint with header
      | Content-Type | application/json  |
    When I send a GET request to the server "<resource>"
    Then I recieve a <status_code>
    And body for the request

    Examples:
      | status_code | resource |
      | 200         | GETUser  |