Feature: This feature is to test get requests

  @Get_Test
  Scenario Outline: Get user details of page 2
    Given I set a "GET" details service endpoint with header
      | Content-Type | application/json |
    When I send a GET request to the server "<resource>"
    Then I recieve a <status_code>
    And validate body for the request
      | data[1].first_name | Lindsay                |
      | data[2].first_name | Tobias                 |
      | data[3].email      | byron.fields@reqres.in |

    Examples:
      | status_code | resource |
      | 200         | GETUser  |

    @Post_Test
    Scenario Outline: Post user to the server
      Given I set a "POST" details service endpoint with header
        | Content-Type | application/json |
      When I send a POST request to "<resource>" with "<user_Details>" body
      Then I recieve a <status_code>
      And validate body for the request
        | data[1].first_name | Lindsay                |
        | data[2].first_name | Tobias                 |
        | data[3].email      | byron.fields@reqres.in |

      Examples:
        | status_code | resource |user_Details|
        | 200         | POSTUser  |User|


  @CaptureGroups
  Scenario Outline: Capture Groups
    """
    This is to Test Regular expression to accept any string
    """
    Given I log in as an "admin" to the site
    Given I log in as an "guest" to the site

    ###This is for regular expression for any string with one as OR condition

    Given I work as Engineer in the Software company

    ###This is for creating optional parameter that would bypass certain characters and input value

    Given I will test positive scenario as well as "<anyScenario>"
    Given I will test positive scenario

    Examples:
      | anyScenario |
    |    negative     |

