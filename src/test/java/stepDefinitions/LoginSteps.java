package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pageObjects.ConfigFilefile;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	WebDriverWait wait;
//	ConfigFilefile configread;

	List<HashMap<String, String>> datamap; // Data driven

	Properties p;

	@Given("the user navigates to login page")
	public void user_navigate_to_login_page() {

		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		hp = new HomePage(BaseClass.getDriver());

//    	hp.clickMyAccount();
//    	hp.clickLogin();

	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		BaseClass.getLogger().info("Entering email and password.. ");

		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
	}

	@When("user enters LastName as {string}")
	public void user_enters_LastName_as(String lastname) {
		BaseClass.getLogger().info("Entering Last name.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setLastName(lastname);

	}

	@When("user enters FirstName as {string}")
	public void user_enters_FirstName_as(String firstname) {
		BaseClass.getLogger().info("Entering First name.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setFirstName(firstname);

	}

	@When("user enters ZipCode as {string}")
	public void user_enters_ZipCode_as(String zipcode) {
		BaseClass.getLogger().info("Entering Zipcode.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setZipCode(zipcode);

	}

	@When("user enters ReferralId as {string}")
	public void user_enters_ReferralId_as(String referralid) {
		BaseClass.getLogger().info("Entering ReferralId.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setReferralId(referralid);

	}

	@When("user enters DOB as {string}")
	public void user_enters_DOB_as(String dob) {
		BaseClass.getLogger().info("Entering DOB.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setDOB(dob);

	}

	@When("user enters PrimaryPhone as {string}")
	public void user_enters_primaryPhone_as(String primaryPhone) {
		BaseClass.getLogger().info("Entering primaryPhone.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setPrimaryPhone(primaryPhone);

	}

	@When("user enters PayorName as {string}")
	public void user_enters_PayorName_as(String payorname) {
		BaseClass.getLogger().info("Entering PayorName.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setPayorName(payorname);

	}

	@When("user enters StreetAddress as {string}")
	public void user_enters_StreetAddress_as(String streetAddress) {
		BaseClass.getLogger().info("Entering streetAddress.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setStreetAddress(streetAddress);

	}

	@When("user enters OrderByName as {string}")
	public void user_enters_OrderByName_as(String orderByName) {
		BaseClass.getLogger().info("Entering streetAddress.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setOrderByName(orderByName);

	}

	@When("user enters OrderByPhoneNo as {string}")
	public void user_enters_OrderByPhoneNo_as(String orderByPhoneNo) {
		BaseClass.getLogger().info("Entering streetAddress.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setOrderByPhoneNo(orderByPhoneNo);

	}

	@When("user enters ACISPatientID as {string}")
	public void user_enters_ACISPatientID_as(String ACISPatientID) {
		BaseClass.getLogger().info("Entering ACISPatientID.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setACISPatientID(ACISPatientID);

	}

	@When("user enters BranchUser as {string}")
	public void user_enters_BranchUser_as(String BranchUser) {
		BaseClass.getLogger().info("Entering BranchUser.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setBranchUser(BranchUser);

	}

	@When("user enters Group number as {string}")
	public void user_enters_GroupNumber_as(String GroupNumber) {
		BaseClass.getLogger().info("Entering GroupNumber.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setGroupNumber(GroupNumber);

	}

	@When("user enters Intake as {string}")
	public void user_enters_Intake_as(String Intake) {
		BaseClass.getLogger().info("Entering Intake.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setIntake(Intake);

	}

	@When("user enters SpokeWithField as {string}")
	public void user_enters_SpokeWithField_as(String SpokeWithField) {
		BaseClass.getLogger().info("Entering SpokeWithField.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setSpokeWithField(SpokeWithField);

	}

	@When("user enters InsuranceCoveragePercentage as {string}")
	public void user_enters_InsuranceCoveragePercentage_as(String InsuranceCoveragePercentage) {
		BaseClass.getLogger().info("Entering InsuranceCoveragePercentage.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setInsuranceCoveragePercentage(InsuranceCoveragePercentage);

	}

	@When("user enters DeductibleMaxField as {string}")
	public void user_enters_DeductibleMaxField_as(String DeductibleMax) {
		BaseClass.getLogger().info("Entering DeductibleMax.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setDeductibleMax(DeductibleMax);

	}

	@When("user enters DeductibleMetField as {string}")
	public void user_enters_DeductibleMet_as(String DeductibleMet) {
		BaseClass.getLogger().info("Entering DeductibleMet.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setDeductibleMet(DeductibleMet);

	}

	@When("user enters PhysicianName as {string}")
	public void user_enters_PhysicianName_as(String PhysicianName) {
		BaseClass.getLogger().info("Entering PhysicianName.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setPhysicianName(PhysicianName);

	}

	@When("user enters ICDCode as {string}")
	public void user_enters_ICDCode_as(String ICDCode) {
		BaseClass.getLogger().info("Entering ICDCode.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setICDCode(ICDCode);

	}

	@When("user enters HCPC as {string}")
	public void user_enters_HCPC_as(String HCPC) {
		BaseClass.getLogger().info("Entering HCPC.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setHCPC(HCPC);

	}

	@When("user enters If_supply_what_is_base_HCPC as {string}")
	public void user_enters_IfSupplyWhatIsbaseHCPC_as(String IfSupplyWhatIsbaseHCPC) {
		BaseClass.getLogger().info("Entering IfSupplyWhatIsbaseHCPC.. ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setIfSupplyWhatIsbaseHCPC(IfSupplyWhatIsbaseHCPC);

	}

//	@When("user enters OrderNotes as {string}")
//	public void user_enters_OrderNotes_as(String orderNotes) {
//		BaseClass.getLogger().info("Entering streetAddress.. ");
//		lp = new LoginPage(BaseClass.getDriver());
//		lp.setOrderNotes(orderNotes);
//
//	}

	@Given("I click on the {string} button")
	public void i_click_on_the_button(String buttonName) throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		BaseClass.clickButton(buttonName);

	}

	// ----------Mouseover----------------//
	@When("I hover over the {string} element")
	public void i_hover_over_the_element(String elementLocator) {
		// Find the element to hover over
		BaseClass.mouseOverOnEle();
	}

//    @When("I click the {string} button")
//    public void i_click_the_button(String loginButton) throws InterruptedException {
//       
//    	BaseClass.clickOnLoginButton(loginButton);
//    
//    }

	@Then("I should be navigated to the next page")
	public void i_should_be_navigated_to_the_next_page() {
		BaseClass.navigateToDashboard();
	}

	@When("the page is loaded")
	public void the_page_is_loaded() throws InterruptedException {
		// Wait for the page to load and refresh until elements are visible
		BaseClass.waitForPageLoad();
	}

	// dropdown
	@When("I select the option {string} from the dropdown with id {string}")
	public void select_option_from_dropdown(String option, String dropdownId) {

		BaseClass.select_option_from_dropdown(option, dropdownId);

	}

//----------------Date---------//
//	   @When("I select the date {string} from the calendar")
//	    public void i_select_the_date_from_the_calendar(String date) {
//	        // Call the method to select a date from the calendar
//	        BaseClass.selectDate(date);
//	    }

	// Step 1: Select the date (year, month, and day)
	@Given("I select the date {string}")
	public void select_Date(String fullDate) throws InterruptedException {

		BaseClass.iSelectTheDate(fullDate);

	}

	@When("user refresh the page")
	public void user_refresh_the_page() {
		driver.navigate().refresh();
	}

	// ------------------enter data into field--------------
	@When("the user enters data for the {string} field")
	public void enterDataForField(String fieldName) throws IOException {

		// Get locator for the field from the config file

//		String locator = lp.getLocator(fieldName); // // Get locator from config file

		String locator = p.getProperty(fieldName);
		// Get data for the field from the Excel file
		String data = lp.getExcelData("Sheet1", 1, 0);// Get data for the field from Excel (1st row, 1st column)

		// Locate the input field and enter the data
		WebElement inputField = driver.findElement(By.xpath(locator)); // Locate element using the dynamic locator

		inputField.clear(); // Clear any existing value
		inputField.sendKeys(data); // Enter the new data
	}

	// ------------------enter data into field--------------

	@Then("the user should be redirected to the ANA Workflow Page")
	public void user_navigates_to_my_account_page() {
		macc = new MyAccountPage(BaseClass.getDriver());
		boolean targetpage = macc.isMyAccountPageExists();

		Assert.assertEquals(targetpage, true);

	}

	// ---------checkbox-----------//
	@When("user select the checkbox with id {string}")
	public void select_checkbox(String checkboxId) {
		WebElement checkbox = driver.findElement(By.id(checkboxId));
		if (!checkbox.isSelected()) {
			checkbox.click(); // Click the checkbox if it's not already selected
		}
	}

	// ---------checkbox-----------//

	@Given("user wait for jscript {int} seconds")
	public void waitForPageToLoad(int seconds) throws InterruptedException {

		BaseClass.jsWaitForPageToLoad();

	}

	@Given("user refresh page and serach element")
	public void user_refresh_page_and_serach_element() throws InterruptedException {

		BaseClass.waitForPageLoad();
	}

	// =============Retrieve
	@When("I retrieve the value from the page")
	public void i_retrieve_the_value_from_the_page() {

		BaseClass.readValueFromPage();
	}

	// ---------------javascript click---------//
	@Given("user click on {string} button with javascript")
	public void click_on_btn_using_javascript(String radiobtn) {

		BaseClass.javascriptClick(radiobtn);
	}

	@Given("user click on Benefit Information {string} button with javascript")
	public void click_on_BenefitInformationRelationbtn_using_javascript(String radiobtn) {

		BaseClass.javascriptClickOnBenefitInformationRelationbtn(radiobtn);
	}

	@Given("user click on Daignosis ModalSubmit {string} button with javascript")
	public void click_on_ModalSubmit_btn_using_javascript(String btn) throws InterruptedException {

		BaseClass.javascriptClickOnDiagnosisModalSubmit_btn(btn);
	}

	@Then("user should see {string}")
	public void i_should_see(String expectedText) {

		BaseClass.validateText(expectedText);
		
	}

	// -----------wait--------//
	@Given("user wait for {int} seconds")
	public void WaitForSeconds(int seconds) throws InterruptedException {
		// Thread.sleep pauses the execution for the specified time (in milliseconds)
		Thread.sleep(seconds * 1000);
	}

	// ******* Data Driven test **************
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx", "Sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);

		lp.clickLogin();
		macc = new MyAccountPage(BaseClass.getDriver());
		try {
			boolean targetpage = macc.isMyAccountPageExists();
			System.out.println("target page: " + targetpage);
			if (exp_res.equals("Valid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(BaseClass.getDriver());
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp_res.equals("Invalid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

}
