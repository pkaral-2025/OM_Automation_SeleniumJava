package factory;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	static String WebElement;

	public static WebDriver initilizeBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS..");
			}
			// browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();

//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--start-maximized");
//				WebDriver driver = new ChromeDriver(options);

				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {

		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}

	public static void navigateToDashboard() {

		// Wait until the new page has loaded. You can modify this to check for a
		// specific element on the new page
		String expectedUrl = "https://apria-qa.pegacloud.net/prweb/app/ANA_/"; // Replace with the URL you expect after
																				// login
		assertTrue(driver.getCurrentUrl().equals(expectedUrl));

		// Or you can also check for the presence of an element on the new page
		WebElement dashboardElement = driver.findElement(By.xpath("//img[@name='PortalNavigation_pyPortalHarness_3']"));
		assertTrue(dashboardElement.isDisplayed());

	}

	// ------- button click ------12/10/24
	public static void clickButton(String buttonName) throws InterruptedException {

		// Get the XPath from config file using the button name
		String buttonXPath = p.getProperty(buttonName);
		try {
			// Find the button element and click it
			WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));

//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementOnNewPage")));

			button.click();

//			verify ANA workflow appear after login
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

////			WebElement userProfile = wait.until(
////					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'ANA Workflow')]")));
//			
//			WebElement userProfile = wait.until(
//					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content-item content-layout item-4 flex flex-row']//button")));
//			
//			
//			assert userProfile.isDisplayed();
//			System.out.println("Page navigated_" + userProfile);
			System.out.println("Clicked on button");

		}

		catch (TimeoutException e) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			System.out.println("Element was not found in time, retrying...");
		}
		Thread.sleep(500);
	}

	// -------javascript executor wait----------//
	public static void jsWaitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Wait until the readyState is complete
		while (!js.executeScript("return document.readyState").equals("complete")) {
			try {
				Thread.sleep(100); // Optional: wait for half a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Method to refresh the page until all elements load
	public static void waitForPageLoad() throws InterruptedException {
		WebDriverWait waitForPageLoad = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean allElementsLoaded = false;
		int refreshAttempts = 0;

		while (!allElementsLoaded && refreshAttempts < 5) {
			try {

				// overly-------
				WebElement overlay = driver.findElement(By.id("modalOverlay")); // Example overlay
				if (overlay.isDisplayed()) {
					// Close the overlay, or wait for it to disappear
					overlay.click(); // Or use a more specific action to dismiss the overlay
					System.out.println("Clicked on overlay");
				}

				// overly-------

				// mouseover---------
				WebElement element = driver.findElement(By.xpath(
						"//div[@onmouseover='pega.c.cbe.processHoverEvent(event)']//preceding::span[@class='menu-item-title' and contains(text(),'Home')]"));

				

				
				// Create Actions object
				Actions actions = new Actions(driver);

				// Perform mouse-over action (hover over)
				actions.moveToElement(element).perform();

				// Wait for key elements to load
//				waitForPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tour-id='cm-worker-primary-navigation']")));
				waitForPageLoad.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")))
						.click();
				System.out.println("Clicked on Home");
				Thread.sleep(1000);

				// If the elements are loaded, break the loop
				allElementsLoaded = true;
			} catch (Exception e) {
				// If elements are not found, refresh the page and try again
				System.out.println("Elements not found, refreshing the page...");
				driver.navigate().refresh();
				refreshAttempts++;

				// Wait a bit before retrying
				Thread.sleep(2000); // Adjust this sleep time as necessary
			}
		}

		// If elements are still not found after 5 refresh attempts, throw an exception
		if (!allElementsLoaded) {
			throw new RuntimeException("Elements did not load after " + refreshAttempts + " refresh attempts.");
		}

		System.out.println("Page loaded successfully.");
	}

	
	//===========Retrieve the value from the page=============//
	public static void readValueFromPage() {
		  // Find the element containing the value you want to extract
        WebElement valueElement = driver.findElement(By.xpath("//span[@class='case_title']")); // Replace with the correct XPath

        // Retrieve the text from the element
        String value = valueElement.getText();

        // Print the value to the console
        System.out.println("The value retrieved from the page is: " + value);

        // Optionally, store the value for later verification
        // You can use any global or shared variable for this if needed.
	}
	
	
	// -----------Mouseover-----------//
	public static void mouseOverOnEle() {

		WebElement element = driver.findElement(By.xpath(
				"//div[@onmouseover='pega.c.cbe.processHoverEvent(event)']//preceding::span[@class='menu-item-title' and contains(text(),'Home')]"));

		// Create Actions object
		// Create Actions object
		Actions actions = new Actions(driver);

		// Perform mouse-over action (hover over)
		actions.moveToElement(element).perform();
	}
	// ---------dropdown-----------//

	public static void select_option_from_dropdown(String option, String dropdownId) {

		String selectedDropdwnXPath = p.getProperty(dropdownId);
		WebElement dropdownElement = driver.findElement(By.xpath(selectedDropdwnXPath));
//		Select dropdown = new Select(dropdownElement);
//		dropdown.selectByVisibleText(option); // Select by visible text

		if (dropdownElement.getTagName().equalsIgnoreCase("select")) {
			// If it's a <select> tag, use the Select class
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(option); // Select by visible text
		} else if (dropdownElement.getTagName().equalsIgnoreCase("input")) {
			// If it's an <input> tag (for searchable dropdowns)
			// Type the option into the input field
			dropdownElement.sendKeys(option);

		}

	}
	
	// ---------dropdown-----------//

	//---------------javascript button click-------------//
	public static void javascriptClick(String radiobtn) {
		WebElement radioButton = driver.findElement(By.xpath("//div[contains(text(),'Initial Outreach Calls Completed ?')]//following::input[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
	}
	
	
	
	// ------------Date-------------//

//	public static void selectDate(String date) {
//        // Fetch locators from the config file
//        String calendarInputLocator = p.getProperty("calendarInputLocator");
//        String calendarPopupXpath = p.getProperty("calendarPopupLocator");
//        String yearSelectorCss = p.getProperty("yearSelectorCss");
//        String monthSelectorCss = p.getProperty("monthSelectorCss");
//        String daySelectorXpath = p.getProperty("daySelectorXpath");
//
//        // Step 1: Open the calendar by clicking the input field
//        WebElement dateInputField = driver.findElement(By.xpath(calendarInputLocator));
//        dateInputField.click();
//
//        // Step 2: Wait for the calendar to be visible
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////        WebElement calendarPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(calendarPopupXpath)));
//
////        WebElement calenarPopup = driver.findElement(By.xpath(calendarPopupXpath));
//        
//        // Step 3: Extract day, month, and year from the date (format: dd-MM-yyyy)
//        String[] dateParts = date.split("-");
//        String day = dateParts[0];
//        String month = dateParts[1];
//        String year = dateParts[2];
//
//        // Step 4: Select the year, month, and day in the calendar
//        selectYear(year, yearSelectorXpath);
//        selectMonth(month, monthSelectorCss);
//        selectDay(day, daySelectorXpath);
//    }

//    private static void selectYear(String year, String yearSelectorXpath) {
//        // Open the year dropdown and select the desired year
//        WebElement yearDropdown = driver.findElement(By.cssSelector(yearSelectorXpath));
//        yearDropdown.click();
//        WebElement desiredYear = driver.findElement(By.xpath("//span[text()='" + year + "']"));
//        desiredYear.click();
//    }
//
//    private static void selectMonth(String month, String monthSelectorCss) {
//        // Open the month dropdown and select the desired month
//        WebElement monthDropdown = driver.findElement(By.cssSelector(monthSelectorCss));
//        monthDropdown.click();
//        WebElement desiredMonth = driver.findElement(By.xpath("//span[text()='" + month + "']"));
//        desiredMonth.click();
//    }
//
//    private static void selectDay(String day, String daySelectorXpath) {
//        // Select the day from the calendar
//        WebElement dayElement = driver.findElement(By.xpath(String.format(daySelectorXpath, day)));
//        dayElement.click();
//    }
//	

	public static void iSelectTheDate(String fullDate) {

		// Extract the year, month, and day from the provided string
		String[] dateParts = fullDate.split(" ");
		String month = dateParts[0];
		String year = dateParts[1];
		String day = dateParts[2];

//        WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the calendar input field
		WebElement calendarInput = driver.findElement(By.xpath(
				"//label[contains(text(),'Date of birth')]//following::input[1]//following::img[@class='inactvIcon'][1]"));
		calendarInput.click(); // Open the calendar

		// Select the year from the spinner dropdown
		WebElement yearSpinner = driver.findElement(By.id("yearSpinner"));
		yearSpinner.click(); // Click the year spinner to open the dropdown
		WebElement yearElement = driver.findElement(By.xpath("//span[text()='" + year + "']"));
		yearElement.click(); // Select the year

		// Select the month from the spinner dropdown
		WebElement monthSpinner = driver.findElement(By.id("monthSpinner"));
		monthSpinner.click(); // Click the month spinner to open the dropdown
		WebElement monthElement = driver.findElement(By.xpath("//span[text()='" + month + "']"));
		monthElement.click(); // Select the month

		// Wait for the calendar days to load and select the day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + day + "']")));
		WebElement dayElement = driver.findElement(By.xpath("//td[text()='" + day + "']"));
		dayElement.click(); // Select the day

	}

	public static Logger getLogger() {
		logger = LogManager.getLogger(); // Log4j
		return logger;
	}

	public static String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

}
