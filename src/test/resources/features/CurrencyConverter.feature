Feature: Currency Converter

  Scenario: Test Multiple conversion rates

  #################################################################################
  # Automation TCID :-           CC-001                                        ####
  #################################################################################

  @CC-001
  Scenario Outline: Verify multiple currency rates

    Given I am on "Xe Currency Converter" landing page
    When I enter amount to be converted as "<Amount>" on 'Xe Converter' Page
    And I enter from currency as "<FromCurrency>" on 'Xe Converter' Page
    And I enter to currency as "<ToCurrency>" on 'Xe Converter' Page
    And I click on "Convert" button on 'Xe Converter' Page
    And I note "VALUE" converted value from conversion table
    Then I verify from currency amount is displayed as "<Amount>" on 'Xe Converter' Page
    And I verify To currency amount is displayed as "VALUE" on 'Xe Converter' Page
    Then I verify from currency is displayed as "<FromCurrency>" under live conversion value on 'Xe Converter' Page
    And I verify To currency is displayed as "<ToCurrency>" under live conversion value on 'Xe Converter' Page
    And I close the application

    Examples:
    | Amount    | FromCurrency    | ToCurrency  |
    | 1         | British Pound   | Euro        |
    | 1         | Canadian Dollar | Euro        |
    | 1         | Indian Rupee    | US Dollar   |
    | 1         | Japanese Yen    | Swiss Franc |
    | 1         | Bitcoin         | Euro        |


  #################################################################################
  # Automation TCID :-           CC-002                                        ####
  #################################################################################

  @CC-002
  Scenario Outline: Verify the calculation of currency conversion

    Given I am on "Xe Currency Converter" landing page
    When I enter amount to be converted as "<Amount>" on 'Xe Converter' Page
    And I enter from currency as "<FromCurrency>" on 'Xe Converter' Page
    And I enter to currency as "<ToCurrency>" on 'Xe Converter' Page
    And I click on "Convert" button on 'Xe Converter' Page
    And I note "VALUE" as base conversion value
    And I note "RESULTANT" value with "<Amount>" and "VALUE"
    Then I verify To currency amount is displayed as "RESULTANT" on 'Xe Converter' Page
    And I close the application

    Examples:
      | Amount    | FromCurrency    | ToCurrency |
      | 8         | US Dollar       | Euro       |
      | 18        | US Dollar       | Euro       |


  #################################################################################
  # Automation TCID :-           CC-003                                        ####
  #################################################################################

  @CC-003
  Scenario: Verify invalid amount

    Given I am on "Xe Currency Converter" landing page
    When I enter amount to be converted as "ABC" on 'Xe Converter' Page
    Then I verify "Please enter a valid amount" is displayed under Amount field
    And I close the application