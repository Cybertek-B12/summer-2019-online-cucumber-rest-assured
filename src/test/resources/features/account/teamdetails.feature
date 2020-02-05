Feature: Team details

  Scenario: Team members test
    Given user on the login page
    And user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    When the user goes to the "my team" page
    Then following team members should be displayed:
      | Archibald |
      | Leonard   |
      | Lorette   |
      | Durant    |
