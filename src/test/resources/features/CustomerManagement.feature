
@customerManagementTests
Feature: Customer management

  Background:
    Given As an entity user, I am logged in
    When I navigate to the customers tab

    @newCustomerBTNTest
  Scenario: As a user when I navigate to the Customers Tab, I should see New customer button
      Then I should see the New Customer button displayed

      @newCustomerBasicFormLabel
      Scenario: As a user I verify that a Basic info form label is present
        Then I click on the New Customer button
        Then I verify that a Basic info form label is present

        @newCustomerLabelsVerification
        Scenario: As a user I navigate to the Customers tab and I should see the Basic info section
          Given As a user, I am on the login page
          When I enter valid usermail and valid password
          And Click on login button
          Then I navigate to the customers tab
          Then I click on the New Customer button
          Then I verify that Display Name *, Primary Contact Name, Email, Primary Currency *, Website, Prefix are present

          @CustomerTableVerification
          Scenario: As a user when I navigate to the Customers Tab, I should see the Customers Table List
          Given As a user, I am on the login page
          When I enter valid usermail and valid password
          And Click on login button
          Then I navigate to the customers tab
          And I click on the New Customer button
          Then I verify that a customer list table is present

            @CustomerFieldsVerification
            Scenario: As a user when I navigate to the Customers Tab, I should see 4 columns present in the table
              Given As a user, I am on the login page
              When I enter valid usermail and valid password
              And Click on login button
              Then I navigate to the customers tab
              And I verify the four columns are present in the table Name, Phone, Amount Due, Added On

              @CustomerMoreVerification
              Scenario: As a user when I navigate to the Customers Tab, I should see a More Link
                Given As a user, I am on the login page
                When I enter valid usermail and valid password
                And Click on login button
                Then I navigate to the customers tab
                And I verify that a More Link for the customer row with the option Edit, View, and Delete is present

                @newCustomerCreatedMessage
                Scenario: As I user when I navigate to the Customers Tab, when I create a user I should see a pop up message
                  And I click on the New Customer button
                  Then I enter a display name
                  And click save
                  Then I should see the pop up message "Customer created successfully"
                  And I delete the customer

  @newCustomerErrorFieldVerification
  Scenario: As I user when I navigate to the Customers Tab and try creating a new customer without passing any info,
 And I click on the New Customer button
    And click save
    Then I should see the error message "Field is required" below the Display Name field

    @newCustomers
    Scenario Outline:As a user, when I create a new customer I should see the Customer Table
      And I click on the New Customer button
      And I enter a valid "<DisplayName>", "<Email>", "<State>", "<City>", and "<ZipCode>"
      And click save
      Then I view the saved customer in the Customers Table
      And I delete the customer

      Examples:
        | DisplayName|        Email       | State | City            |ZipCode|
        | Student1    | student1@gmail.com | VA    | Fairfax         | 12345 |
        | Student2    | student2@gmail.com | MD    | Rockville       | 00000 |
        | Student3    | student3@gmail.com | CA    | Orange County   | 54321 |

      @newCustomersTestCase2
      Scenario Outline: As a user, when I create a new customer with invalid credentials I should see error messages
        And I click on the New Customer button
        And I enter Display Name "<DisplayName>" and Email "<Email>"
        Then I should see error messages

        Examples:
          | DisplayName                 |  Email             |
          | qw                          | 12345@mail.com     |
          | ab                          | johnsmith@mail.com |
          |                             | johnsmith@mail.com |
          | student                     | email              |







