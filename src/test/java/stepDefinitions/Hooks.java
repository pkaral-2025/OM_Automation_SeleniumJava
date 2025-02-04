package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
    private LocalDateTime startTime; // Track the start time of each scenario

    @Before
    public void setup() throws IOException {
        driver = BaseClass.initilizeBrowser();
        p = BaseClass.getProperties();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

        // Capture start time before each scenario starts
        startTime = LocalDateTime.now();
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Capture end time after each scenario finishes
        LocalDateTime endTime = LocalDateTime.now();
        
        // Calculate the duration between start and end time
        long durationInSeconds = Duration.between(startTime, endTime).getSeconds();

        // Convert the duration to a human-readable format (minutes and seconds)
        String durationFormatted = formatDuration(durationInSeconds);

        // Prepare test case data to send in email
        String scenarioName = scenario.getName(); // Name of the scenario
        String scenarioStatus = scenario.getStatus().toString(); // Status of the scenario (Passed/Failed)

        // Use scenario name or create custom TestCase ID
        String testCaseId = "TC_" + scenarioName.replace(" ", "_"); // Replace spaces in scenario name to avoid HTML issues

        // Dynamically adding the test case info
        testCases.add(new EmailUtil.TestCase(testCaseId, scenarioName, scenarioStatus, durationFormatted));
    }

    // Send the email after all scenarios using @AfterAll
    @AfterAll
    public static void sendReport() {
        try {
            if (!testCases.isEmpty()) {
                // Prepare the list of attachments (including Cucumber report)
                List<File> attachments = new ArrayList<>();

                // Attach the Cucumber HTML report (assuming it's generated in 'target/cucumber-reports')
                File cucumberReport = new File("reports/cucureport.html");
                if (cucumberReport.exists()) {
                    attachments.add(cucumberReport);
                }

                // Attach any other files like test logs, screenshots, etc.
                // Example: File testLog = new File("path/to/logfile.txt");
                // attachments.add(testLog);

                // Send the email with test case data and attachments
                EmailUtil.sendEmail("priyanka.karalkar@owens-minor.com", testCases, attachments);
                System.out.println("Test execution report sent successfully.");
                
                System.out.println("Cucumber Report exists: " + cucumberReport.exists());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert duration in seconds to a human-readable format (minutes and seconds)
    private String formatDuration(long durationInSeconds) {
        long minutes = durationInSeconds / 60;
        long seconds = durationInSeconds % 60;
        return String.format("%d min %d sec", minutes, seconds);
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