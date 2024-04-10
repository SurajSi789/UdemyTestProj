Feature: Udemy Search Module
	
	#Testing search functionality by adding valid keywords
	@positive_testing
  Scenario: User searches for a course by entering keywords
    Given the user is on the Udemy homepage
    When the user enters coursename in the search bar
    | Automation Testing |
    And the user clicks the search button
    Then the search results page should be displayed
	
	#Testing filters options
	@filters
  Scenario: User filters search results by category
    Given the user is on the Udemy search results page
    When the user selects "Free" category from the filters
    And the user applies the filter
    Then the search results should only display courses related to software development
	
	#Testing the sort functionality
	@sort
  Scenario: User sorts search results by relevance
    Given the user is on the Udemy search results page
    When the user selects ratings from the sorting options
    And the user applies the sorting option
    Then the search results should be sorted based on relevance
	
	#Testing navigation to course page from search results
	@navigation_course
  Scenario: User navigates to a course page from search results
    Given the user is on the Udemy search results page
    When the user clicks on a course from the search results
    Then the user should be redirected to the course page
    And the course details should be displayed accurately
	
	#Negative testing with invalid keywords
	@negative_testing
  Scenario Outline: User performs negative search with invalid keywords
  Given the user is on the Udemy homepage
  When the user enters "<invalid_keyword>" in the search bar
  And the user clicks the search icon
  Then the search results page should display a message indicating no results found

  Examples:
    | invalid_keyword |
    | gyt             |
    | invalidword     |
  