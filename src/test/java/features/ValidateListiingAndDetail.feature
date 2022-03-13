Feature: Verify data shown on the listing screen must match with the detail screen


@smoke
  Scenario Outline: Verify country detail screen data as per the country selected by the user
    Given user is on the dashboard page and navigates to Countries listing screeen from Countries tab
    Then select country <capital> from the countries listing screen
    And verify name, code, capital, continent, currency, language on the detail must be same as per the listing screen
       
Examples:
| capital |
| Abu Dhabi |

