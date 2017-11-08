package net.tsamaya.geoip.services;

import net.tsamaya.geoip.domain.GeoIpLocation;

public interface IpLookupService {
	GeoIpLocation lookup(String ipv4);
}
