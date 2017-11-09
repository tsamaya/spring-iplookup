package net.tsamaya.geoip;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid input parameters")
public class IpLocationBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IpLocationBadRequestException() {
		super();
	}

	public IpLocationBadRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IpLocationBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public IpLocationBadRequestException(String message) {
		super(message);
	}

	public IpLocationBadRequestException(Throwable cause) {
		super(cause);
	}

}
