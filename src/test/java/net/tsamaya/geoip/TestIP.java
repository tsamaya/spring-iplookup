package net.tsamaya.geoip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;

import junit.framework.TestCase;

public class TestIP extends TestCase {

	@Ignore
	public void testMaxmindFile() {
		
		// // A File object pointing to the GeoLite2 database
		File maxMndDbFile = new File("/path/to/spring-iplookup/src/main/resources/GeoLite2-Country.mmdb");		
		
		// This creates the DatabaseReader object. To improve performance, reuse
		// the object across lookups. The object is thread-safe.
		try {
			DatabaseReader reader = new DatabaseReader.Builder(maxMndDbFile).build();
			InetAddress ipAddress = InetAddress.getByName("128.101.101.101");
			CountryResponse country = reader.country(ipAddress);
			Assert.assertEquals("US",country.getCountry().getIsoCode());
		} catch (IOException | GeoIp2Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testMaxmindStream() {
		try {
			// // A File object pointing to your GeoIP2 or GeoLite2 database
			InputStream maxMndDbStream = TestIP.class.getResourceAsStream("/GeoLite2-Country.mmdb");
			// This creates the DatabaseReader object. To improve performance, reuse
			// the object across lookups. The object is thread-safe.
			DatabaseReader reader = new DatabaseReader.Builder(maxMndDbStream).build();
			InetAddress ipAddress = InetAddress.getByName("128.101.101.101");
			CountryResponse country = reader.country(ipAddress);
			Assert.assertEquals("US",country.getCountry().getIsoCode());
		} catch (IOException | GeoIp2Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
