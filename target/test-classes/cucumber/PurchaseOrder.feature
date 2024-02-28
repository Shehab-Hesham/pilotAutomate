
@tag
Feature: Purchase order from ecommerce website
  I want to use this template for my feature file

	Background:
	Given Land on Ecommerce homepage

  @Correct
  Scenario Outline: Positive order placement
    Given Logged in with username <email> and password <password>
    When I add product <prodName> to cart
    And checkout <prodName> and submit country <country>
    Then "THANKYOU FOR THE ORDER." is displayed

    Examples: 
      | email               | password     | prodName      | country |
      | email2001@gmail.com | Ess2001aitch | IPHONE 13 PRO | Egypt   |
