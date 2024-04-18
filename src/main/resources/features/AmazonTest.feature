Feature: Shopping for a monitor on Amazon

  @SingleProductInCart
  Scenario Outline: : Add a single Iteam to the cart and verify price consistency
    Given I open Amazon.com
    When I type "<ProductName>" in the search field and press enter
    And I select the <ItemNumber> item in the list
    And I add the <ItemNumber> item to the cart by clicking on Add to Cart
    And I open the cart from the top-left
    Then I verify that the price is identical to the product page
    And I verify that the subtotal is identical to the product page

    Examples: 
      | ProductName | ItemNumber |
      | Monitor     |          1 |
      | Laptop      |          1 |

  