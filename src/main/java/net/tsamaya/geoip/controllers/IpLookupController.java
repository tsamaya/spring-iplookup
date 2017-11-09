package net.tsamaya.geoip.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.tsamaya.geoip.IpLocationBadRequestException;
import net.tsamaya.geoip.IpLocationNotFoundExcepption;
import net.tsamaya.geoip.domain.GeoIpLocation;
import net.tsamaya.geoip.services.IpLookupService;

@RestController
public class IpLookupController {
	private static final Logger log = LoggerFactory.getLogger(IpLookupController.class);

	@Autowired
	private IpLookupService iplookupService;

	@RequestMapping(value = "/iplookup", method = RequestMethod.GET)
	public ResponseEntity<GeoIpLocation> ipLookup(
			@RequestHeader(value = "X-Forwarded-For", required = false) String xff,
			@RequestParam(value = "ip", required = false) String ip) throws IpLocationBadRequestException {
		if (log.isDebugEnabled()) {
			log.debug("/iplookup with ip [{}] and forwarded header [{}]", ip, xff);
		}
		if (ip == null && xff == null) {
			throw new IpLocationBadRequestException();
		}

		String ipToLookup = null;
		if (ip != null) {
			ipToLookup = ip;
		} else {
			// consider only the first IP in the comma separated list
			ipToLookup = xff.split(",")[0];
		}
		GeoIpLocation result = iplookupService.lookup(ipToLookup);
		if (result == null) {
			throw new IpLocationNotFoundExcepption(ipToLookup);
		}
		return ResponseEntity.ok(result);
	}

}
