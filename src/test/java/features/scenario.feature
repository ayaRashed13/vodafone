Feature: Add items to the cart
  As a user, I want to add items to the cart so that I can purchase them later.

  Scenario: Add three items to the cart
    Given The Home page is loaded
    When Adding 3 Items to the cart
    Then Items should be added to the cart
