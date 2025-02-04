package factory;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.io.File;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

	private static final String HOST = "relay.owens-minor.com";
	private static final String PORT = "25";
	private static final String FROM_EMAIL = "SVC_automationreport@owens-minor.com";
	private static final String TO_EMAIL = "priyanka.karalkar@owens-minor.com";
	private static final String PASSWORD = "E3ISht*+Gj^weJD7LCRYk%2KsxZNBPyu";

	public static void sendEmail(String toEmail, List<TestCase> testCases, List<File> attachments)
			throws MessagingException {
		String subject = "Automation Test Execution Report";

		// Set up email properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "relay.owens-minor.com");
		properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// Create a session and authenticate with the email account
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("SVC_automationreport@owens-minor.com",
						"E3ISht*+Gj^weJD7LCRYk%2KsxZNBPyu");
			}
		});

		// Create the email content (HTML format)
		StringBuilder content = new StringBuilder();
		content.append("<html><body><h3>Automation Test Execution Report</h3>");
		content.append(
				"<table border='1'><tr><th>Test Case ID</th><th>Description</th><th>Status</th><th>Time</th></tr>");

		for (TestCase testCase : testCases) {
			content.append("<tr>").append("<td>").append(testCase.getTestCaseId()).append("</td>").append("<td>")
					.append(testCase.getDescription()).append("</td>").append("<td>").append(testCase.getStatus())
					.append("</td>").append("<td>").append(testCase.getExecutionTime()).append("</td>").append("</tr>");
		}

		content.append("</table></body></html>");

		// Create a Multipart message to send both the email body and the attachments
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROM_EMAIL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		message.setSubject(subject);

//		// Create a multipart message
//		Multipart multipart = new MimeMultipart();
//
//		// Add the email body (HTML format)
//		MimeBodyPart bodyPart = new MimeBodyPart();
//		bodyPart.setContent(content.toString(), "text/html");
//		multipart.addBodyPart(bodyPart);
//
//		// Add attachments to the email
//		for (File attachment : attachments) {
//			if (attachment.exists()) {
//				MimeBodyPart attachmentPart = new MimeBodyPart();
//				
//				DataSource source = new FileDataSource(attachment);
//				
//				attachmentPart.setDataHandler(new DataHandler(source));
//				attachmentPart.setFileName(attachment.getName());
//
//				
//				multipart.addBodyPart(attachmentPart);
//			}
//		}

		 Multipart multipart = new MimeMultipart();

	        // Add the email body (HTML format)
	        MimeBodyPart bodyPart = new MimeBodyPart();
	        bodyPart.setContent(content.toString(), "text/html; charset=UTF-8");
	        multipart.addBodyPart(bodyPart);

	        // Add attachments to the email
	        for (File attachment : attachments) {
	            if (attachment.exists()) {
	                MimeBodyPart attachmentPart = new MimeBodyPart();
	                
	                DataSource source = new FileDataSource(attachment);
	                attachmentPart.setDataHandler(new DataHandler(source));
	                attachmentPart.setFileName(attachment.getName());

	                // Explicitly set the MIME type as text/html for the Cucumber HTML report
	                if (attachment.getName().endsWith(".html")) {
	                    attachmentPart.setHeader("Content-Type", "text/html; charset=UTF-8");
	                }
	                
	                multipart.addBodyPart(attachmentPart);
	            }
	        }
		
		
		
		
		// Set the content of the message
		message.setContent(multipart);

		// Send the email
		Transport.send(message);

		System.out.println("Email with attachments sent successfully.");
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