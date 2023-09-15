@UserManagement
  Feature: User management / access management
@validLogin
    Scenario: User should be able to login with valid credentials
      Given As a user, I am on the login page
      When I enter valid usermail and valid password
      And Click on login button
      Then I should be logged in

    @invalidEmailLogin
    Scenario: Invalid email login attempts
      Given As a user, I am on the login page
      When I enter invalid username and valid password
      And Click on login button
      Then I should see an error message "These credentials do not match our records." displays
      And I should not be logged in

    @InvalidLoginAttempt:
    Scenario Outline: As a user, I should see an error message putting invalid credentials
      Given As a user, I am on the login page
      When I enter invalid useremail "<useremail>" and password "<passweord>"
      And I click on the login button
      Then I should see an error message
      And I should not be logged in

      Examples:
        | useremail                   |  passweord      |
        | helil@primetechschool.com   | standardhhfvajk |
        | nothing@primetechschool.com | Testing123      |
        |                             | Testing123      |
        | nothing@primetechschool.com |                 |






