Feature: Add to Cart Feature

  Scenario: Add a single item to the cart
    Given I am logged in with valid credentials
    When I add "Sauce Labs Backpack" to the cart
    Then I should see 1 item in the cart

  Scenario: Add multiple items to the cart
    Given I am logged in with valid credentials
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bike Light" to the cart
    Then I should see 2 items in the cart
