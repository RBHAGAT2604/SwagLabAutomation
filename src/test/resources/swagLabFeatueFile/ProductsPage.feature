Feature: This feature file contains Products Page test cases for the Swaglab

Background:
    Given User is logged into the Swag Labs application

Scenario:  add products to cart
			
				When  add Sauce Labs Backpack to the cart
				And   add Sauce Labs Bike Light to the cart
				And   clicks on the cart icon
				Then  User should be redirected to the cart page