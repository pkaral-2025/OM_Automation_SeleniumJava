package factory;

import javax.mail.*;
import javax.mail.internet.*;

import junit.framework.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EmailUtil {

	private static final String HOST = "relay.owens-minor.com";
	private static final String PORT = "25";
	private static final String FROM_EMAIL = "automateframework1@owens-minor.com";
	private static final String TO_EMAIL = "priyanka.karalkar@owens-minor.com";
	private static final String PASSWORD = "lacj qeda pvrc snhm";

	public static void sendEmail(String toEmail, List<TestCase> testCases) throws MessagingException {
		String subject = "Test Execution Report";
//        String emailBody = generateReport(results);

		// Set up email properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "relay.owens-minor.com");
		properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// Create a session and authenticate with the email account
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("automateframework1@gmail.com", "lacj qeda pvrc snhm");
			}
		});

		// Create the email content (HTML format)
		StringBuilder content = new StringBuilder();
		content.append("<html><body><h3>Test Execution Report</h3>");
		content.append(
				"<table border='1'><tr><th>Test Case ID</th><th>Description</th><th>Status</th><th>Time</th></tr>");

		for (TestCase testCase : testCases) {
			
//			 String statusColor = "#000000"; // Default color for status
//
//		        // Determine color based on status
//		        if ("PASSED".equalsIgnoreCase(testCase.getStatus())) {
//		        	   statusColor = "#28a745";  // Green for passed tests
//		        } else if ("FAILED".equalsIgnoreCase(testCase.getStatus())) {
//		        	statusColor = "#dc3545";// Red for failed tests
//		        }
			
			
			
			content.append("<tr>").append("<td>").append(testCase.getTestCaseId()).append("</td>").append("<td>")
					.append(testCase.getDescription()).append("</td>").append("<td>").append(testCase.getStatus())
					.append("</td>").append("<td>").append(testCase.getExecutionTime()).append("</td>").append("</tr>");
		}

		content.append("</table></body></html>");

		// Create the email message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROM_EMAIL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_EMAIL));
		message.setSubject("Automation Test Execution Report");

		// Set the content of the email
		message.setContent(content.toString(), "text/html");

		// Send the email
		Transport.send(message);
	}

	// TestCase class to store individual test case details
	public static class TestCase {
		private String testCaseId;
		private String description;
		private String status;
		private String executionTime;

		public TestCase(String testCaseId, String description, String status, String executionTime) {
			this.testCaseId = testCaseId;
			this.description = description;
			this.status = status;
			this.executionTime = executionTime;
		}

		public String getTestCaseId() {
			return testCaseId;
		}

		public String getDescription() {
			return description;
		}

		public String getStatus() {
			return status;
		}

		public String getExecutionTime() {
			return executionTime;
		}
	}

}
