Feature: Add to Cart

	Scenario Outline: Add one quantity to the Cart
	
		Given I am on the Store page
		When I add a "<product_name>" to the Cart
		Then I see 1 "<product_name>" in the Cart
		Examples:
		|product_name|
		|Blue Shoes|