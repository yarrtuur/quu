package java.ua.com.quu.utils;

public class ExitException extends Exception {

	public ExitException() {
	}

	public ExitException(String inException) {
		super(inException);
	}

	public ExitException(String inException, Throwable cause) {
		super(inException, cause);
	}
}
