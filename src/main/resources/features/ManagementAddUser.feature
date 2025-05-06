Feature: Add User Management
#2
  Scenario: Add a new user with valid credential
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess12345@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then The new user should be added successfully
#3
  Scenario: Attempt to register a new user without uploading a profile picture
    Given I navigate to the pendaftaran user page
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Foto tidak boleh kosong" should be displayed in "foto"
#4
  Scenario: Attempt to register a new user without fill NIK
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      |     | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Mohon untuk mengisi NIK" should be displayed in "nik"

#5
  Scenario: Attempt to register a new user with unregisterd NIK
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | 123 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "NIK Anda tidak ditemukan" should be displayed in "nik"
#6
  Scenario: Attempt to register a new user without fill Email
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          |       | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "notNull Violation: users.email cannot be null" should be displayed in "email"
#7
  Scenario: Attempt to register a new user with wrong email format
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email     | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess      | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "notNull Violation: users.email cannot be null" should be displayed in "email"
#8
  Scenario: Attempt to register a new user without fill Nama Karyawan
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 |               | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "name"
#9
  Scenario: Attempt to register a new user fill Nama Karyawan with 1 character
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | a             | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please lengthen this text to 2 characters or more (you are currently using 1 character)." should be displayed in "name"
#10
  Scenario: Attempt to register a new user without fill Password
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com |             | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "password"
#11
  Scenario: Attempt to register a new user fill Password with 1 character
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | a           | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please lengthen this text to 8 characters or more (you are currently using 1 character)." should be displayed in "password"
#12
  Scenario: Attempt to register a new user without fill Divisi
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com |         | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "division"
#13
  Scenario: Attempt to register a new user without fill Unit
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  |      | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "unit"
#14
  Scenario: Attempt to register a new user without fill Posisi Kerja
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   |              | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "jobPosition"
#15
  Scenario: Attempt to register a new user without fill Jabatan
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      |         | Magang       | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "jobTitle"
#16
  Scenario: Attempt to register a new user without fill Tipe Kontrak
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 |              | DIKA 1       | Non Shift  | BCA Life     | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "contractType"
#17
  Scenario: Attempt to register a new user without fill Jadwal Kerja
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  |              | Selfie | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "workSchedule"
#18
  Scenario: Attempt to register a new user without fill selfie
    Given I navigate to the pendaftaran user page
    And I upload the profile picture "profile.jpg"
    And I fill in the following detailed user information:
      | NIK      | Nama Karyawan | Email             | Password    | Divisi  | Unit | Posisi Kerja | Jabatan | Tipe Kontrak | Lokasi Kerja | Tipe Shift | Jadwal Kerja | Selfie | Jumlah Cuti |
      | D7240029 | Jess          | jess123@gmail.com | jess123.com | 123456  | 3D   | Admin 1      | staff 2 | Magang       | DIKA 1       | Non Shift  | BCA Life     |        | 12          |
    And I click the submit button
    Then An error message indicating "Please fill out this field." should be displayed in "selfie"