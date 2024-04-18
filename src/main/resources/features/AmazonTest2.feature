Feature: Shopping for a monitor on Amazon


  @MultipleProductInCart
  Scenario Outline: : Add a multiple product to the cart and verify price consistency
    Given I open Amazon.com
    When I type "<ProductName1>" in the search field and press enter
    And I select the <ItemNumber1> item in the list
    And I add the <ItemNumber1> item to the cart by clicking on Add to Cart
    And I type "<ProductName2>" in the search field and press enter
    And I select the <ItemNumber2> item in the list
    And I add the <ItemNumber2> item to the cart by clicking on Add to Cart
    And I open the cart from the top-left
    Then I verify that the price is identical to the product page
    And I verify that the subtotal is identical to the product page

    Examples: 
      | ProductName1 | ProductName2 | ItemNumber1 | ItemNumber2 |
      | Headphones   | Keyboard     |           1 |           1 |
