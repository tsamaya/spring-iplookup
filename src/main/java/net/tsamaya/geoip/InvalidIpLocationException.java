package net.tsamaya.geoip;

public class InvalidIpLocationException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidIpLocationException() {
		super();
	}

	public InvalidIpLocationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidIpLocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidIpLocationException(String message) {
		super(message);
	}

	public InvalidIpLocationException(Throwable cause) {
		super(cause);
	}

}
