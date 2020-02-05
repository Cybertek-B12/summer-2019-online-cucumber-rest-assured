@smoke
Feature: campus locations

  @va-dark
  Scenario: VA - dark side
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    Then location should be "dark-side"

  @va-light
  Scenario: VA - light side
    Given user on the login page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then location should be "light-side"

  @il
  Scenario: Illinois
    Given user on the login page
    When user logs in using "fbawmeb7@studiopress.com" and "sherilyngohn"
    Then location should be "il"


  Scenario Outline: Verify campus names <email>
    Given user on the login page
    When user logs in using "<email>" and "<password>"
    Then location should be "<campus>"

    Examples:
      | email                         | password          | campus     |
      | fbawmeb7@studiopress.com      | sherilyngohn      | il         |
      | ucharlot7y@nbcnews.com        | archibaldmelloy   | light-side |
      | sweeklybh@spotify.com         | bartletcarlin     | il         |
      | teacherva4@gmail.com          | markwohlberg      | light-side |
      | crundall8e@discuz.net         | eloisamaccauley   | dark-side  |
      | sbirdbj@fc2.com               | asenorval         | il         |
      | ucarlislebv@gizmodo.com       | herbyedwicke      | il         |
      | rkernocke7m@cnet.com          | merrileeambler    | light-side |
      | kcotterelbq@homestead.com     | hannierrington    | il         |
      | nshearsby7w@uiuc.edu          | lorettebradnum    | light-side |
      | elaye8m@wikipedia.org         | tabordullingham   | dark-side  |
      | jrowesby8h@google.co.uk       | aldridgegrimsdith | dark-side  |
      | efieldenba@cbslocal.com       | claudinebarnsley  | il         |
      | aneagle7h@miibeian.gov.cn     | bennetttomanek    | light-side |
      | bcircuit81@whitehouse.gov     | heinriksummersett | light-side |
      | kodonnelly7t@bigcartel.com    | robertamurrison   | light-side |
      | mnewbatt8o@utexas.edu         | opalcave          | dark-side  |
      | kpenvarne87@w3.org            | marianspinley     | light-side |
      | fbawmeb7@studiopress.com      | sherilyngohn      | il         |
      | alanneybc@booking.com         | randenemacgown    | il         |
      | lruffli93@dailymail.co.uk     | menardnewbatt     | dark-side  |
      | strayford84@e-recht24.de      | carlosmichie      | light-side |
      | mstacey8r@imdb.com            | skylargiblin      | dark-side  |
      | teachervamikemarcus@gmail.com | mikemarcus        | dark-side  |
      | iclementet8y@bluehost.com     | ursalaklimes      | dark-side  |
      | bczadla7p@uol.com.br          | humphreyalsop     | light-side |
      | vwincklec5@latimes.com        | standfordboase    | il         |

