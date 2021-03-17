package by.htp.dao.exception;

public class DBDriverLoadingException extends RuntimeException {

	private static final long serialVersionUID = 8579141553807431829L;

	public DBDriverLoadingException() {
		super();
	}

	public DBDriverLoadingException(String message) {
		super(message);
	}

	public DBDriverLoadingException(Exception e) {
		super(e);
	}

	public DBDriverLoadingException(String message, Exception e) {
		super(message, e);
	}

}
