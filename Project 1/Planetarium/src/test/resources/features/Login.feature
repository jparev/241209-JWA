@US2 @SR2 @SR3
Feature: User Login
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background: Login Starting Actions
    Given the user is on the login page

  Scenario: Users can login with valid credentials
    When  the user provides login username "Batman"
    And   the user provides login password "Iamthenight1939"
    And   the user submits the credentials
    Then  the user should be redirected to the planetarium homepage

  Scenario Outline: Users can not login with invalid credentials
    When  the user provides login username "<username>"
    And   the user provides login password "<password>"
    And   the user submits the login credentials
    Then  the user should get a browser alert saying "<alert>"
    And   the user should stay on the login page

  Examples:
  |username	|password	    |alert              |
  |Batman	|m1Ya           |Invalid credentials|
  |Hoshi	|Iamthenight1939|Invalid credentials|
  |Hoshi	|m1Ya           |Invalid credentials|