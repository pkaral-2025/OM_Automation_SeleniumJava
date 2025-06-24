Feature: Creation of cases

 @regression @creationOfICase
  Scenario: Successful creation of Intake - I case
    Given the user navigates to login page
    When user enters email as "AutoTestUser" and password as "Apriajan@2025"
    Given I click on the "login_btn" button
  	
  	Given user refresh page and serach element 
  	Given user wait for jscript 10 seconds

  	Given I click on the "plusicon_btn" button
  	Given I click on the "intake_btn" button
  	Given user wait for jscript 5 seconds
  
  	When user enters LastName as "QA"
  	When user enters FirstName as "TEST"
  	When user enters ZipCode as "25313"
		Given user wait for jscript 5 seconds
		When I retrieve the value from the page
  	Given I click on the "search_btn" button
   	Given I click on the "NewPatient_chkbx" button
    When I select the option "New Order" from the dropdown with id "CaseType_dropdwn"
   	Given I click on the "Submit_btn" button
   		Given user wait for jscript 5 seconds
   	When I select the option "Walk-In Customer" from the dropdown with id "OrderType_dropdwn"
   	Given user wait for 10 seconds
   	
   	Given I click on the "ReferralSearch_btn" button
   	When user enters ReferralId as "*aaa01"
   	Given I click on the "ReferralLayoutSearch_btn" button
   	Given I click on the "ReferralLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   		
   	Given user wait for 5 seconds
   	Given I click on the "PayorSearch_btn" button
   	When user enters PayorName as "humana"
 		Given I click on the "PayorLayoutSearch_btn" button
 		Given I click on the "PayorLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   	Given user wait for 5 seconds
   	
   #	Given I click on the "AdditionalInsuranceInfo_btn" button
   	When user enters PatientInsuranceID as "H12345678"
   	Given user wait for 5 seconds
   	
   	
   	When I select the option "Cofflator" from the dropdown with id "AddProd_dropdwn"
   	Given I click on the "AddProd_btn" button
   	When I select the option "Accept" from the dropdown with id "Decision_dropdwn"
   	   
   	
   	Given user wait for 10 seconds
   	When user enters DOB as "*11/13/1988"
    Given user wait for 10 seconds
    When user enters PrimaryPhone as "1234567890"
   	When I select the option "Male" from the dropdown with id "Gender_dropdwn"
   	Given user wait for 5 seconds
   	When user enters OrderByName as "Test"
   	When user enters OrderByPhoneNo as "1234567890"
   		 	
   	Given user wait for 10 seconds
   	Given user click on "InitialOutreachCallsRadiobtn_No" button with javascript
   		Given user wait for 5 seconds
   	Given user click on Send Fax Radio "SendFaxReceiptToReferralRadio_btn" button with javascript
   	
   	Given user wait for 5 seconds
    Given I click on the "Save_btn" button
    When I retrieve the value from the page
   	Given user wait for 10 seconds
   	Given I click on the "Submit_btn" button
   
   	Given I click on the "Next_btn" button
    Given user wait for 10 seconds
    Given I click on the "Submit_btn" button
    Given user wait for jscript 10 seconds
  	Given I click on the "plusicon_btn" button
    Given I click on the "titleIcon_btn" button
		Given I click on the "LogOff_btn" button
		Given user wait for 10 seconds


 @regression @creationOfFCase
  Scenario: Successful creation of F case
  	Given the user navigates to login page
    When user enters email as "AutoTestUser" and password as "Apriajan@2025"
    Given I click on the "login_btn" button
  	
  	Given user refresh page and serach element 
  	Given user wait for jscript 10 seconds

  	Given I click on the "plusicon_btn" button
  	Given I click on the "intake_btn" button
  	Given user wait for jscript 5 seconds
  
  	When user enters LastName as "QA"
  	When user enters FirstName as "TEST"
  	When user enters ZipCode as "25313"
		Given user wait for jscript 5 seconds
		When I retrieve the value from the page
  	Given I click on the "search_btn" button
   	Given I click on the "NewPatient_chkbx" button
    When I select the option "New Order" from the dropdown with id "CaseType_dropdwn"
   	Given I click on the "Submit_btn" button
   	Given user wait for jscript 5 seconds
   	When I select the option "Walk-In Customer" from the dropdown with id "OrderType_dropdwn"
   	
   	Given user wait for 10 seconds
   	Given I click on the "ReferralSearch_btn" button
   	When user enters ReferralId as "*aaa01"
   	Given I click on the "ReferralLayoutSearch_btn" button
   	Given I click on the "ReferralLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   		
   	Given user wait for 5 seconds
   	Given I click on the "PayorSearch_btn" button
   	When user enters PayorName as "humana"
 		Given I click on the "PayorLayoutSearch_btn" button
 		Given I click on the "PayorLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   	Given user wait for 10 seconds
   	
 #		Given I click on the "AdditionalInsuranceInfo_btn" button
   	When user enters PatientInsuranceID as "H12345678"
   	Given user wait for 5 seconds
   	
   	When I select the option "Cofflator" from the dropdown with id "AddProd_dropdwn"
   	Given I click on the "AddProd_btn" button
   	When I select the option "Accept" from the dropdown with id "Decision_dropdwn"
   	 	Given user wait for 5 seconds
  Given user click on Send Fax Radio "SendFaxReceiptToReferralRadio_btn" button with javascript
   	
   	Given user wait for 10 seconds
   	When user enters DOB as "*11/13/1988"
    Given user wait for 10 seconds
    When user enters PrimaryPhone as "1234567890"
   	When I select the option "Male" from the dropdown with id "Gender_dropdwn"
   	Given user wait for 5 seconds
   	When user enters OrderByName as "Test"
   	When user enters OrderByPhoneNo as "1234567890"
   		 	
   	Given user wait for 10 seconds
   	Given user click on "InitialOutreachCallsRadiobtn_No" button with javascript
   	Given user wait for 10 seconds
    Given I click on the "Save_btn" button
    When I retrieve the value from the page
   	Given user wait for 10 seconds
   	Given I click on the "Submit_btn" button
    Given user wait for 10 seconds
    Given I click on the "Submit_btn" button
    Given user wait for 10 seconds
    When user enters ACISPatientID as "ARS123"
    When user enters BranchUser as "RGACIS"
    When user enters Intake as "11"
    Given I click on the "Submit_btn" button
  
 		Given user wait for jscript 10 seconds
  	Given I click on the "plusicon_btn" button
    Given I click on the "titleIcon_btn" button
		Given I click on the "LogOff_btn" button
		Given user wait for 10 seconds


 @regression @creationOfQCase
  Scenario: Successful creation of Q case
  Given the user navigates to login page
    When user enters email as "AutoTestUser" and password as "Apriajan@2025"
    Given I click on the "login_btn" button
  	
  	Given user refresh page and serach element 
  	Given user wait for 5 seconds
  	Given user wait for jscript 10 seconds

  	Given I click on the "plusicon_btn" button
  	Given I click on the "intake_btn" button
  	Given user wait for jscript 5 seconds
  
  	When user enters LastName as "QA"
  	When user enters FirstName as "TEST"
  	When user enters ZipCode as "25313"
		Given user wait for jscript 5 seconds
		When I retrieve the value from the page
  	Given I click on the "search_btn" button
   	Given I click on the "NewPatient_chkbx" button
    When I select the option "New Order" from the dropdown with id "CaseType_dropdwn"
   	Given I click on the "Submit_btn" button
   		Given user wait for jscript 5 seconds
   	When I select the option "Walk-In Customer" from the dropdown with id "OrderType_dropdwn"
   	
   		Given user wait for 5 seconds
   	Given I click on the "ReferralSearch_btn" button
   	When user enters ReferralId as "*aaa01"
   	Given I click on the "ReferralLayoutSearch_btn" button
   	Given I click on the "ReferralLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   		
   	Given user wait for 5 seconds
   	Given I click on the "PayorSearch_btn" button
   	When user enters PayorName as "humana"
 		Given I click on the "PayorLayoutSearch_btn" button
 		Given I click on the "PayorLayoutRadio_btn" button
   	Given I click on the "LayoutSubmit_btn" button
   		   	Given user wait for 5 seconds
   		
   #		Given I click on the "AdditionalInsuranceInfo_btn" button
    	When user enters PatientInsuranceID as "H12345678"
   Given user wait for 5 seconds
   
   	When I select the option "Cofflator" from the dropdown with id "AddProd_dropdwn"
   	Given I click on the "AddProd_btn" button
   	When I select the option "Accept" from the dropdown with id "Decision_dropdwn"
   	Given user wait for 5 seconds
     	Given user click on Send Fax Radio "SendFaxReceiptToReferralRadio_btn" button with javascript
   	Given user wait for 5 seconds
   	
   	Given user wait for 5 seconds
   	When user enters DOB as "*11/13/1988"
    Given user wait for 5 seconds
    When user enters PrimaryPhone as "1234567890"
   	When I select the option "Male" from the dropdown with id "Gender_dropdwn"
   	Given user wait for 5 seconds
   	When user enters OrderByName as "Test"
   	When user enters OrderByPhoneNo as "1234567890"
   	Given user wait for 5 seconds
		Given user click on "InitialOutreachCallsRadiobtn_No" button with javascript
   	Given user wait for 5 seconds
   	
   	
    Given I click on the "Save_btn" button
    When I retrieve the value from the page
   	Given user wait for 5 seconds
  	Given I click on the "Submit_btn" button
    Given user wait for 5 seconds
    Given I click on the "Submit_btn" button
    
    Given user wait for 5 seconds
    When user enters ACISPatientID as "ARS123"
    When user enters BranchUser as "RGACIS"
    When user enters Intake as "11"
    Given I click on the "Submit_btn" button
   	Given user wait for 5 seconds
   	Given I click on the "CaseHirarchy_btn" button
   	Given user wait for 10 seconds
		Given I click on the "Action_btn" button
 		Given user wait for 5 seconds
  	Given I click on the "ActionRefresh_btn" button
  	Given user wait for 5 seconds
 		Given I click on the "CaseHirarchy_btn" button
 		Given user wait for 5 seconds
 		
		Given I click on the "QCase_btn" button
		Given user wait for 5 seconds
		When I retrieve the value from the page
		Given I click on the "Go_btn" button
		Given user wait for 10 seconds
			
		Given I click on the "Benefit_Information_btn" button
		Given user wait for 5 seconds
		Then user enters Group number as "123"
		Then user enters InsuranceCoveragePercentage as "11"
		When user enters DeductibleMaxField as "11"
		When user enters DeductibleMetField as "11"
		Given user wait for 5 seconds
		Given user click on Benefit Information "RelationshipToInsuredRadio_btn" button with javascript
		Given I click on the "ModalSubmit_btn" button
		Given user wait for 5 seconds
		
		When I retrieve the value from the page
		Given I click on the "Submit_btn" button
		Given user wait for 10 seconds
				Given user wait for 10 seconds
			
			
#	 #		When the user clicks the "DiagnosisCode" button
    #And the user enters "J44.9" in the popup search field and clicks search
    #And the user selects the diagnosis code from the list and submits
 #	 #	Given the user switches back to the main window
    #Then the selected code "J44.9" should be displayed in the main window text field

		#And the user manually sets the diagnosis code to "J44.9"


#		Given user wait for 10 seconds
		
		Given I click on the "PhysicianSearch_btn" button	
		When user enters PhysicianName as "DAVID"
 		Given I click on the "PhysicianLayoutSearch_btn" button
 		Given I click on the "PhysicianLayoutRadio_btn" button
 	  Given I click on the "ModalSubmit_btn" button	
 	  Given user wait for 5 seconds
 	  
 	  When I select the option "Continue to AQG" from the dropdown with id "CaseProcessAction_dropdwn"
 	  Given I click on the "Submit_btn" button
 	  Given user wait for 5 seconds
 	  When user enters HCPC as "E0482"
 	  When user enters If_supply_what_is_base_HCPC as "E0601"
		Given user wait for 5 seconds
		
 	  When I select the option "Initial Rental" from the dropdown with id "IfSupplyWhatIsTheBaseHCPCStatus_dropdwn"
 	  Given I click on the "LaunchPayorQualification_btn" button 
 	  
 	  Given user wait for 10 seconds
 	  When I select the option "Changing Transaction Type" from the dropdown with id "SelectActionWillBeTakenToResolve_dropdwn"
 	  Given user wait for 5 seconds
 	  Given I click on the "FormRequirements_btn" button 
    When I select the option "Continue to Forms Determination" from the dropdown with id "CaseProcessAction_dropdwn"
    Given I click on the "Submit_btn" button
    Given user wait for 5 seconds
    When I select the option "Requested" from the dropdown with id "Status_dropdwn"
    When I select the option "Schedule Delivery" from the dropdown with id "CaseProcessAction_dropdwn"
    Given I click on the "Submit_btn" button
    Given user wait for 10 seconds
    Then user should see "Thank you! The next step in this case has been routed appropriately."
     
    Given user wait for jscript 10 seconds
  	Given I click on the "plusicon_btn" button
    Given I click on the "titleIcon_btn" button
		Given I click on the "LogOff_btn" button
		Given user wait for 10 seconds
     
