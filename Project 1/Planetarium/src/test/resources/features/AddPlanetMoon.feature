@US4
Feature: Add Planets and Moons
  As a user I want to add new planets and moons to the Planetarium so I can update my findings

  Background:
    Given   the user is logged in
    And     the user is on the planetarium homepage

  Scenario Outline: Users can add planets with valid details
    When    the user clicks the planet creation link
    And     the user provides planet name "<planetName>"
    And     the user provides planet image "<planetImage>"
    And     the user clicks on submit
    Then    the homepage should be updated

  Examples:
  |planetName   |planetImage    |
  |Jarilo - 6_	|jarilo-vi.jpeg |
  |Jarilo - 6_	|jarilo-vi.png  |
  |Jarilo - 6_	|               |

  @PR1 @PR2 @PR @PR4 @PR5 @PR6
  Scenario Outline: User can not add planets with invalid details
    When    the user clicks the planet creation link
    And     the user provides planet name "<planetName>"
    And     the user provides planet image "<planetImage>"
    And     the user clicks on submit
    Then    the user should get a browser alert saying "<alert>"

  Examples:
  |planetName                       |planetImage   |alert              |
  | 	                            |jarilo-vi.jpeg|Invalid planet name|
  |Penacony - Planet of Festivities	|jarilo-vi.jpeg|Invalid planet name|
  |N3w_Eridu- ?!%	                |jarilo-vi.jpeg|Invalid planet name|
  |Earth     	                    |jarilo-vi.jpeg|Invalid planet name|
  |Jarilo - 6_	                    |jarilo-vi.gif |Invalid file type  |

  Scenario Outline: User can add moons with valid details
    When    the user clicks the moon creation link
    And     the user provides moon name "<moonName>"
    And     the user provides moon image "<moonImage>"
    And     the user provides a planet "<planetId>" owning the moon
    And     the user clicks on submit
    Then    the homepage should be updated

  Examples:
  |moonName       |moonImage      |planetId|
  |Celestia - 13_ |celestia.jpeg  |1       |
  |Celestia - 13_ |celestia.png   |1       |
  |Celestia - 13_ | 	          |1       |

  @MR1 @MR2 @MR3 @MR4 @MR6 @MR7
  Scenario Outline: User can not add moons with invalid details
    When    the user clicks the moon creation link
    And     the user provides moon name "<moonName>"
    And     the user provides moon image "<moonImage>"
    And     the user provides a planet "<planetId>" owning the moon
    And     the user clicks on submit
    Then    the user should get a browser alert saying "<alert>"

  Examples:
  |moonName                         |moonImage      |planetId |alert            |
  | 	                            |celestia.jpeg  |1        |Invalid moon name|
  |Inazuma - The Land of Eternity_  |celestia.jpeg  |1        |Invalid moon name|
  |The L4nd_of-Et3n1ty!?%	        |celestia.jpeg  |1        |Invalid moon name|
  |Luna 	                        |celestia.jpeg  |1        |Invalid moon name|
  |Celestia - 13_	                |celestia.jpeg  |1217	  |Invalid planet id|
  |Celestia - 13_	                |celestia.gif	|1        |Invalid file type|
