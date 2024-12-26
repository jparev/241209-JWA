  @US1 @SR1
  Feature: User Registration
    As a new user I want to open an account with the Planetarium so I can save my celestial findings

    Background: Registration Starting Actions
      Given the user is on the login page
      And   the user clicks the register link

    Scenario: Users can register a new account with valid credentials
      When  the user provides username "Miyabi_12-17"
      And   the user provides password "Hoshimi_12-17"
      And   the user submits the credentials
      Then  the user should get a browser alert saying "Account created successfully"
      And   the user should be redirected to the login page

    @UR1 @UR2 @UR3 @UR4 @UR5 @UR6
    Scenario Outline: Users can not register a new account with invalid credentials
      When  the user provides username "<username>"
      And   the user provides password "<password>"
      And   the user submits the credentials
      Then  the user should get a browser alert saying "<alert>"
      And   the user should stay on the registration page

    Examples:
    |username                         |password                         |alert                        |
    |Batman                           |Hoshimi_12-17                    |Invalid username             |
    |Miya                             |Hoshimi_12-17                    |Invalid username             |
    |hoshimi_miyabi_zenless_zone_zero |Hoshimi_12-17                    |Invalid username             |
    |6mindscape                       |Hoshimi_12-17                    |Invalid username             |
    |miyabi!?^                        |Hoshimi_12-17                    |Invalid username             |
    |Miyabi_12-17                     |m1Ya                             |Invalid password             |
    |Miyabi_12-17                     |Hoshimi_miyabi_12-17_release-date|Invalid password             |
    |Miyabi_12-17                     |1217Miyabi                       |Invalid password             |
    |Miyabi_12-17                     |Miyabi-mindscape_6!?             |Invalid password             |
    |Miyabi_12-17                     |miyabi6                          |Invalid password             |
    |Miyabi_12-17                     |MIYABI6                          |Invalid password             |
    |Miyabi_12-17                     |Miyabi                           |Invalid password             |
