package customers;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
	void setLogger(ILogger logger);
}