Feature: Add a new computer.

  Scenario: Create a new computer with complete details
    Given I access the Computer Database page
    When I click Add a new computer button
    And I enter Computer Name
    And I enter Introduced
    And I enter Discontinued
    And I select Company
    And I click the Create this computer button
    Then I should see a success message