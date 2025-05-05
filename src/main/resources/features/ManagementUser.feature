Feature: User

  Scenario: I Filter User Data
    Given I am on the user page
    When I click management
    And I click button user
    Then I see message application error on the user page
