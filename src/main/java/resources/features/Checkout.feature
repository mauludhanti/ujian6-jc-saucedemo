Feature: Checkout Feature

  Scenario: Successful checkout
    Given I have items in my cart
    When I proceed to checkout
    And I enter my shipping details
    And I complete the purchase
    Then I should see the order confirmation page

  Scenario: Checkout without items
    Given I have no items in my cart
    When I proceed to checkout
    Then I should see an error message
