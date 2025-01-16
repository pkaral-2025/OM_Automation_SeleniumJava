package stepDefinitions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import factory.EmailUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;

public class Hooks {

    WebDriver driver;
    Properties p;
    private static List<EmailUtil.TestCase> testCases = new ArrayList<>(); // Store results for all scenarios

    @Before
    public void setup() throws IOException {
        driver = BaseClass.initilizeBrowser();
        p = BaseClass.getProperties();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Prepare test case data to send in email
        String scenarioName = scenario.getName(); // Name of the scenario
        String scenarioStatus = scenario.getStatus().toString(); // Status of the scenario (Passed/Failed)
        String scenarioDuration = getScenarioDuration(scenario); // Duration of the test case execution

        // Use scenario name or create custom TestCase ID
        String testCaseId = "TC_" + scenarioName.replace(" ", "_");// Replace spaces in scenario name to avoid HTML issues
        
        // Dynamically adding the test case info
//        testCases.add(new EmailUtil.TestCase("TC_" + scenario.getId(), scenarioName, scenarioStatus, scenarioDuration));
        testCases.add(new EmailUtil.TestCase(testCaseId, scenarioName, scenarioStatus, scenarioDuration));
    }

    // Send the email after all scenarios using @AfterAll
    @AfterAll
    public static void sendReport() {
        try {
            if (!testCases.isEmpty()) {
                EmailUtil.sendEmail("priyanka.karalkar16@gmail.com", testCases);
                System.out.println("Test execution report sent successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to get the scenario duration (for illustration purposes)
    private String getScenarioDuration(Scenario scenario) {
        // In real-world applications, you can track the start time of the scenario and calculate the duration
        return "2m 30s";  // Placeholder
    }

    // Generate current time in HH:mm:ss format
    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}