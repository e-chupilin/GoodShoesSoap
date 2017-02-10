package by.training.soap.service.business.exception;

public class GoodShoesPriceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GoodShoesPriceException() {
		super();
	}

	public GoodShoesPriceException(String message) {
		super(message);
	}

	public GoodShoesPriceException(Throwable cause) {
		super(cause);
	}

	public GoodShoesPriceException(String message, Throwable cause) {
		super(message, cause);
	}

}