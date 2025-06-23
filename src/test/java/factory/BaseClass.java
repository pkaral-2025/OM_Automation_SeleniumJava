package factory;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	static String WebElement;
	private static WebDriverWait wait;
	
	
//	public static WebDriver initilizeBrowser() throws IOException {
//		
//		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
//			
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//
//			ChromeOptions options = new ChromeOptions();
////			options.addArguments("--disable-popup-blocking");
//			
//			
////			for Diagnosis code pop up setup
//			// Stealth options
//		    options.addArguments("--disable-blink-features=AutomationControlled");
//		    options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
//		    options.setExperimentalOption("useAutomationExtension", false);
//		    // Fake user agent to mimic real browser
//		    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/121.0 Safari/537.36");
//		    
//		    // Block popup blocker just in case
//		    options.addArguments("--disable-popup-blocking");
//		    options.addArguments("start-maximized");
//
//			
//		    // Inject JS to disable automation detection
//	        ((JavascriptExecutor) driver).executeScript("""
//	            Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
//	            window.navigator.chrome = { runtime: {} };
//	            Object.defineProperty(navigator, 'languages', { get: () => ['en-US', 'en'] });
//	            Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3] });
//	        """);
//		    
//			
//			// os
//			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
//				capabilities.setPlatform(Platform.WIN11);
//			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
//				capabilities.setPlatform(Platform.MAC);
//			} else {
//				System.out.println("No matching OS..");
//			}
//			// browser
//			switch (getProperties().getProperty("browser").toLowerCase()) {
//			case "chrome":
//				capabilities.setBrowserName("chrome");
//				break;
//			case "edge":
//				capabilities.setBrowserName("MicrosoftEdge");
//				break;
//			default:
//				System.out.println("No matching browser");
//			}
//
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
//			switch (getProperties().getProperty("browser").toLowerCase()) {
//			case "chrome":
//				driver = new ChromeDriver();
//
////				ChromeOptions options = new ChromeOptions();
////				options.addArguments("--start-maximized");
////				WebDriver driver = new ChromeDriver(options);
//
//				break;
//			case "edge":
//				driver = new EdgeDriver();
//				break;
//			default:
//				System.out.println("No matching browser");
//				driver = null;
//			}
//		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//
//		return driver;
//
//	}
//	
	
	
	
	
//	---------------New code for pop up handling and blank window appears------------------//

	public static WebDriver initializeBrowser() throws IOException {
	    ChromeOptions options = new ChromeOptions();

	    // Stealth and anti-detection options
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
	    options.setExperimentalOption("useAutomationExtension", false);
	    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/121.0 Safari/537.36");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("start-maximized");
	    options.addArguments("disable-infobars");

	    if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

	        // Platform setting
	        String os = getProperties().getProperty("os");
	        if ("windows".equalsIgnoreCase(os)) {
	            capabilities.setPlatform(Platform.WIN11);
	        } else if ("mac".equalsIgnoreCase(os)) {
	            capabilities.setPlatform(Platform.MAC);
	        }

	        // Browser setting
	        String browser = getProperties().getProperty("browser").toLowerCase();
	        if (browser.equals("chrome")) {
	            capabilities.setBrowserName("chrome");
	        } else if (browser.equals("edge")) {
	            capabilities.setBrowserName("MicrosoftEdge");
	        }

	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	    } else {
	        // Local execution
	        switch (getProperties().getProperty("browser").toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver(options);
	                break;
	            case "edge":
	                driver = new EdgeDriver(); // EdgeOptions can be applied similarly if needed
	                break;
	            default:
	                System.out.println("Unsupported browser for local execution.");
	        }
	    }

	    // Driver setup
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	    // Inject JavaScript to mask Selenium detection AFTER driver init
	    if (driver instanceof JavascriptExecutor js) {
	        js.executeScript("""
	            Object.defineProperty(navigator, 'webdriver', { get: () => undefined });
	            window.navigator.chrome = { runtime: {} };
	            Object.defineProperty(navigator, 'languages', { get: () => ['en-US', 'en'] });
	            Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3] });
	        """);
	    }

	    return driver;
	}
	
//	---------------New code for pop up handling and blank window appears------------------//
	
	
	
	
	
	
	
	
	
	
	
	
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


//	-----------click on button and handle popup-------------------//

	////////////////////////////////////
	
	
	 public static void clickDiagnosisButton(String buttonName) {
		 
			
	 	    WebElement diagnosisButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='ICaseInfOnQCase_pyWorkPage_69']")));
	        diagnosisButton.click();
	    }

	    public static void enterDiagnosisCodeInPopup(String code) {
	        WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//input[@name='$PpyWorkPage$pDiagnosisSearchCode']")));
	        inputField.clear();
	        inputField.sendKeys(code);
	    }

	    public static void clickSearchButtonInPopup() {
	    	
	    	WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='DiagnosisSearch_pyWorkPage_47']")));
	        searchButton.click();
	    }

	    public static void selectDiagnosisCheckbox() throws InterruptedException {
//	        WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(
//	                By.xpath("//input[@type='checkbox' and contains(@data-ctl, 'Checkbox') and contains(@data-click, 'SetDiagnosisCodeSelection')]")));
//	        checkbox.click();
	        
	    	WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
	    		    ExpectedConditions.elementToBeClickable(
	    		        By.xpath("//input[@type='checkbox' and contains(@data-ctl, 'Checkbox') and contains(@data-click, 'SetDiagnosisCodeSelection')]")));

	    		JavascriptExecutor js = (JavascriptExecutor) driver;
	    		js.executeScript("arguments[0].click();", checkbox);

	        
	        
	        Thread.sleep(1000);
	    }

	    public static void submitDiagnosisPopup() {
	    	
	        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='buttonTdMiddle']//button[@id='ModalButtonSubmit']")));
	        submitButton.click();
	        
	       
	        
	        
	        
	    }
	    
	    public static void switchToMainWindow() {
	        
	    	// Switch to main content from any frame/modal
	        driver.switchTo().defaultContent();

	        By diagnosisFieldLocator = By.xpath("//input[@name='$PpyWorkPage$pDX']");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for the field to be visible
	        WebElement mainWinField = wait.until(ExpectedConditions.visibilityOfElementLocated(diagnosisFieldLocator));

	        // Wait for the value to be non-empty (i.e., populated with the selected code)
	        wait.until(driver -> {
	            String value = driver.findElement(diagnosisFieldLocator).getAttribute("value").trim();
	            System.out.println("Diagnosis field value (polling): '" + value + "'");
	            return !value.isEmpty();
	        });

	        System.out.println("Successfully switched back to main window and found populated value: " +
	            driver.findElement(diagnosisFieldLocator).getAttribute("value"));
	    }
	    
	    
	    

	    public static String getMainWindowDiagnosisCode() {
//	        WebElement codeField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(
//	                By.xpath("//input[@name='$PpyWorkPage$pDX']")));
//	        return codeField.getAttribute("value");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        wait.until(driver -> {
	            String val = driver.findElement(By.xpath("//input[@name='$PpyWorkPage$pDX']")).getAttribute("value");
	            System.out.println("Diagnosis field value (polling): '" + val + "'");
	            return val != null && !val.trim().isEmpty();
	        });
			return WebElement;
	        
	       	        
	    }
	
	
	    public static void setDiagnosisFieldManually(String code) {
	        try {
	            // Set the value directly via JavaScript
	            ((JavascriptExecutor) driver).executeScript(
	                "document.getElementByName('$PpyWorkPage$pDX').value = arguments[0];", code
	            );

	            // Optional: Add a small pause or verification
	            Thread.sleep(1000);

	            // Optional log
	            System.out.println("Diagnosis code manually set to: " + code);

	        } catch (Exception e) {
	            System.err.println("Failed to set diagnosis code manually: " + e.getMessage());
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////
	
	public static String getSelectedCheckboxValue() {
	    List<WebElement> selectedCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));
	    if (!selectedCheckboxes.isEmpty()) {
	        WebElement cb = selectedCheckboxes.get(0);
	        String val = cb.getAttribute("value");
	        if (val == null || val.isEmpty()) {
	            val = cb.getAttribute("data-value");
	        }
	        if (val == null || val.isEmpty()) {
	            val = cb.getAttribute("id");
	        }
	        return val != null ? val : "";
	    }
	    return "";
	}

	
	public static void clickSubmitAndHandleUnexpectedPopup(String submitButtonlocator) throws InterruptedException {
	    try {
	        // Block window.open popups temporarily
	        ((JavascriptExecutor) driver).executeScript("window.open = function() { console.log('Blocked window.open call'); }");

	        // Use fixed XPath as requested
	        String submitButtonXPath = "//button[@id='ModalButtonSubmit']";

	        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.elementToBeClickable(By.xpath(submitButtonXPath)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

	        String originalWindow = driver.getWindowHandle();
	        Set<String> oldWindows = driver.getWindowHandles();

	        // Capture selected checkbox value BEFORE submit
	        String selectedValue = getSelectedCheckboxValue();
	        System.out.println("Selected checkbox value before submit: " + selectedValue);

	        submitButton.click();
	        System.out.println("Clicked submit button");

	        Thread.sleep(1000);

	        // Handle unexpected popup window if opened
	        Set<String> allWindows = driver.getWindowHandles();
	        if (allWindows.size() > oldWindows.size()) {
	            allWindows.removeAll(oldWindows);
	            String unexpectedWindow = allWindows.iterator().next();

	            driver.switchTo().window(unexpectedWindow);
	            Thread.sleep(500);
	            driver.close();
	            driver.switchTo().window(originalWindow);
	            System.out.println("Closed unexpected popup and returned to original window");
	        }

	        // Re-find element after modal closes / page updates
	        WebElement resultElement = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfElementLocated(By.id("DiagnosisCodeResult")));

	        // Retry logic for stale element
	        int attempts = 0;
	        while (attempts < 2) {
	            try {
	                String tagName = resultElement.getTagName();
	                if (tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("textarea")) {
	                    resultElement.clear();
	                    resultElement.sendKeys(selectedValue);
	                } else {
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].textContent = arguments[1];", resultElement, selectedValue);
	                }
	                System.out.println("Inserted selected diagnosis code into main window.");
	                break; // success
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, retrying to find element...");
	                Thread.sleep(500);
	                resultElement = new WebDriverWait(driver, Duration.ofSeconds(10))
	                        .until(ExpectedConditions.visibilityOfElementLocated(By.id("DiagnosisCodeResult")));
	            }
	            attempts++;
	        }

	    } catch (TimeoutException e) {
	        System.out.println("Element not found or not clickable in time.");
	    } catch (NoSuchWindowException e) {
	        System.out.println("Window was closed unexpectedly.");
	    } catch (Exception e) {
	        System.out.println("Unexpected error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
//	-----------click on button and handle popup-------------------//
	
	
	
	
	
	
	
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

	//  checkbox click
	
	public static WebElement selectCheckboxById(String checkboxId) {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='DiagnosisSearch_pyWorkPage_47']//following::div[@class='oflowDivM ']//input[2]")));
	    
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }
		return checkbox;
	}

	
	//  wait for overlay to disappear
	
	public static void waitForOverlayToDisappear() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pega_ui_busyIndicator pz-po-l']")));
	
	 // Wait until overlay is not visible or not present at all
	    wait.until(driver -> {
	        try {
	            WebElement overlay = driver.findElement(By.xpath("//div[@class='pega_ui_busyIndicator pz-po-l']"));
	            return !overlay.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return true; // Overlay is not in the DOM, so it's "gone"
	        }
	    });
	    
	    
	    
	    
	    
	    try {
	        Thread.sleep(500);  // Not ideal, but helps in stubborn UI timing issues
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
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

	// ===========Retrieve the value from the page=============//
	public static void readValueFromPage() {
		// Find the element containing the value you want to extract
		WebElement valueElement = driver.findElement(By.xpath("//span[@class='case_title']")); // Replace with the
																								// correct XPath

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

	// ---------------javascript button click-------------//
	public static void javascriptClick(String radiobtn) {
		WebElement radioButton = driver.findElement(
				By.xpath("//div[contains(text(),'Initial Outreach Calls Completed ?')]//following::input[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
	}

	public static void javascriptClickOnBenefitInformationRelationbtn(String radiobtn) {
		WebElement radioButton = driver.findElement(By.xpath(
				"//h2[contains(text(),'Capture Benefit Information')]//following::input[@name='$PpyWorkPage$pPrePrimaryPayorBenefitInformation$pPrimary_Insurance_Relationship'][1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
	}

//----------Send fax receipt to referral for order confirmation----------//
	public static void javascriptClickOnSendFaxRadioBtn(String radiobtn) {
		WebElement radioButton = driver.findElement(
				By.xpath("//label[contains(text(),'Send fax receipt to referral for order confirmation?')]//following::input[@name='$PpyWorkPage$pIsReferralFaxConfirm'][1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
	}

	
	public static void javascriptClickOnDiagnosisModalSubmit_btn(String btn) throws InterruptedException {
	    try {
	        // Store the current window handle (in case a new window is opened)
	        String mainWindow = driver.getWindowHandle();

	        // Locate the checkbox inside the modal
	        WebElement modalCheckbox = driver
	                .findElement(By.xpath("//button[@id='ModalButtonSubmit']//preceding::input[@type='checkbox']"));

	        // Use JavaScriptExecutor to click the checkbox (if normal click doesn't work)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", modalCheckbox);

	        // Wait for the modal or any potential alert/popup to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Debugging: Print the page source to check if modalId is visible in the DOM
	        System.out.println(driver.getPageSource()); // Helps to see if modalId is available

	        // Wait for a specific element inside the modal (like a submit button or a visible div)
	        WebElement submitButton = wait
	                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ModalButtonSubmit']")));

	        // Now, click the button (submit the form inside the modal)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

	        // Handle unexpected pop-ups (like new windows)
	        Set<String> windowHandles = driver.getWindowHandles();
	        for (String handle : windowHandles) {
	            if (!handle.equals(mainWindow)) {
	                driver.switchTo().window(handle); // Switch to the new window

	                // Check if the window is blank by checking the title or content
	                if (driver.getTitle().isEmpty() || driver.getPageSource().isEmpty()) {
	                    driver.close(); // Close the blank window
	                } else {
	                    // If the window has content, we can assume it's the correct pop-up, so break out of the loop
	                    break;
	                }
	            }
	        }

	        // Switch back to the main window (the modal window)
	        driver.switchTo().window(mainWindow);

	        // Handle any alerts that might pop up after submitting
	        try {
	            Alert alert = driver.switchTo().alert(); // Check if an alert is present
	            alert.accept(); // Accept (close) the alert
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present.");
	        }

	        // Handle error modals (if there's a specific "error" window after submission)
	        try {
	            WebElement errorModal = driver.findElement(By.xpath("//div[contains(@class,'error-modal')]"));
	            if (errorModal.isDisplayed()) {
	                System.out.println("Error window detected!");
	                WebElement errorMessage = errorModal.findElement(By.xpath(".//p[@class='error-message']"));
	                System.out.println("Error message: " + errorMessage.getText());
	                WebElement closeButton = errorModal.findElement(By.xpath(".//button[contains(@class,'close')]"));
	                closeButton.click(); // Close the error modal
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("No error modal detected.");
	        }

	        // Now the modal should be ready for further interaction
	        // Example: Interact with elements inside the modal
	        // WebElement submitButton = driver.findElement(By.id("submitBtn"));
	        // submitButton.click();

	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	        // Handle other exceptions as necessary (e.g., logging, retries)
	    }
	}
	

	public static void validateText(String expectedText) {

		// Find the element containing the text
		WebElement element = driver.findElement(By.xpath(
				"//div[contains(text(),'Thank you! The next step in this case has been routed appropriately.')]"));
		String actualText = element.getText();

		// Assert that the expected text matches the actual text
		assertEquals(expectedText, actualText);

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
