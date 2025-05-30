#language:en
@FEATURE_home @regresion
Feature: Home

  @test_0001
  Scenario: Get product information from the first two pages
    Given  I open the website
    And I go to the menu "Home"
    When I extract the data from the products
    Then I should save the information into a text file named "target/products.txt"

  @test_0003
  Scenario: Sign up with valid data
    Given  I open the website
    And I go to the menu "Sign up"
    When I sign up with user "Logan" and password "123456"
    Then I should see an alert with the message "Sign up successful."