Feature: Verify countries visited and country to visist count is working as expected

@smoke
  Scenario Outline: Verify countries visited count on dashboard screen by selecting the countries from detail screen
    Given user is on the dashboard page and navigates to Countries listing screeen from Countries tab
    And select  <Placename> from the countries listing screen
    Then click on Set As Visited button 
    And go to the Dashboard and verify the count must get update
   
Examples:
| Placename |
| India |


@smoke
  Scenario Outline: Verify countries to visit count on dashboard screen by selecting a countries from the listing screen
    Given user is on the dashboard page and navigates to Countries listing screeen from Countries tab
    And search  <Country> from the search text field
    Then click on Want to go icon
    And verify the count on the dasboard screen
   
Examples:
| Country |
| Canada |


