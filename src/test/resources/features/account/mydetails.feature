Feature: My details page

  @account
  Scenario: my information
    Given user on the login page
    And user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    When the user goes to the "amazon" page
    Then the user should see their information:
      | name   | Ruthann Johnes      |
      | role   | student-team-leader |
      | team   | CodeHunters         |
      | batch  | #8                  |
      | campus | VA                  |

  Scenario Outline: my information data driven test <user_name>
    Given user on the login page
    And user logs in using "<user_email>" and "<user_password>"
    When the user goes to the "my self" page
    Then the user should see their information:
      | name   | <user_name>   |
      | role   | <user_role>   |
      | team   | <user_team>   |
      | batch  | <user_batch>  |
      | campus | <user_campus> |

    Examples:
      | user_email                    | user_password     | user_campus | user_name          | user_team           | user_role   | user_batch |
      | lruffli93@dailymail.co.uk     | menardnewbatt     | VA          | Menard Newbatt     | Guardians of Galaxy | team-leader | #7         |
      | elaye8m@wikipedia.org         | tabordullingham   | VA          | Tabor Dullingham   | DevOps              | student     | #7         |
      | sweeklybh@spotify.com         | bartletcarlin     | IL          | Bartlet Carlin     | Cucumber            | student     | #8         |
      | ucarlislebv@gizmodo.com       | herbyedwicke      | IL          | Herby Edwicke      | Swift               | student     | #8         |
      | strayford84@e-recht24.de      | carlosmichie      | VA          | Carlos Michie      | Frostbite           | team-leader | #8         |
      | jrowesby8h@google.co.uk       | aldridgegrimsdith | VA          | Aldridge Grimsdith | Rangers             | student     | #7         |
      | mnewbatt8o@utexas.edu         | opalcave          | VA          | Opal Cave          | DevOps              | student     | #7         |
      | teachervamikemarcus@gmail.com | mikemarcus        | VA          | Mike Marcus        | TeachersBand        | teacher     | #7         |
      | kpenvarne87@w3.org            | marianspinley     | VA          | Marian Spinley     | Bugbusters          | student     | #8         |
      | vwincklec5@latimes.com        | standfordboase    | IL          | Standford Boase    | JSGuru              | student     | #8         |
      | rkernocke7m@cnet.com          | merrileeambler    | VA          | Merrilee Ambler    | CodeHunters         | student     | #8         |
      | bcircuit81@whitehouse.gov     | heinriksummersett | VA          | Heinrik Summersett | Microsoft           | student     | #8         |
      | fbawmeb7@studiopress.com      | sherilyngohn      | IL          | Sherilyn Gohn      | Hibernate           | student     | #8         |
      | bczadla7p@uol.com.br          | humphreyalsop     | VA          | Humphrey Alsop     | Spark               | student     | #8         |
      | kodonnelly7t@bigcartel.com    | robertamurrison   | VA          | Roberta Murrison   | Django              | student     | #8         |
      | nshearsby7w@uiuc.edu          | lorettebradnum    | VA          | Lorette Bradnum    | Nukes               | student     | #8         |
      | sbirdbj@fc2.com               | asenorval         | IL          | Ase Norval         | Cucumber            | team-leader | #8         |
      | efieldenba@cbslocal.com       | claudinebarnsley  | IL          | Claudine Barnsley  | JSP                 | team-leader | #8         |
      | kcotterelbq@homestead.com     | hannierrington    | IL          | Hanni Errington    | Kubernetes          | student     | #8         |
      | alanneybc@booking.com         | randenemacgown    | IL          | Randene Macgown    | Docker              | student     | #8         |
      | aneagle7h@miibeian.gov.cn     | bennetttomanek    | VA          | Bennett Tomanek    | The Crew            | student     | #8         |
      | iclementet8y@bluehost.com     | ursalaklimes      | VA          | Ursala Klimes      | Serenity            | student     | #7         |
      | mstacey8r@imdb.com            | skylargiblin      | VA          | Skylar Giblin      | Jasmine             | student     | #7         |


  Scenario Outline: my information data driven test with excel <user_name>
    Given user on the login page
    And user logs in using "<user_email>" and "<user_password>"
    When my self page should display personal information for that user

    Examples:
      | user_email                    | user_password     |
      | lruffli93@dailymail.co.uk     | menardnewbatt     |
      | elaye8m@wikipedia.org         | tabordullingham   |
      | sweeklybh@spotify.com         | bartletcarlin     |
      | ucarlislebv@gizmodo.com       | herbyedwicke      |
      | strayford84@e-recht24.de      | carlosmichie      |
      | jrowesby8h@google.co.uk       | aldridgegrimsdith |
      | mnewbatt8o@utexas.edu         | opalcave          |
      | teachervamikemarcus@gmail.com | mikemarcus        |
      | kpenvarne87@w3.org            | marianspinley     |
      | vwincklec5@latimes.com        | standfordboase    |
      | rkernocke7m@cnet.com          | merrileeambler    |
      | bcircuit81@whitehouse.gov     | heinriksummersett |
      | fbawmeb7@studiopress.com      | sherilyngohn      |
      | bczadla7p@uol.com.br          | humphreyalsop     |
      | kodonnelly7t@bigcartel.com    | robertamurrison   |
      | nshearsby7w@uiuc.edu          | lorettebradnum    |
      | sbirdbj@fc2.com               | asenorval         |
      | efieldenba@cbslocal.com       | claudinebarnsley  |
      | kcotterelbq@homestead.com     | hannierrington    |
      | alanneybc@booking.com         | randenemacgown    |
      | aneagle7h@miibeian.gov.cn     | bennetttomanek    |
      | iclementet8y@bluehost.com     | ursalaklimes      |
      | mstacey8r@imdb.com            | skylargiblin      |

