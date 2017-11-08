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

import net.tsamaya.geoip.InvalidIpLocationException;
import net.tsamaya.geoip.domain.GeoIpLocation;
import net.tsamaya.geoip.services.IpLookupService;

@RestController
public class IpLookupController {
	private static final Logger log = LoggerFactory.getLogger(IpLookupController.class);
	
	@Autowired
	private IpLookupService iplookupService;

	// TODO: not yet finished
	@RequestMapping(value = "/iplookup", method = RequestMethod.GET)
	public ResponseEntity<GeoIpLocation> ipLookup(@RequestHeader(value = "X-Forwarded-For", required = false ) String xff, 
												 @RequestParam(value = "ip", required = false) String ip) throws InvalidIpLocationException {
		if(log.isDebugEnabled()) {
			log.debug("/iplookup with ip [{}] and forwarded header [{}]", ip, xff);
		}
		String ipToLookup; 
		if(ip!=null) {
			ipToLookup = ip;
		} else {
			ipToLookup = xff;
		}
		GeoIpLocation result = iplookupService.lookup(ipToLookup);
		
		return ResponseEntity.ok(result);
	}

}