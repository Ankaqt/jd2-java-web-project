package by.htp.dao.exception;

public class ConnectionPoolException extends Exception {

	private static final long serialVersionUID = 8105713687769771091L;

	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}

}
