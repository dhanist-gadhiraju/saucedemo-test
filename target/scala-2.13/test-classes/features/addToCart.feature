@test

  Feature:
    As a User
    I want to add the highest priced item to cart
    so that I can see my item

    Scenario: Login and add highest price item to the cart without using sort functionality

      Given I launch the saucedemo site
      And I login with valid credentials
      When I click on Add to cart button on highest priced product
      Then the product should be added to cart
      When I click on cart icon
      Then I should see the following product in cart page
        | Item label               | Price |
        | Sauce Labs Fleece Jacket | 49.99 |
