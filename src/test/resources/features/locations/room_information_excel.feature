Feature: room information functionality


  Scenario: Room details
    Given user on the login page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then correct room information should be displayed for light side
#    And room information should be displayed as given in "file_path" "sheetname"


  Scenario: room information
    Given user on the login page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then user should be able to see quotes info for each room
      | ping pong | the more the better |
      | harvard   | the more the better |
      | yale      | the more the better |
      | stanford  | the more the better |
      | princeton | less is more        |
      | duke      | less is more        |
      | berkeley  | less is more        |
