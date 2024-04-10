Feature: Wishlist Section in Udemy App
	
	#Testing Wishlist section's add functionality
	@add_wishlist
  Scenario: User adds a course to the wishlist
    Given the user is logged into the Udemy app
    And the user is on the course page
    When the user clicks on the Add to Wishlist button
    Then the course should be added to the user wishlist
	
	#Testing Wishlist UI
	@ui_wishlist
  Scenario: User views the wishlist
    Given the user is on the homepage
    When the user navigates to the wishlist section
    Then the user should see a list of courses added to the wishlist
    And each course should display its title, and price
	
	#Testing Wishlist section's remove functionality
	@remove_wishlist
  Scenario: User removes a course from the wishlist
    Given the user is on the Udemy homepage
    And the user is on the wishlist page
    And the wishlist contains at least one course
    When the user clicks on the wishlisted button in the course
    Then the course should be removed from the wishlist
  
  #Testing Add to Cart functionality from Wishlist page
  @addToCart 
  Scenario: User tries to add an already added course to the wishlist
	  Given the user is on the Udemy homepage
	  And the user is on the wishlist page
	  When the user clicks on the course
	  And the user clicks on add to cart button
	  Then the product should be added to cart
	
	#Testing addition of course to wishlist from search results
	@add_fromSearch
  Scenario Outline: User adds a course to the wishlist from search results
    Given the user is on the Udemy homepage
    And the user is on the search results page
    And the search results contain courses related to "<search_keyword>"
    When the user clicks on the Add to Wishlist button next to a course
    Then the course should be added to the users wishlist

    Examples:
      |   search_keyword   |
      |   Python           |
      |   Machine Learning |
