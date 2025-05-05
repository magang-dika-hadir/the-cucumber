Feature: User

  Scenario: I Filter User Data
    Given I am on the user page
    When I click management
    And I click button user
    Then I see message application error on the user page

#    Scenario: I reset unit after filter data
#    When I click button reset
#    Then I see all unit on page unit
#    When I click button management
#    And I click button user
#    Then I see message application error on the user page