Feature: This feature is to test get requests

  Scenario Outline: This test will get details of page 2
    Given An authorized user
    When want details of page "<page>"
    Examples:
      | page |
      | 2    |