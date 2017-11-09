package net.tsamaya.geoip.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;

import net.tsamaya.geoip.domain.GeoIpLocation;
import net.tsamaya.geoip.domain.GeoIpLocationMaxMind;

@Service
public class IpLookupServiceMaxMindImpl implements IpLookupService {

	private static final Logger log = LoggerFactory.getLogger(IpLookupServiceMaxMindImpl.class);
	private static DatabaseReader reader = null;

	static {
		try {
			// A File object pointing to the GeoLite2 database
			// File maxMndDbFile = new
			// File("/path/to/spring-iplookup/src/main/resources/GeoLite2-Country.mmdb");
			// A Stream object pointing to the GeoLite2 database
			InputStream maxMndDbStream = IpLookupServiceMaxMindImpl.class.getResourceAsStream("/GeoLite2-Country.mmdb");

			// This creates the DatabaseReader object. To improve performance, reuse
			// the object across lookups. The object is thread-safe.
			reader = new DatabaseReader.Builder(maxMndDbStream).build();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public GeoIpLocation lookup(String ipv4) {		
		GeoIpLocation result = null;
		if (reader != null) {
			try {
				InetAddress ipAddress = InetAddress.getByName(ipv4);

				// Do the lookup
				CountryResponse countryResponse = reader.country(ipAddress);
				Country country = countryResponse.getCountry();
				result = new GeoIpLocationMaxMind(country.getName(), country.getIsoCode(), country.getGeoNameId(),
						ipv4);
			} catch (IOException | GeoIp2Exception e) {
				// if failing : only log warning message
				log.warn(e.getMessage());
			}
		}
		return result;
	}

}
