@login
Feature: Home page
  As a user, when I enter correct login information,
  I should be able to login

  # comment

  Background:
    Given user on the login page

  @leader
  Scenario: login as team lead
    When user logs in as a team lead
    Then homepage should be displayed
#    And the title should be correct

  @member
  Scenario: login as team member
    When user logs in as a team member
    Then homepage should be displayed

  @teacher
  Scenario: login as teacher
    When user logs in as a teacher
    Then homepage should be displayed

  Scenario Outline: login as different members
    When user logs in as a <type>
    Then homepage should be displayed

    Examples:
      | type        |
      | team member |
      | team lead   |
      | teacher     |