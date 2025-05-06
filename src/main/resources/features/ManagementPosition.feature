Feature: Management Position
#19
  Scenario: Searching for position
    Given I navigate to the posisi page
    When I enter a position "Admin 1"
    And I click the search button
    Then I should be get the position list "Admin 1"
#20
  Scenario: Adding position
    Given I navigate to the posisi page
    When I click tambahkan button
    And I fill in the following position information:
      | Nama Position      | Nama Departement |
      | Manager            | Juara Coding     |
    And I click the tambah button
    Then An success message indicating "Berhasil Menambahkan Position" should be displayed in "position"
#21
  Scenario: Adding position without fill Nama Position
    Given I navigate to the posisi page
    When I click tambahkan button
    And I fill in the following position information:
      | Nama Position      | Nama Departement |
      |                    | Juara Coding     |
    And I click the tambah button
    Then An success message indicating "Please fill out this field." should be displayed in "positionName"


