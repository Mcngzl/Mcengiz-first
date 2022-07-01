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