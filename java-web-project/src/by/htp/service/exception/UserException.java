package by.htp.service.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = 4677982887112156399L;

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Exception e) {
		super(e);
	}

	public UserException(String message, Exception e) {
		super(message, e);
	}

}
