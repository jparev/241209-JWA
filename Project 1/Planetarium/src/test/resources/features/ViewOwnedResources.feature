@US3 @SR2 @SR3
Feature: View User Planets and Moons
  As a user I want to see my planets and moons added to the Planetarium so I can track my findings

  @PR4 @MR4
  Scenario: Users logged in should be able to view the home page and its resources
    Given the user is logged in
    And   the user is on the planetarium homepage
    Then  the user should be able to view their planets and moons

  Scenario: Users not logged in should not be able to view the home page and its resources
    Given the user is not logged in
    When  the user goes to the planetarium homepage
    Then  the user should not be able to access the planetarium homepage