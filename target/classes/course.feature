Feature: Course Management for Students on Udemy
	
	#Testing browse courses section
	@browse
  Scenario: Browse Courses
    Given I am logged in as a student on Udemy
    When I navigate to the course catalog
    Then I should see a list of available courses
    And I should be able to browse through different categories and topics
	
	#Testing enroll functionality
	@enroll
  Scenario: Enroll in a Course
    Given I am on course category page
    When I find a free course I am interested in
    And I click on the course title to view its details
    And I click on the enroll Now button
    Then I should be successfully enrolled in the course
    And I should have access to the course content and resources
	
	#Testing Course content UI
	@course_content
  Scenario: View Course Content
    Given I am on mylearning page
    When I navigate to a course I have enrolled in
    Then I should see a list of course modules and lectures
    And I should be able to view the lecture videos, documents, quizzes, etc.
	
	#Testing course tracking functionality
	@course_tracking
  Scenario: Track Course Progress
    Given I am back to mylearning page
    When I am viewing a course I have enrolled in
    Then I should see my progress through the course
    And I should be able to mark lectures as completed
	
	#Testing review functionality
	@review
  Scenario: Leave a note for a Course
    Given I am on the course watch page
    When I click on more section
    And I click on note tab
    And I click on add button
    And I leave a note "<note>"
    And I click on the Submit note button
    Then my note should be successfully submitted
    
  Examples:
  | note |
  | Very informative course |
  | Well structured course |