Feature: Login

  Scenario: Login with valid credentials
    Given I am on the login page
    When I enter a valid email and password
    And I click the login button
    Then I should be redirected to dashboard page