package by.training.soap.service.business.exception;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
		this.message = message;
	}

	public DaoException(Throwable cause) {
		super(cause);
		this.message = cause.toString();
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String toString() {
		return "DaoException :" + message;
	}	
}