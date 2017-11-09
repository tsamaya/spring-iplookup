package net.tsamaya.geoip;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not found IP Location")
public class IpLocationNotFoundExcepption extends RuntimeException {

	public IpLocationNotFoundExcepption() {
	}

	public IpLocationNotFoundExcepption(String message) {
		super(message);
	}

	public IpLocationNotFoundExcepption(Throwable cause) {
		super(cause);
	}

	public IpLocationNotFoundExcepption(String message, Throwable cause) {
		super(message, cause);
	}

	public IpLocationNotFoundExcepption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
