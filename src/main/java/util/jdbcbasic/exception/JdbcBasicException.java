package util.jdbcbasic.exception;

public class JdbcBasicException extends Exception {

	public JdbcBasicException() {
		super();
	}

	public JdbcBasicException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JdbcBasicException(String message, Throwable cause) {
		super(message, cause);
	}

	public JdbcBasicException(String message) {
		super(message);
	}

	public JdbcBasicException(Throwable cause) {
		super(cause);
	}

}
