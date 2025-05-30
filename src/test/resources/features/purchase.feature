#language:en
@FEATURE_purchase @regresion
Feature: Purchase

  @test_0002
  Scenario: Purchase a product
    Given  I open the website
    And  I add a product with the name "Samsung galaxy s6" to the cart
    And I go to the menu "Cart"
    And I place an order
      | name  | country | city | creditCard | month | year |
      | Logan | Brazil  | Rio  | 123456     | 5     | 2025 |
    When I complete the purchase
    Then I should see the message "Thank you for your purchase!"
    And I should see the datails of the purchase
      |amount|cardNumber|name|
      |360 USD|123456   |Logan|

  @test_0003
  Scenario: Purchase three products
    Given  I open the website
    And  I add a product with the name "Samsung galaxy s6" to the cart
    And  I add a product with the name "Nokia lumia 1520" to the cart
    And  I add a product with the name "Iphone 6 32gb" to the cart
    And I go to the menu "Cart"
    And I place an order
      | name  | country | city | creditCard | month | year |
      | Logan | Brazil  | Rio  | 123456     | 5     | 2025 |
    When I complete the purchase
    Then I should see the message "Thank you for your purchase!"
    And I should see the datails of the purchase
      | amount   | cardNumber | name  |
      | 1970 USD | 123456     | Logan |