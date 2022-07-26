Feature: Login Tests
  User Story:
  As a user, I should be able to login.And dashboard should be displayed.
  Accounts are:sales manager, store manager, truck driver

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the transmuda login page

  Scenario: Login as sales manager
    When user enters sales manager username
    And user enters sales manager password
    Then user should see the dashboard

  Scenario: Login as store manager
    When user enters store manager username
    And user enters store manager password
    Then user should see the dashboard

  Scenario: Login as truck driver
    When user enters truck driver username
    And user enters truck driver password
    Then user should see the dashboard


  Scenario: without providing credentials test
    When user get url and log out
    And pass the url again
    Then user should not login

  Scenario: invalid credentials
    When user wrote wrong username or password
    Then user must see massage

    Scenario: without credentials
      When user do not write usernae or password
      Then user should see the please fill message

    Scenario: password bullet sign
      When user wrote his password
      Then user should see bulletsign

      Scenario: Forgot Password menu
        When  click on the Forgot your password link
        Then user should see forgot password page

    Scenario: change password with username
      When click on the Forgot your password link
      Then user can change password with username

    Scenario: without providing credentials if "Remember me on this computer" checkbox is clicked
      When user click remember me check box
      And login and logout
      Then user can able to login again

    Scenario: Using Enter key to switch to the next field
      When user wrote his username click enter
      And user wrote his password click enter
      And user click login button
      Then user should login

    Scenario: see username on profile menu
      When user wrote his username and password
      Then should see his username on profile menu

