Feature: E2E Purchase Flow

  Scenario: Complete purchase flow
    Given the user logs in with valid credentials
    When the user adds two products to the cart and completes the checkout form
    Then the user should see "Thank you for your order!"