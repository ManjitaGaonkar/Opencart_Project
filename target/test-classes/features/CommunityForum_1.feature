Feature: Community Forum Page

Scenario: Validate user navigates to community forum page
		Given Chrome is opened and opencart app is opened
		Then User navigates onto landing page and able to see logo
		When User clicks on resources dropdown
		And User clicks on community forum
		Then User navigates on community forum page

 
Scenario: Validate community forum page UI
		Given Chrome is opened and opencart app is opened
		Then User navigates onto landing page and able to see logo
		When User clicks on resources dropdown
		And User clicks on community forum
		Then User navigates on community forum page and see text
		
		
Scenario: Validate community forum page functionality
		Given Chrome is opened and opencart app is opened
		Then User navigates onto landing page and able to see logo
		When User clicks on resources dropdown
		And User clicks on community forum
		Then User navigates on community forum page
		Then User click on dropdown list of search button and select Unanswered topics option