Feature: Verify Add to Cart feature

	@test
  Scenario Outline: Add various dresses to the cart and verify their prices on Add to Cart page
    Given I go to url "http://automationpractice.com/index.php"
    When I add to the cart dress1 <DressType1> size <Size1>
    And I add to the cart dress2 <DressType2> size <Size2>
    And I add to the cart dress3 <DressType3> size <Size3>
    And I perform checkout 
    And I remove the evening dress from the cart 
    And I add second dress1 to the cart <DressType1> size <Size1>
    And I perform checkout 
    Then I assert the total for each line in the cart 
    And I assert the cart total
		Examples:
			|DressType1|Size1|DressType2|Size2|DressType3|Size3|
			|Faded Short Sleeve T Shirt|1|Evening Dress|0|Printed Summer Dress|1|