package by.htp.service.exception;

public class NewsException extends Exception {

	private static final long serialVersionUID = 5270489532873011373L;

	public NewsException() {
		super();
	}

	public NewsException(String message) {
		super(message);
	}

	public NewsException(Exception e) {
		super(e);
	}

	public NewsException(String message, Exception e) {
		super(message, e);
	}

}
