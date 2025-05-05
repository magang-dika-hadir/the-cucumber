Feature: Unit

#  Scenario 1
  Scenario: I Filter Unit Data
    Given I am on the unit page
    When I click login
    And I click management
    And I click submenu unit
    And I input unit valid
    And I click searching unit
    Then I see unit valid

#    Scenario 2
  Scenario: I reset unit after filter data
    When I click button reset
    Then I see all unit on page unit

#    Scenario 3
  Scenario: I added valid data unit
    When I click button add data unit
    And I fill form add data valid
    Then I see message success added

#    Scenario 4
  Scenario: I added and did not fill in the data unit name
    When I click button add data unit invalid
    And Im not fill in the data unit name
    Then I see message invalid added

  Scenario: I added and did not fill in the data lokasi tetap aturan cuti and unit kalender
    When I click button add data unit invalid 2
    And Im not input lokasi tetap and unit kalender also aturan cuti
    Then I see message Berhasil Menambahkan Unit

#    Scenario 5
  Scenario: I added a new shift
    When I click button action
    And I click button shift
    And I click button add a new shift
    And I fill a new shift
    Then I see message success added a new shift

#    Scenario 6
  Scenario: I added a new shift but no input shift name
    When I click button added a new shift
    And Im not fill a new shift name
    Then I see message invalid added a new shift

#    Scenario 7
  Scenario: I added additional work hours
    When I click the action button on the new shift
    And I click button view on new shift
    And I click button add on shift
    And I input additional working hours
    Then I see message Berhasil Menambah Type Detail Shift

#    Scenario 8
  Scenario: I added additional work hours but not input shifting
    When I click button add shift
    And Im not input additional work hours
    Then I see message shifting id is a required field

  Scenario: I delete additional work hours
    When I click button action on additional work hours
    And I click button delete additional work hours
    Then I click button hapus

  Scenario: Im  not input virtual id
    When I go to unit page
    And I filter unit
    And I click button action virtual ID
    And I click button Virtual ID
    And I click button save
    Then I see message Foto tidak boleh kosong

  Scenario: I uploaded a file that exceeds the capacity.
    When I click virtual button
    And I upload file that exceeds the capacity
    And I click button choose colour
    And I fill colour footer
    And I click button submit
    Then I see message Foto tidak boleh kosong 2

  Scenario: I input virtual id valid
    When I click button virtual
    And I click button pilih foto
    And I click button warna
    And I choose colour
    And I click button atur
    Then I see message Berhasil Mengatur Virtual ID