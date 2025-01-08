Feature: Creation of cases

 @regression @creationOfICase
  Scenario: Successful creation of Intake - I case
    Given the user navigates to login page
    When user enters email as "PKARALKA" and password as "Apriajul@2024"
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
   #	Given I click on the "NoChargeServiceRadio_btn" button
   		 
   #		 	When user enters StreetAddress as "Add1"
     #		 	When I select the option "Walk-In" from the dropdown with id "SaveCloseReason_dropdwn"
     	Given I click on the "Save_btn" button
     	   When I retrieve the value from the page
     	Given user wait for 10 seconds
   	 	Given I click on the "Submit_btn" button
   	 		 	Given I click on the "Next_btn" button
 
    		 	
  #	Given I click on the "logoff_btn" button
  #	When user select the checkbox with id "agreeTerms"
  #	Given I click on the "logoff_btn" button
  #	When user refresh the page
#


#
 #@regression @creationOfQCase
  #Scenario: Successful creation of Q case
    #Given the user navigates to login page
    #When user enters email as "PKARALKA" and password as "Apriajul@2024"
  #	Given I click on the "login_btn" button
  #	
  #	Given user refresh page and serach element 
  #	   When I hover over the "Home" element
  #	Given user wait for jscript 10 seconds
#
  #	Given I click on the "plusicon_btn" button
  #	Given I click on the "intake_btn" button
  #	
  #		Given user wait for 10 seconds
  #			When I retrieve the value from the page
  #	When user enters LastName as "QA"
  #	When user enters FirstName as "TEST"
  #	When user enters ZipCode as "25313"
  #	When the user enters data for the "<Last name>" field
       #
  #	Given I click on the "search_btn" button
   #	Given I click on the "NewPatient_chkbx" button
   #	
    #When I select the option "New Order" from the dropdown with id "CaseType_dropdwn"
   #	Given I click on the "Submit_btn" button
   #	When I select the option "Walk-In Customer" from the dropdown with id "OrderType_dropdwn"
   #	
   #	Given I click on the "ReferralSearch_btn" button
   #	When user enters ReferralId as "*aaa01"
   #	Given I click on the "ReferralLayoutSearch_btn" button
   #	Given I click on the "ReferralLayoutRadio_btn" button
   #	Given I click on the "LayoutSubmit_btn" button
   #		
   #		Given user wait for 5 seconds
   #	Given I click on the "PayorSearch_btn" button
   #	When user enters PayorName as "humana"
 #		Given I click on the "PayorLayoutSearch_btn" button
 #		Given I click on the "PayorLayoutRadio_btn" button
   #	Given I click on the "LayoutSubmit_btn" button
   #		
   #			Given user wait for 10 seconds
   #	When I select the option "Cofflator" from the dropdown with id "AddProd_dropdwn"
   #	Given I click on the "AddProd_btn" button
   #	When I select the option "Accept" from the dropdown with id "Decision_dropdwn"
   #	
   #		Given user wait for 10 seconds
   #	 When user enters DOB as "*11/13/1988"
    #	Given user wait for 10 seconds
     #	When user enters PrimaryPhone as "1234567890"
   #	 	When I select the option "Male" from the dropdown with id "Gender_dropdwn"
   #	 			Given user wait for 5 seconds
   #	 	When user enters OrderByName as "Test"
   #	 	When user enters OrderByPhoneNo as "1234567890"
   #	 		Given user wait for 10 seconds
   #	 			Given I click on the "NoChargeServiceRadio_btn" button
   #		 	Given I click on the "InitialOutreachCallsRadio_btn" button
   #		Given user wait for 10 seconds
     #	Given I click on the "Save_btn" button
     #	When I retrieve the value from the page
     #	Given user wait for 10 seconds
   #	 	Given I click on the "Submit_btn" button
   #	 	
   #		Given user wait for 10 seconds
   #		   	 	Given I click on the "Submit_btn" button
   #	 	When user enters ACISPatientID as "ARS123"
  #	When user enters BranchUser as "RGACIS"
#
#
#
#
#
#
