Feature: This scenario is to find out the broken link from Dashbard, Listing and Detail screen

@smoke

   Scenario Outline: Verify all links are working fine for Home, Countries listing, Country Detail screen
    Given user is on the dasboard page and verify the link
     Then go to country listing screen verify the link
    And navigates to <capital> capital and again verify the link
     
Examples:
| capital |
|The Valley|