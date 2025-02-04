package pageObjects;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	static Properties p;

	public LoginPage(WebDriver driver) {
		super(driver);

//		this.p;

	}

	@FindBy(xpath = "//input[@name='UserIdentifier']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//div[@id='submit_row']//button[@class='loginButton']")
	WebElement btnLogin;

	@FindBy(xpath = "//div[@data-tour-id='cm-create-case-menu']//span[@class='menu-item-image-wrapper'][1]")
	WebElement plusicon;

	@FindBy(xpath = "//label[@class='field-caption dataLabelForWrite icon-required ' and contains(text(),'Last name')]//following::input[1]")
	WebElement txtLastName;

	@FindBy(xpath = "//label[@class='field-caption dataLabelForWrite icon-required ' and contains(text(),'First name')]//following::input[1]")
	WebElement txtFirstName;

	@FindBy(xpath = "//label[@class='field-caption dataLabelForWrite icon-required ' and contains(text(),'First name')]//following::input[2]")
	WebElement txtZipCode;
	
	@FindBy(xpath = "//label[contains(text(),'Referral Id')]//following::input[1]")
	WebElement txtReferralId;
	
	@FindBy(xpath = "//label[contains(text(),'Payor Name')]//following::input[1]")
	WebElement txtPayorName;
	
	@FindBy(xpath = "//label[contains(text(),'Date of birth')]//following::input[1]")
	WebElement txtDOB;

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void setLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}

	public void setFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}

	public void setZipCode(String zipcode) {
		txtZipCode.sendKeys(zipcode);
	}

	public void setReferralId(String referralId) {
		txtReferralId.sendKeys(referralId);
	}
	
	public void setPayorName(String referralId) {
		txtPayorName.sendKeys(referralId);
	}
	
	public void setDOB(String dob) {
		txtDOB.sendKeys(dob);
	}
	
	
	@FindBy(xpath = "//label[contains(text(),'Primary Phone')]//following::input[1]")
	WebElement txtPrimaryPhone;
	public void setPrimaryPhone(String primaryPhone) {
		txtPrimaryPhone.sendKeys(primaryPhone);
	}
	
	@FindBy(xpath = "//label[contains(text(),'Secondary Phone')]//preceding::input[8]")
	WebElement txtStreetAddress;
	public void setStreetAddress(String streetAddress) {
		txtStreetAddress.sendKeys(streetAddress);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Ordered By')]//following::input[1]")
	WebElement txtsetOrderByName;
	public void setOrderByName(String orderByName) {
		txtsetOrderByName.sendKeys(orderByName);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Ordered By')]//following::input[2]")
	WebElement txtOrderByPhoneNo;
	public void setOrderByPhoneNo(String orderByPhoneNo) {
		txtOrderByPhoneNo.sendKeys(orderByPhoneNo);
	}
	
	@FindBy(xpath = "//label[contains(text(),'ACIS Patient ID')]//following::input[1]")
	WebElement txtACISPatientID;
	public void setACISPatientID(String ACISPatientID) {
		txtACISPatientID.sendKeys(ACISPatientID);
	}
	
	@FindBy(xpath = "//label[contains(text(),'Branch User')]//following::input[1]")
	WebElement txtBranchUser;
	public void setBranchUser(String BranchUser) {
		txtBranchUser.sendKeys(BranchUser);
	}
	
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pRoboticAutomation_AcceptedIntakeNumber']")
	WebElement txtIntake;
	public void setIntake(String Intake) {
		txtIntake.sendKeys(Intake);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pPrePrimaryPayorBenefitInformation$pPrimary_Insurance_Group']")
	WebElement txtGroupNumber;
	public void setGroupNumber(String GroupNumber) {
		txtGroupNumber.sendKeys(GroupNumber);
	}
	
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pSpokeWith']")
	WebElement txtSpokeWithField;
	public void setSpokeWithField(String SpokeWithField) {
		txtSpokeWithField.sendKeys(SpokeWithField);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pPrePrimaryPayorBenefitInformation$pInsuranceCoveragePercentage']")
	WebElement txtInsuranceCoveragePercentage;
	public void setInsuranceCoveragePercentage(String InsuranceCoveragePercentage) {
		txtInsuranceCoveragePercentage.sendKeys(InsuranceCoveragePercentage);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pPrePrimaryPayorBenefitInformation$pDeductibleMax']")
	WebElement txtDeductibleMax;
	public void setDeductibleMax(String DeductibleMax) {
		txtDeductibleMax.sendKeys(DeductibleMax);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pPrePrimaryPayorBenefitInformation$pDeductibleMet']")
	WebElement txtDeductibleMet;
	public void setDeductibleMet(String DeductibleMet) {
		txtDeductibleMet.sendKeys(DeductibleMet);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pDiagnosisSearchCode']")
	WebElement txtICDCode;
	public void setICDCode(String ICDCode) {
		txtICDCode.sendKeys(ICDCode);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pPhysicianSearchName']")
	WebElement txtPhysicianName;
	public void setPhysicianName(String PhysicianName) {
		txtPhysicianName.sendKeys(PhysicianName);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pProductAcceptInfo$l1$phcpc']")
	WebElement txtHCPC;
	public void setHCPC(String HCPC) {
		txtHCPC.sendKeys(HCPC);
	}
	
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pProductAcceptInfo$l1$pBaseHCPC']")
	WebElement txtIfSupplyWhatIsbaseHCPC;
	public void setIfSupplyWhatIsbaseHCPC(String IfSupplyWhatIsbaseHCPC) {
		txtIfSupplyWhatIsbaseHCPC.sendKeys(IfSupplyWhatIsbaseHCPC);
	}
	
	
	// Method to read locators from config file
	public static Properties getLocator(String fieldName) throws IOException {

		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		return p;

	}
	// Method to read locators from config file

	// ------------------enter data into field--------------

	public String getExcelData(String Sheet2, int rowNum, int cellNum) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(Sheet2);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		String cellValue = cell.getStringCellValue();
		workbook.close();
		return cellValue;
	}
	// ------------------enter data into field--------------

}
