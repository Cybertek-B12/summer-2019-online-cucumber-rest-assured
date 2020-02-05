@login
Feature: login functionality

  Scenario: teacher login
    Given user on the login page
    When user logs in using "myemail@hotmail.com" and "mysecurepassword"
    Then homepage should be displayed
    And title should be "homepage"
    And there should be 44 menu options

    Scenario: team leader login
      Given user on the login page
      # use the login info of a team lead
      When user logs in using "myemail@gmail.com" and "regularpassword"
      Then homepage should be displayed
      And title should be "homepage"