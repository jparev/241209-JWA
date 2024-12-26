@US5
Feature: Delete User Planet and Moons

  Background:
    Given   the user is logged in
    And     the user is on the planetarium homepage

  Scenario: Users can delete planets with valid details
    When    the user clicks the planet deletion link
    And     the user provides planet name "Earth" to delete
    And     the user click the delete button
    Then    the planet and its corresponding moons are deleted
    And     the homepage would be updated

  Scenario Outline: Users can not delete planets with invalid details
    When    the user clicks the planet deletion link
    And     the user provides planet name "<planetName>" to delete
    And     the user click the delete button
    Then    the user should get a browser alert saying "<alert>"

  Examples:
  |planetName   |alert              |
  |Not Earth	|Invalid planet name|
  |Luna 	    |Invalid planet name|
  |Neptune      |Invalid planet name|

  @MR5
  Scenario: Users can delete moons with valid details
    When    the user clicks the moon deletion link
    And     the user provides moon name "Luna" to delete
    And     the user click the delete button
    Then    the table would refresh

  Scenario Outline: Users can not delete moons with invalid details
    When    the user clicks the moon deletion link
    And     the user provides moon name "<moonName>" to delete
    And     the user click the delete button
    Then    the user should get a browser alert saying "<alert>"

    Examples:
    |moonName   |alert            |
    |Earth	    |Invalid moon name|
    |Not Luna 	|Invalid moon name|

