
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @ErrorVal
  Scenario Outline: Title of your scenario outline
    Given On Ecommerce page
    When Logged in with <name>and <pass>
    Then "Incorrect email or password." appears

    Examples: 
      | email                     | password       |
      | email20chgcvh01@gmail.com | Ess2001aitch00 |
