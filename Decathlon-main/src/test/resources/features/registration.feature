Feature: registration

  Scenario Outline: Title of your scenario outline
    Given I want to register <name>
    And I select the <event> in step
    When I save the informations
    Then <name> and <event> is saved

    Examples: 
      | name  | event      |
      | name1 | Heptathlon |
      | name2 | Decathlon  |
