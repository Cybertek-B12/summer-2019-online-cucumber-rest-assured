Feature: Map page details

  Scenario: Light side rooms - ping pong
    Given user on the login page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then I should be able to see "ping pong" room


  Scenario: Light side all rooms
    Given user on the login page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then the user should be able to see following conference rooms:
      | harvard   |
      | yale      |
      | princeton |

# shortcut to format file in intellij
# CMD+OPTION+L  mac
# CMTR+ALT+L    win
  # Kasim go