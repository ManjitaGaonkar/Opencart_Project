Feature: Community Forum Page

Scenario Outline: Verify community forum search functionality with valid data
		Given Chrome is opened and opencart app is opened
		Then User navigates onto landing page and able to see logo
		When User clicks on resources dropdown
		And User clicks on community forum
		Then User navigates on community forum page
		Then User click on dropdown list of search button and select Unanswered topics option
		When User fills the data from given sheetname "<SheetName>" and rownumber <RowNumber>
		And clicks on search icon 
		Then User is able to see all the related topics
		
		Examples:
		| SheetName | RowNumber |
		| Sheet1    |    0      |
		| Sheet1    |    1      |