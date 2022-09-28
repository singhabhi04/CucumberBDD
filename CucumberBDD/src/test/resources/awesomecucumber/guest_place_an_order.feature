Feature: Place an order

  Scenario: using default payment option
    Given I am a guest Customer
    And my billing details are
      | firstname | lastname | country           | address_line1      | city  | state      | zip   | email                   |
      | Demo      | User     | United States(US) | 151 Framington Av. | Texas | California | 12345 | abhishek.topa@gmail.com |
    And I have a product in cart
    And I am on the checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed sucessfully
